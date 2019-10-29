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
public class Fornecedor extends Pessoa
{
    private String cnpj;

    public Fornecedor(String cnpj, int numPessoa, String nome,
            String telefone, String email, ArrayList<Domicilio> endereco)
    {
        super(numPessoa, nome, telefone, email, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
