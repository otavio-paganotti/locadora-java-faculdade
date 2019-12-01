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
public class Produto {
    private String nome;
    private String categoria;

    public Produto(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public void imprimirDados() {
        System.out.println(
            "Nome do Filme: " + this.nome + "\n" +
            "Categoria: " + this.categoria
        );
    }
    
    public String getSql() {
        return "INSET INTO produto (nome, categoria) VALUES ("
                + "'" + this.nome + "',"
                + "'" + this.categoria + "'"
                + ")";
    }
    
    public String getId() {
        return "SELECT * FROM produto WHERE nome = " + this.nome;
    }
}
