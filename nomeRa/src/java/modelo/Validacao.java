package modelo;

import java.util.List;

public class Validacao
{
    public String mensagem;
    
    public void validarSmartphone(List<String> listaDadosSmartphone)
    {
        this.mensagem = "";
        for (String s : listaDadosSmartphone)
        {
            if (s.isEmpty()) 
            {
                this.mensagem = "Nenhum campo pode estar vazio";
                break;
            }
        }
    }
}
