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
public class Cliente extends Pessoa {
    private String endereco;

    public Cliente(String endereco, String nome, int cpf, String telefone) {
        super(nome, cpf, telefone);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public void imprimirDados() {
        System.out.println(
           "Nome: " + this.getNome() + "\n" +
           "CPF: " + this.getCpf() + "\n" +
           "Telefone: " + this.getTelefone() + "\n" +
           "Endereço: " + this.endereco
        );
    }
    
    public String getSql() {
        return "INSERT INTO cliente (endereco,nome,cpf,telefone) VALUES ("
                + "'" + this.endereco + "',"
                + this.getNome() + ","
                + "'" + this.getCpf() + "',"
                + "'" + this.getTelefone()
                + ")";
    }
    
    public String getId() {
        return "SELECT * FROM cliente WHERE nome = " + this.getNome();
    }

    @Override
    public void setPessoa(Pessoa p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
