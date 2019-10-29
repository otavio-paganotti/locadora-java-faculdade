/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelo.Domicilio;

/**
 *
 * @author cezam
 */
public class ControleDomicilio
{
    private ArrayList<Domicilio> listaDomicilio;
    
    public ControleDomicilio()
    {
        this.listaDomicilio = new ArrayList<Domicilio>();
    }
    public Domicilio getDomicilio(String logradouro,int numero,String bairro, String cidade,String estado,String complemento)
    {
        Domicilio busca = new Domicilio(false,logradouro,numero,bairro,cidade,estado,complemento);
        for (Domicilio d:this.listaDomicilio)
        {
            if (d.igual(busca))
            {
                return (Domicilio)d;
            }
        }
        return null;
    }
    
    private void removePrincipal(Domicilio domicilio)
    {
        if (domicilio.ehPrincipal())
        {
            for (Domicilio d:this.listaDomicilio)
            {
                if (d.ehPrincipal())
                {
                    d.setPrincipal(false);
                    return;
                }
            }
        }
    }
    
    public void adicionar(Domicilio nova)
    {
        this.removePrincipal(nova);
        if (!this.listaDomicilio.contains(nova))
        {
            this.listaDomicilio.add(nova);
        }
        else
        {
            int pos = this.listaDomicilio.indexOf(nova);
            if (pos>=0)
            {
                this.listaDomicilio.get(pos).setDomicilio(nova);
            }
        }
    }
    
    public boolean remover(Domicilio obj)
    {
        if (this.listaDomicilio.remove(obj))
        {
            if (obj.ehPrincipal() && !this.listaDomicilio.isEmpty())
            {
                this.listaDomicilio.get(0).setPrincipal(true);
            }
            return true;
        }
        return false;
    }
}
