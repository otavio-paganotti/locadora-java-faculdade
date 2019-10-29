/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author 05213516181
 */
public class Cliente extends Pessoa {
    private String rg;
    private String cpf;

    public Cliente(String rg, String cpf, String nome, int numPessoa, String telefone, String email, ArrayList<Domicilio> endereco) {
        super(nome, numPessoa, telefone, email, endereco);
        this.rg = rg;
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
