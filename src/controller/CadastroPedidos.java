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
import model.Pedido;

/**
 *
 * @author 05213516181
 */
public class CadastroPedidos {
    private BancoDados bd;
    private ArrayList<Pedido> listaPedidos;

    public CadastroPedidos(BancoDados bd) {
        this.listaPedidos = new ArrayList<Pedido>();
        this.bd = bd;
    }
    
    public void adicionarPedido(Pedido pedido) {
        this.bd.criarConexao();
        ResultSet resultCliente = this.bd.querySQL("SELECT * FROM cliente WHERE nome = " + pedido.getCliente().getNome());
        ResultSet resultFuncionario = this.bd.querySQL("SELECT * FROM cliente WHERE nome = " + pedido.getFuncionario().getNome());
        ResultSet resultProduto = this.bd.querySQL("SELECT * FROM produto WHERE nome = " + pedido.getProduto().getNome());
        if (resultCliente != null && resultFuncionario != null && resultProduto != null) {
            try {
                this.bd.insertSQL(pedido.getSql(resultCliente.getInt("idPessoa"), resultFuncionario.getInt("idPessoa"), resultProduto.getInt("idProduto")));
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        this.bd.fecharConexao();
    }
    
    public void removerPedido(Pedido pedido) {
        this.bd.criarConexao();
        this.bd.deleteSQL("DELETE * FROM pedido WHERE pedido.numPedido = " + pedido.getNumPedido());
        this.bd.fecharConexao();
    }
    
    public void removerPedido(Cliente cliente) {
        this.bd.criarConexao();
        this.bd.deleteSQL("DELETE * FROM pedido WHERE Cliente_idPessoa = " + cliente.getId());
        this.bd.fecharConexao();
    }
}
