package modelo;

public class Controle
{
    public String resultado;
    
    public void executar(String num1, String num2)
    {
        this.resultado = "";
        Validacao validacao = new Validacao();
        validacao.validarNumeros(num1, num2);
        if (validacao.mensagem.equals(""))
        {
            Calculos calculos = new Calculos();
            this.resultado = 
                    calculos.somar(validacao.n1, validacao.n2);
        }
        else
        {
            this.resultado = validacao.mensagem;
        }
    }
}
