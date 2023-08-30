package Modelo;

import java.util.List;

public class Validacao
{
    public String mensagem;
    public Integer id;
    
    public void validarId(String numId)
    {
        this.mensagem = "";
        try
        {
            this.id = Integer.valueOf(numId);
        } 
        catch (NumberFormatException e)
        {
            this.mensagem = "Digite um ID válido";
        }
    }
    
    public void validarPessoa(List<String> listaDadosPessoa)
    {
        this.mensagem = "";
        validarId(listaDadosPessoa.get(0));
        if (listaDadosPessoa.get(1).length() < 3)
            this.mensagem += "Nome deve ter mais que 3 caracteres\n";
        if (listaDadosPessoa.get(1).length() > 50)
            this.mensagem += "Nome deve ter menos que 50 caracteres\n";
        if (listaDadosPessoa.get(2).length() > 10)
            this.mensagem += "RG deve ter menos que 10 caracteres\n";
        if (listaDadosPessoa.get(3).length() > 13)
            this.mensagem += "CPF deve ter menos que 13 caracteres\n";
    }
}
