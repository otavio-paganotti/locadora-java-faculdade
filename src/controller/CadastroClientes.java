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
    
    public CadastroClientes() {
        this.listaClientes = new ArrayList<Cliente>();
        this.bd = new BancoDados();
    }
    
    public void adicionarCliente(Cliente cli) {
        this.bd.criarConexao();
        this.bd.insertSQL(cli.getSql());
        this.bd.fecharConexao();
    }

    public ArrayList<Cliente> getListaClientes() {
        return this.listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    public void adicionarCliente(String nome, String cpf, String telefone, String endereco) {
        this.bd.criarConexao();
        Cliente cliente = new Cliente(endereco, nome, cpf, telefone);
        System.out.println(cliente.getSql());
        this.bd.insertSQL(cliente.getSql());
        this.bd.fecharConexao();
    }
    
    public ArrayList<Cliente> removerCliente(String nome) {
        this.bd.criarConexao();
        this.bd.deleteSQL("DELETE FROM pessoa WHERE nome = '" + nome + "' AND tipo = '1'");
        ResultSet results = this.bd.querySQL("SELECT * FROM pessoa WHERE nome = '" + nome + "'");
        if (results != null) {
            try {
                while(results.next()) {
                    this.listaClientes.add(new Cliente(results.getString("endereco"), results.getString("nome"), results.getString("cpf"), results.getString("telefone")));
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
        this.bd.deleteSQL("DELETE FROM pessoa WHERE cpf = '" + cpf + "' AND tipo = '1'");
        ResultSet results = this.bd.querySQL("SELECT * FROM pessoa WHERE nome = '" + cpf + "'");
        if (results != null) {
            try {
                while(results.next()) {
                    this.listaClientes.add(new Cliente(results.getString("endereco"), results.getString("nome"), results.getString("cpf"), results.getString("telefone")));
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
        this.bd.deleteSQL("DELETE FROM pessoa WHERE cpf = '" + cli.getCpf() + "' AND tipo = '1'");
        this.bd.fecharConexao();
    }
    
    public ArrayList<Cliente> buscar(String nome) {
        this.bd.criarConexao();
        ResultSet resultados = this.bd.querySQL("SELECT * FROM pessoa WHERE nome = '" + nome + "' AND tipo = '1'");
        if (resultados != null) {
            try {
                while(resultados.next()) {
                    this.listaClientes.add(new model.Cliente(resultados.getString("endereco"), resultados.getString("nome"), resultados.getString("cpf"), resultados.getString("telefone"), resultados.getInt("idPessoa")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.listaClientes;
    }
    
    public ArrayList<Cliente> buscarCpf(String cpf) {
        this.bd.criarConexao();
        ResultSet resultados = this.bd.querySQL("SELECT * FROM pessoa WHERE cpf = '" + cpf + "' AND tipo = '1'");
        if (resultados != null) {
            try {
                while(resultados.next()) {
                    this.listaClientes.add(new model.Cliente(resultados.getString("endereco"), resultados.getString("nome"), resultados.getString("cpf"), resultados.getString("telefone"), resultados.getInt("idPessoa")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.listaClientes;
    }
}
