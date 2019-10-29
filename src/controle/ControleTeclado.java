/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author cezam
 */
public class ControleTeclado
{
    public String mascaraNumeros(String text,char c)
    {
        String numeros = "0123456789";

        String t = String.valueOf(c);
        
        if (!numeros.contains(t))
        {
            String txt = text;
            txt = txt.split(t)[0];
            return txt;
        }
        return text+t;
    }
}
