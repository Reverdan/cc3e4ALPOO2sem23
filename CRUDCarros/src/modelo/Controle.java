package modelo;

import DAL.CarroDAO;
import Modelo.Validacao;
import java.util.List;

public class Controle
{
    public String mensagem;
    
    public void cadastrarCarro(List<String> listaDadosCarro)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarCarro(listaDadosCarro);
        if (validacao.mensagem.equals(""))
        {
            Carro carro = new Carro();
            carro.fabricante = listaDadosCarro.get(1);
            carro.modelo = listaDadosCarro.get(2);
            carro.cor = listaDadosCarro.get(3);
            carro.ano = listaDadosCarro.get(4);
            carro.valor = validacao.valor;
            CarroDAO carroDAO = new CarroDAO();
            carroDAO.cadastrarCarro(carro);
            this.mensagem = carroDAO.mensagem;
        } 
        else
        {
            this.mensagem = validacao.mensagem;
        }
    }

    public Carro pesquisarPorId(String id)
    {
        this.mensagem = "";
        Carro carro = new Carro();
        Validacao validacao = new Validacao();
        validacao.validarId(id);
        if (validacao.mensagem.equals(""))
        {
            carro.idCarro = validacao.id;
            CarroDAO carroDAO = new CarroDAO();
            carro = carroDAO.pesquisarPorId(carro);
            this.mensagem = carroDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
        return carro;
    }

    public void editarCarro(List<String> listaDadosCarro)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarCarro(listaDadosCarro);
        if (validacao.mensagem.equals(""))
        {
            Carro carro = new Carro();
            carro.idCarro = validacao.id;
            carro.fabricante = listaDadosCarro.get(1);
            carro.modelo = listaDadosCarro.get(2);
            carro.cor = listaDadosCarro.get(3);
            carro.ano = listaDadosCarro.get(4);
            carro.valor = validacao.valor;
            CarroDAO carroDAO = new CarroDAO();
            carroDAO.editarCarro(carro);
            this.mensagem = carroDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
    }

    public void excluirCarro(String id)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarId(id);
        if (validacao.mensagem.equals(""))
        {
            Carro carro = new Carro();
            carro.idCarro = validacao.id;
            CarroDAO carroDAO = new CarroDAO();
            carroDAO.excluirCarro(carro);
            this.mensagem = carroDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
    }

}
