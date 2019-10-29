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
public abstract class Pessoa
{
    private int numPessoa;
    private String nome;
    private String telefone;
    private String email;
    private ArrayList<Domicilio> endereco = null;
    
    public Pessoa(int numPessoa,String nome,
            String telefone,String email,
            ArrayList<Domicilio> endereco)
    {
        this.numPessoa = numPessoa;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public int getNumPessoa() {
        return numPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Domicilio> getEndereco() {
        return endereco;
    }
    
    public Domicilio getEndereco(int index)
    {        
        return this.endereco.get(index);
    }
    
    public Domicilio getEnderecoPrincipal()
    {        
        for (Domicilio d:this.endereco)
        {
            if (d.ehPrincipal())
            {
                return d;
            }
        }
        return null;
    }

    public void setEndereco(Domicilio novo,int index)
    {
        if (index>=0 && index<this.endereco.size())
        {
            if (novo.ehPrincipal())
            {
                for (int i=0;i<this.endereco.size();i++)
                {
                    if (i!=index && 
                         this.endereco.get(i).ehPrincipal())
                    {
                        this.endereco.get(i).setPrincipal(false);
                        break;
                    }
                }
            }
            this.endereco.set(index,novo);
        }
    }
    
    public boolean adicionarEndereco(Domicilio novo)
    {
        if (this.endereco.contains(novo))
        {
            this.setEndereco(novo,
                    this.endereco.indexOf(novo));
            return true;
        }
        else if (novo.ehPrincipal())
        {
            for (int i=0;i<this.endereco.size();i++)
            {
                
                if (this.endereco.get(i).ehPrincipal())
                {
                    this.endereco.get(i).setPrincipal(false);
                    break;
                }
            }
            this.endereco.add(novo);
            return true;
        }
        return false;
    }
}
