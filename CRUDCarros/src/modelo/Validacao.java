package Modelo;

import java.util.List;

public class Validacao
{
    public String mensagem;
    public Integer id;
    public Double valor;
    
    public void validarValor(String valor)
    {
        this.mensagem = "";
        try
        {
            this.valor = Double.valueOf(valor);
        } 
        catch (NumberFormatException e)
        {
            this.mensagem = "Digite um ID válido";
        }
    }
    
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
    
    public void validarCarro(List<String> listaDadosCarro)
    {
        this.mensagem = "";
        validarId(listaDadosCarro.get(0));
        if (listaDadosCarro.get(1).length() == 0)
            this.mensagem += "Fabricante não pode ser vazio\n";
        if (listaDadosCarro.get(2).length() == 0)
            this.mensagem += "Modelo não pode ser vazio\n";
        if (listaDadosCarro.get(3).length() == 0)
            this.mensagem += "Cor não pode ser vazio\n";
        if (listaDadosCarro.get(4).length() != 4)
            this.mensagem += "Ano deve ter 4 caracteres\n";
        validarValor(listaDadosCarro.get(5));
    }
}

