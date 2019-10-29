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
public abstract class Pessoa {
    private String nome;
    private int numPessoa;
    private String telefone;
    private String email;
    private ArrayList<Domicilio> endereco = null;
    
        
    public Pessoa(String nome, int numPessoa, String telefone, String email, ArrayList<Domicilio> endereco) {
        this.nome = nome;
        this.numPessoa = numPessoa;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumPessoa() {
        return numPessoa;
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

    public Domicilio getEndereco(int index) {
        return this.endereco.get(index);
    }
    
    public Domicilio getEnderecoPrincipal() {
        for (Domicilio d:this.endereco) {
            if (d.ehPrincipal()) {
                return d;
            }
        }
        return null;
    }

    public void setEndereco(Domicilio novo, int index) {
        if (index >= 0 && index < this.endereco.size()) {
            if (novo.ehPrincipal()) {
                for (int i = 0; i < this.endereco.size(); i++) {
                    if (i != index && this.endereco.get(i).ehPrincipal()) {
                        this.endereco.get(i).setPrincipal(false);
                        break;
                    }
                }
            }
            this.endereco.set(index, novo);
        }
    }
    
    public boolean adicionarEndereco(Domicilio novo) {
        if (this.endereco.contains(novo)) {
            this.setEndereco(novo, this.endereco.indexOf(novo));
            return true;
        } else if (novo.ehPrincipal()) {
            for (int i = 0; i < this.endereco.size(); i++) {
                
                if (this.endereco.get(i).ehPrincipal()) {
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
