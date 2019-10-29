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
public class Funcionario extends Cliente {
    private String numeroCarteiraTrabalho;
    private String pisPasep;

    public Funcionario(String numeroCarteiraTrabalho, String pisPasep, String rg, String cpf, String nome, int numPessoa, String telefone, String email, ArrayList<Domicilio> endereco) {
        super(rg, cpf, nome, numPessoa, telefone, email, endereco);
        this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
        this.pisPasep = pisPasep;
    }

    public String getNumeroCarteiraTrabalho() {
        return numeroCarteiraTrabalho;
    }

    public void setNumeroCarteiraTrabalho(String numeroCarteiraTrabalho) {
        this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
    }

    public String getPisPasep() {
        return pisPasep;
    }

    public void setPisPasep(String pisPasep) {
        this.pisPasep = pisPasep;
    }
    
    
    
}
