/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 05213516181
 */
public class BancoDados {
    private String caminhoBanco;
    private String login;
    private String senha;
    private Connection conexao;
    private Statement comando;

    public BancoDados() {
        this.caminhoBanco = "jdbc:mysql://localhost/prova02_v2";
        this.login = "root";
        this.senha = "root";
        this.conexao = null;
        this.comando = null;
    }
    
    public BancoDados(String caminhoBanco,String login,String senha) {
        this.caminhoBanco = caminhoBanco;
        this.login = login;
        this.senha = senha;
        this.conexao = null;
        this.comando = null;
    }
    
    public boolean criarConexao() {
        try
        {
            this.conexao = DriverManager.getConnection(this.caminhoBanco+"?useTimezone=true&serverTimezone=UTC",this.login,this.senha);
            this.comando = this.conexao.createStatement();
            System.out.println("Conexão estabelecida!");
            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean fecharConexao() {
        try
        {
            this.comando.close();
            this.conexao.close();
            System.out.println("Conexão fechada!");
            return false;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean insertSQL(String sql) {
        try {
            this.comando.executeUpdate(sql);
            System.out.println("Inserido!\n->"+sql);
            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteSQL(String sql) {
        try {
            this.comando.executeUpdate(sql);
            System.out.println("Deletado!\n->"+sql);
            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public ResultSet querySQL(String sql) {
        try {
            ResultSet res = this.comando.executeQuery(sql);
            System.out.println("Selecionado!\n->"+sql);
            return res;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        BancoDados bd = new BancoDados("jdbc:mysql://localhost/prova02_v2","root","root");
        bd.criarConexao();
        bd.insertSQL("INSERT INTO produto (idProduto, nome, categoria) VALUES ('1', 'Algum Filme', 'Suspense')");
        
        ResultSet resultados = bd.querySQL("SELECT * FROM produto");
        if (resultados!=null)
        {
            try
            {
                System.out.println ("\n\n");
                while (resultados.next())
                {
                    System.out.println ("Nome: " + resultados.getString("nome"));
                    System.out.println ("Categoria: " + resultados.getString("categoria")+"\n");
                }
                resultados.close();
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
        }    
        
        bd.fecharConexao();
    }
}
