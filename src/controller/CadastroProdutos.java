/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author 05213516181
 */
public class CadastroProdutos {
    private BancoDados bd;
    private ArrayList<Produto> listaProdutos;

    public CadastroProdutos(BancoDados bd) {
        this.listaProdutos = new ArrayList<Produto>();
        this.bd = bd;
    }

    public void adicionarProduto(Produto produto) {
        this.bd.criarConexao();
        this.bd.insertSQL(produto.getSql());
        this.bd.fecharConexao();
    }
    
    public void adicionarProduto(String nome, String categoria) {
        this.bd.criarConexao();
        Produto produto = new Produto(nome, categoria);
        this.bd.insertSQL(produto.getSql());
        this.bd.fecharConexao();
    }
    
    public ArrayList<Produto> removerProduto(String nome) {
        this.bd.criarConexao();
        this.bd.deleteSQL("DELETE * FROM produto WHERE nome = " + nome);
        ResultSet results = this.bd.querySQL("SELECT * FROM produto WHERE nome = " + nome);
        if (results != null) {
            try {
                while(results.next()) {
                    this.listaProdutos.add(new model.Produto(results.getString("nome"), results.getString("categoria")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        this.bd.fecharConexao();
        return this.listaProdutos;
    }
    
    public void removerProduto(Produto produto) {
        this.bd.criarConexao();
        this.bd.deleteSQL("DELETE * FROM pessoa WHERE nome = " + produto.getNome());
        this.bd.fecharConexao();
    }
    
    public ArrayList<Produto> buscar(String nome) {
        this.bd.criarConexao();
        ResultSet resultados = this.bd.querySQL("SELECT * FROM produto WHERE nome = " + nome);
        if (resultados != null) {
            try {
                while(resultados.next()) {
                    this.listaProdutos.add(new model.Produto(resultados.getString("nome"), resultados.getString("categoria")));
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        this.bd.fecharConexao();
        return this.listaProdutos;
    }
}
