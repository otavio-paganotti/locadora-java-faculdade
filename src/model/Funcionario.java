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
    private boolean disponivel;

    public Funcionario(int numCarteira, int numTrabalhos, boolean disponivel, String nome, int cpf, String telefone) {
        super(nome, cpf, telefone);
        this.numCarteira = numCarteira;
        this.numTrabalhos = numTrabalhos;
        this.disponivel = disponivel;
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

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    public void comecarTrabalho() {
        this.disponivel = true;
    }
    
    public void encerrarTrabalho() {
        this.disponivel = false;
    }
    
    public String getSql() {
        return "INSERT INTO pessoa (numCarteira, numTrabalhos, disponivel, nome, cpf, telefone) VALUES ("
                + "'" + this.numCarteira + "',"
                + this.numTrabalhos + ","
                + "'" + this.disponivel + "',"
                + "'" + this.getNome() + "',"
                + "'" + this.getCpf() + "',"
                + "'" + this.getTelefone() + "',"
                + ")";
    }
    
    public String getId() {
        return "SELECT * FROM funcinario WHERE numCarteira = " + this.numCarteira;
    }

    @Override
    public void setPessoa(Pessoa p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
