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
    private int idPessoa;

    public Cliente(String endereco, String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
        this.endereco = endereco;
    }
    
     public Cliente(String endereco, String nome, String cpf, String telefone, int idPessoa) {
        super(nome, cpf, telefone);
        this.endereco = endereco;
        this.idPessoa = idPessoa;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
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
        return "INSERT INTO pessoa (endereco,nome,cpf,telefone,tipo) VALUES ("
                + "'" + this.endereco + "',"
                + "'" + this.getNome() + "',"
                + "'" + this.getCpf() + "',"
                + "'" + this.getTelefone() + "',"
                + "'" + 1
                + "')";
    }
    
    public String getId() {
        return "SELECT * FROM pessoa WHERE nome = '" + this.getNome() + "'";
    }

    @Override
    public void setPessoa(Pessoa p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
