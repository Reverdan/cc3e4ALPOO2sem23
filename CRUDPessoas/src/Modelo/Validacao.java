package Modelo;

import java.util.List;

public class Validacao
{
    public String mensagem;
    
    public void validarPessoa(List<String> listaDadosPessoa)
    {
        this.mensagem = "";
        if (listaDadosPessoa.get(0).length() < 3)
            this.mensagem += "Nome deve ter mais que 3 caracteres\n";
        if (listaDadosPessoa.get(0).length() > 50)
            this.mensagem += "Nome deve ter menos que 50 caracteres\n";
        if (listaDadosPessoa.get(1).length() > 10)
            this.mensagem += "RG deve ter menos que 10 caracteres\n";
        if (listaDadosPessoa.get(2).length() > 13)
            this.mensagem += "CPF deve ter menos que 13 caracteres\n";
    }
}
