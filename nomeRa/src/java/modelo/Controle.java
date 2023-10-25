package modelo;

import DAL.SmartphoneDAO;
import java.util.List;

public class Controle
{
    public String mensagem = "";
    
    public void cadastrarSmartphone(List<String> listaDadosSmartphone)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarSmartphone(listaDadosSmartphone);
        if (validacao.mensagem.equals(""))
        {
            Smartphone smartphone = new Smartphone();
            smartphone.setFabricante(listaDadosSmartphone.get(0));
            smartphone.setModelo(listaDadosSmartphone.get(1));
            smartphone.setSistemaOperacional(listaDadosSmartphone.get(2));
            smartphone.setCor(listaDadosSmartphone.get(3));
            SmartphoneDAO smartphoneDAO = new SmartphoneDAO();
            smartphoneDAO.cadastrarSmartphome(smartphone);
            this.mensagem = smartphoneDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
    }
}
