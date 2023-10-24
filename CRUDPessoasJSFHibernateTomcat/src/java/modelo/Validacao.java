package modelo;

import java.util.List;

public class Validacao
{
    public String mensagem;
    
    public void validarDadosPessoa(List<String> listaDadosPessoa)
    {
        this.mensagem = "";
        if (listaDadosPessoa.get(0).length() < 3)
            this.mensagem = "Nome deve ter mais que 3 caracteres";
    }
}
