/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author carloszampieri
 */
public class Funcionario extends Cliente
{
    private String carteiraTrabalho;
    private String pisPasep;

    public Funcionario(String carteiraTrabalho, String pisPasep, 
            String rg, String cpf, int numPessoa, String nome, 
            String telefone, String email, 
            ArrayList<Domicilio> endereco)
    {
        super(rg, cpf, numPessoa, nome, telefone, email, endereco);
        this.carteiraTrabalho = carteiraTrabalho;
        this.pisPasep = pisPasep;
    }

    public String getCarteiraTrabalho() {
        return carteiraTrabalho;
    }

    public void setCarteiraTrabalho(String carteiraTrabalho) {
        this.carteiraTrabalho = carteiraTrabalho;
    }

    public String getPisPasep() {
        return pisPasep;
    }

    public void setPisPasep(String pisPasep) {
        this.pisPasep = pisPasep;
    }
    
}
