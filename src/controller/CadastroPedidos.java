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
    
    public CadastroPedidos() {
        this.listaPedidos = new ArrayList<Pedido>();
        this.bd = new BancoDados();
    }
    
    public boolean adicionarPedido(Pedido pedido) {
        this.bd.criarConexao();
        System.out.println(pedido.getSql(pedido.getCliente().getIdPessoa(), pedido.getFuncionario().getIdPessoa(), pedido.getProduto().getIdProduto()));
        boolean retorno = this.bd.insertSQL(pedido.getSql(pedido.getCliente().getIdPessoa(), pedido.getFuncionario().getIdPessoa(), pedido.getProduto().getIdProduto()));
        this.bd.fecharConexao();
        return retorno;       
    }
    
    public void removerPedido(Pedido pedido) {
        this.bd.criarConexao();
        this.bd.deleteSQL("DELETE FROM pedido WHERE numPedido = '" + pedido.getNumPedido() + "'");
        this.bd.fecharConexao();
    }
    
    public void removerPedido(Cliente cliente) {
        this.bd.criarConexao();
        this.bd.deleteSQL("DELETE FROM pedido WHERE Cliente_idPessoa = '" + cliente.getId() + "'");
        this.bd.fecharConexao();
    }
}
