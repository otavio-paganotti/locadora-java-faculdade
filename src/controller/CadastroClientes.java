/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author 05213516181
 */
public class CadastroClientes {
    private BancoDados bd;
    private ArrayList<Cliente> listaClientes;

    public CadastroClientes(BancoDados bd) {
        this.listaClientes = new ArrayList<Cliente>();
        this.bd = bd;
    }
    
    public void adicionarCliente(Cliente cli) {
        this.bd.criarConexao();
        this.bd.insertSQL(cli.getSql());
        this.bd.fecharConexao();
    }
    
    public void adicionarCliente(String nome, int cpf, String telefone, String endereco) {
        this.bd.criarConexao();
        Cliente cliente = new Cliente(endereco, nome, cpf, telefone);
        this.bd.insertSQL(cliente.getSql());
        this.bd.fecharConexao();
    }
    
    public ArrayList<Cliente> removerCliente(String nome) {
        this.bd.criarConexao();
        this.bd.deleteSQL("DELETE * FROM pessoa WHERE nome = " + nome);
        ResultSet results = this.bd.querySQL("SELECT * FROM pessoa WHERE nome = " + nome);
        if (results != null) {
            try {
                while(results.next()) {
                    this.listaClientes.add(new Cliente(results.getString("endereco"), results.getString("nome"), results.getInt("cpf"), results.getString("telefone")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        this.bd.fecharConexao();
        return this.listaClientes;
    }
    
    public ArrayList<Cliente> removerCliente(int cpf) {
        this.bd.criarConexao();
        this.bd.deleteSQL("DELETE * FROM pessoa WHERE cpf = " + cpf);
        ResultSet results = this.bd.querySQL("SELECT * FROM pessoa WHERE pessoa.nome = " + cpf);
        if (results != null) {
            try {
                while(results.next()) {
                    this.listaClientes.add(new Cliente(results.getString("endereco"), results.getString("nome"), results.getInt("cpf"), results.getString("telefone")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        this.bd.fecharConexao();
        return this.listaClientes;
    }
    
    public void removerCliente(Cliente cli) {
        this.bd.criarConexao();
        this.bd.deleteSQL("DELETE * FROM pessoa WHERE cpf = " + cli.getCpf());
        this.bd.fecharConexao();
    }
    
    public ArrayList<Cliente> buscar(String nome) {
        this.bd.criarConexao();
        ResultSet resultados = this.bd.querySQL("SELECT * FROM cliente WHERE nome = " + nome);
        if (resultados != null) {
            try {
                while(resultados.next()) {
                    this.listaClientes.add(new model.Cliente(resultados.getString("endereco"), resultados.getString("nome"), resultados.getInt("cpf"), resultados.getString("telefone")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.listaClientes;
    }
    
    public ArrayList<Cliente> buscar(int cpf) {
        this.bd.criarConexao();
        ResultSet resultados = this.bd.querySQL("SELECT * FROM cliente WHERE cpf = " + cpf);
        if (resultados != null) {
            try {
                while(resultados.next()) {
                    this.listaClientes.add(new model.Cliente(resultados.getString("endereco"), resultados.getString("nome"), resultados.getInt("cpf"), resultados.getString("telefone")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.listaClientes;
    }
}
