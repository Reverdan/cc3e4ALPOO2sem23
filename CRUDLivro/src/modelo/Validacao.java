package modelo;

import java.util.List;

public class Validacao
{
    public String mensagem;
    
    public void validarLivro(List<String> listaDadosLivro)
    {
        this.mensagem = "";
        for (String s : listaDadosLivro)
        {
            if (s.isEmpty()) 
                this.mensagem = "Nenhum dado pode ser vazio";
        }
    }
}
