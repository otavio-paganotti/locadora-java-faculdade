/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author carloszampieri
 */
public class ControlePessoas
{
    private ArrayList<Pessoa> listaPessoas;
    
    public ControlePessoas()
    {
        this.listaPessoas = new ArrayList<Pessoa>();
    }
    public Cliente getCliente(String nome)
    {
        for (Pessoa p:this.listaPessoas)
        {
            if (p instanceof Cliente && p.getNome().equals(nome))
            {
                return (Cliente)p;
            }
        }
        return null;
    }
    /*public Cliente getCliente(String rg,String cpf)
    {
        
    }
    public Funcionario getFuncionario(String nome)
    {
        
    }*/
    public boolean adicionar(Pessoa nova)
    {
        if (!this.listaPessoas.contains(nova))
        {
            this.listaPessoas.add(nova);
            return true;
        }
        return false;
    }
    public boolean remover(Pessoa obj)
    {
        return this.listaPessoas.remove(obj);
    }
}
