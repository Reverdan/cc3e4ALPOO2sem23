package managedBeans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Controle;

@Named(value = "bgrIndex")
@RequestScoped
@ManagedBean

public class bgrIndex
{
    private String num1;
    private String num2;
    private String resultado;
    
    public bgrIndex()
    {
    }
    
    public void somar()
    {
        Controle controle = new Controle();
        controle.executar(num1, num2);
        this.resultado = controle.resultado;
    }

    public String getNum1()
    {
        return num1;
    }

    public void setNum1(String num1)
    {
        this.num1 = num1;
    }

    public String getNum2()
    {
        return num2;
    }

    public void setNum2(String num2)
    {
        this.num2 = num2;
    }

    public String getResultado()
    {
        return resultado;
    }

    public void setResultado(String resultado)
    {
        this.resultado = resultado;
    }
    
    
}
