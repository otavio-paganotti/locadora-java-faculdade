/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 05213516181
 */
public class Pedido {
    private Cliente cliente;
    private String data;
    private Funcionario funcionario;
    private int numPedido;
    private Produto produto;

    public Pedido(Cliente cliente, String data, Funcionario funcionario, int numPedido, Produto produto) {
        this.cliente = cliente;
        this.data = data;
        this.funcionario = funcionario;
        this.numPedido = numPedido;
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public void incluirCliente(String nome) {
        this.cliente.setNome(nome);
    }
    
    public void incluirCliente(int cpf) {
        this.cliente.setCpf(cpf);
    }
    
    public void incluirFuncionario(String nome) {
        this.funcionario.setNome(nome);
    }
    
    public void incluirFuncionario(int cpf) {
        this.funcionario.setCpf(cpf);
    }
    
    public void incluirProduto(Produto produto) {
        this.produto = produto;
    }
    
    public String getSql(int clienteId, int funcionarioId, int produtoId) {
        return "INSET INTO pedido (data, Cliente_idPessoa, Funcionario_idPessoa, Produto_idProduto) VALUES ("
                + "'" + this.data + "',"
                + "'" + clienteId + "',"
                + "'" + funcionarioId + "',"
                + "'" + produtoId + "'"
                + ")";
    }
}
