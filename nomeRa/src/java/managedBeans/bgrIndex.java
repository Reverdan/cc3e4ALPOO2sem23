package managedBeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Controle;

@ManagedBean
@RequestScoped
public class bgrIndex
{
    private String fabricante;
    private String modelo;
    private String sistemaOperacional;
    private String cor;
    private String resposta;
    
    public bgrIndex()
    {
    }
    
    public String cadastrarSmartphone()
    {
        List<String> listaDadosSmartphone = new ArrayList<String>();
        listaDadosSmartphone.add(fabricante);
        listaDadosSmartphone.add(modelo);
        listaDadosSmartphone.add(sistemaOperacional);
        listaDadosSmartphone.add(cor);
        Controle controle = new Controle();
        controle.cadastrarSmartphone(listaDadosSmartphone);
        this.resposta = controle.mensagem;
        return "/pagResposta";
    }

    public String getResposta()
    {
        return resposta;
    }

    public void setResposta(String resposta)
    {
        this.resposta = resposta;
    }

    public String getFabricante()
    {
        return fabricante;
    }

    public void setFabricante(String fabricante)
    {
        this.fabricante = fabricante;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public String getSistemaOperacional()
    {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional)
    {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getCor()
    {
        return cor;
    }

    public void setCor(String cor)
    {
        this.cor = cor;
    }
    
    
    
}
