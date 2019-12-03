/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Funcionario;

/**
 *
 * @author 05213516181
 */
public class CadastroFuncionarios {
    private BancoDados bd;
    private ArrayList<Funcionario> listaFuncionarios;

    public CadastroFuncionarios(BancoDados bd) {
        this.listaFuncionarios = new ArrayList<Funcionario>();
        this.bd = bd;
    }
    
    public CadastroFuncionarios() {
        this.listaFuncionarios = new ArrayList<Funcionario>();
        this.bd = new BancoDados();
    }
    public void adicionarFuncionario(Funcionario func) {
        this.bd.criarConexao();
        this.bd.insertSQL(func.getSql());
        this.bd.fecharConexao();
    }

    public ArrayList<Funcionario> getListaFuncionarios() {
        return this.listaFuncionarios;
    }

    public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }
    
    public void adicionarFuncionario(int numCarteira, String nome, String cpf, String telefone, String certificacao, int disponivel) {
        this.bd.criarConexao();
        Funcionario func = new Funcionario(numCarteira, 0, disponivel, nome, cpf, telefone);
        this.bd.insertSQL(func.getSql());
        this.bd.fecharConexao();
    }
    
    public ArrayList<Funcionario> removerFuncionario(String nome) {
        this.bd.criarConexao();
        this.bd.deleteSQL("DELETE FROM pessoa WHERE nome = '" + nome + "' AND tipo = '2'");
        ResultSet results = this.bd.querySQL("SELECT * FROM pessoa WHERE nome = '" + nome + "'");
        if (results != null) {
            try {
                while(results.next()) {
                    this.listaFuncionarios.add(new model.Funcionario(results.getInt("numCarteira"), results.getInt("numTrabalhos"), results.getInt("disponivel"), results.getString("nome"), results.getString("cpf"), results.getString("telefone")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        this.bd.fecharConexao();
        return this.listaFuncionarios;
    }
    
    public ArrayList<Funcionario> removerFuncionario(int numCarteira) {
        this.bd.criarConexao();
        this.bd.deleteSQL("DELETE FROM pessoa WHERE numCarteira = '" + numCarteira + "' AND tipo = '2'");
        ResultSet results = this.bd.querySQL("SELECT * FROM pessoa WHERE numCarteira = " + numCarteira);
        if (results != null) {
            try {
                while(results.next()) {
                    this.listaFuncionarios.add(new Funcionario(results.getInt("numCarteira"), results.getInt("numTrabalhos"), results.getInt("disponivel"), results.getString("nome"), results.getString("cpf"), results.getString("telefone")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        this.bd.fecharConexao();
        return this.listaFuncionarios;
    }
    
    public ArrayList<Funcionario> buscar(String nome) {
        this.bd.criarConexao();
        ResultSet resultados = this.bd.querySQL("SELECT * FROM pessoa WHERE nome = '" + nome + "' AND tipo = '2'");
        if (resultados != null) {
            try {
                while(resultados.next()) {
                    this.listaFuncionarios.add(new model.Funcionario(resultados.getInt("numCarteira"), resultados.getInt("numTrabalhos"), resultados.getInt("disponivel"), resultados.getString("nome"), resultados.getString("cpf"), resultados.getString("telefone"), resultados.getInt("idPessoa")));
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        this.bd.fecharConexao();
        return this.listaFuncionarios;
    }
    
    public ArrayList<Funcionario> buscar(int numCarteira) {
        this.bd.criarConexao();
        ResultSet resultados = this.bd.querySQL("SELECT * FROM pessoa WHERE numCarteira = '" + numCarteira + "' AND tipo = '2'");
        if (resultados != null) {
            try {
                while(resultados.next()) {
                    this.listaFuncionarios.add(new model.Funcionario(resultados.getInt("numCarteira"), resultados.getInt("numTrabalhos"), resultados.getInt("disponivel"), resultados.getString("nome"), resultados.getString("cpf"), resultados.getString("telefone"), resultados.getInt("idPessoa")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.listaFuncionarios;
    }
}
