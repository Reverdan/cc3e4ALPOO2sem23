package modelo;

import java.util.List;

public class Validacao
{
    public String mensagem = "";
    public Integer id;
    
    public void validarId(String numId)
    {
        try
        {
            this.id = Integer.valueOf(numId);
        } 
        catch (NumberFormatException e)
        {
            this.mensagem = "Digite um ID válido";
        }
    }
    
    public void validarNome(String nome)
    {
        if (nome.length() < 3)
            this.mensagem += "Nome deve ter mais que 3 caracteres\n";
        if (nome.length() > 50)
            this.mensagem += "Nome deve ter menos que 50 caracteres\n";
    }
    
    public void validarPessoa(List<String> listaDadosPessoa)
    {
        validarId(listaDadosPessoa.get(0));
        validarNome(listaDadosPessoa.get(1));
        if (listaDadosPessoa.get(2).length() > 10)
            this.mensagem += "RG deve ter menos que 10 caracteres\n";
        if (listaDadosPessoa.get(3).length() > 13)
            this.mensagem += "CPF deve ter menos que 13 caracteres\n";
        
    }
}
