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
public abstract class Pessoa {
    private String nome;
    private int cpf;
    private String telefone;

    public Pessoa(String nome, int cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void imprimirDados() {
        System.out.println(
            "Nome: " + this.nome + "\n" +
            "CPF: " + this.cpf + "\n" +
            "Telefone: " + this.telefone
        );
    }
    
    public abstract void setPessoa(Pessoa p);
}
