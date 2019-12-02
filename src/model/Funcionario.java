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
public class Funcionario extends Pessoa {
    private int numCarteira;
    private int numTrabalhos;
    private int disponivel;
    private int idPessoa;

    public Funcionario(int numCarteira, int numTrabalhos, int disponivel, String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
        this.numCarteira = numCarteira;
        this.numTrabalhos = numTrabalhos;
        this.disponivel = disponivel;
    }
    
    public Funcionario(int numCarteira, int numTrabalhos, int disponivel, String nome, String cpf, String telefone, int idPessoa) {
        super(nome, cpf, telefone);
        this.numCarteira = numCarteira;
        this.numTrabalhos = numTrabalhos;
        this.disponivel = disponivel;
        this.idPessoa = idPessoa;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getNumCarteira() {
        return numCarteira;
    }

    public void setNumCarteira(int numCarteira) {
        this.numCarteira = numCarteira;
    }

    public int getNumTrabalhos() {
        return numTrabalhos;
    }

    public void setNumTrabalhos(int numTrabalhos) {
        this.numTrabalhos = numTrabalhos;
    }

    public int isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(int disponivel) {
        this.disponivel = disponivel;
    }
    
    public void comecarTrabalho() {
        this.disponivel = 1;
    }
    
    public void encerrarTrabalho() {
        this.disponivel = 0;
    }
    
    public String getSql() {
        return "INSERT INTO pessoa (numCarteira,numTrabalhos,disponivel,nome,cpf,telefone,tipo) VALUES ("
                + "'" + this.numCarteira + "',"
                + "'" + this.numTrabalhos + "',"
                + "'" + this.disponivel + "',"
                + "'" + this.getNome() + "',"
                + "'" + this.getCpf() + "',"
                + "'" + this.getTelefone() + "',"
                + "'" + 2 + "'"
                + ")";
    }
    
    @Override
    public void setPessoa(Pessoa p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
