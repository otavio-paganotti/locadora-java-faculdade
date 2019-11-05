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
public class Cliente extends Pessoa
{
    private String rg;
    private String cpf;

    public Cliente(String rg, String cpf, int numPessoa, String nome, String telefone, String email, ArrayList<Domicilio> endereco) {
        super(numPessoa, nome, telefone, email, endereco);
        this.rg = rg;
        this.cpf = cpf;
    }
    
    public boolean igual(Pessoa p)
    {
        Cliente cli = (Cliente)p;
        return (
                this.cpf.equals(cli.getCpf())&&
                this.rg.equals(cli.getRg())&&
                super.igual(cli)
               );
    }
    
    public void setPessoa(Pessoa p)
    {
        this.cpf = ((Cliente)p).getCpf();
        this.rg = ((Cliente)p).getRg();
        this.setNome(p.getNome());
        this.setEmail(p.getEmail());
        this.setTelefone(p.getTelefone());
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
