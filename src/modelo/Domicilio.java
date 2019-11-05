/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author carloszampieri
 */
public class Domicilio
{
    private boolean principal;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    
    public String getSql() {
        return "INSERT INTO DOMICILIO (logradouro,numero,bairro,cidade,estado,complemento) VALUES ("
                + "'"+this.logradouro+"',"
                + this.numero+","
                + "'" + this.bairro + "',"
                + "'" + this.cidade + "',"
                + "'" + this.estado + "',"
                + "'" + this.complemento + "'"
                + ")";
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Domicilio(boolean principal, String logradouro, 
        int numero, String bairro, String cidade, 
        String estado,String complemento)
    {
        this.principal = principal;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
    }
    
    public boolean ehPrincipal()
    {
        return this.principal;
    }

    public void setPrincipal(boolean valor) {
        this.principal = valor;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public boolean igual(Domicilio d)
    {
        return (
                this.logradouro.equals(d.getLogradouro())&&
                this.numero==d.getNumero()&&
                this.bairro.equals(d.getBairro())&&
                this.cidade.equals(d.getCidade())&&
                this.estado.equals(d.getEstado())&&
                this.complemento.equals(d.getComplemento())
               );
    }
    
    public void setDomicilio(Domicilio d)
    {
        this.principal = d.ehPrincipal();
        this.logradouro = d.getLogradouro();
        this.numero = d.getNumero();
        this.bairro = d.getBairro();
        this.cidade = d.getCidade();
        this.estado = d.getEstado();
        this.complemento = d.getComplemento();
    }
}
