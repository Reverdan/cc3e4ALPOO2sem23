package Modelo;

import DAL.PessoaDAO;
import java.util.List;

public class Controle
{
    public String mensagem;
    
    public void cadastrarPessoa(List<String> listaDadosPessoa)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarPessoa(listaDadosPessoa);
        if (validacao.mensagem.equals(""))
        {
            Pessoa pessoa = new Pessoa();
            pessoa.nome = listaDadosPessoa.get(0);
            pessoa.rg = listaDadosPessoa.get(1);
            pessoa.cpf = listaDadosPessoa.get(2);
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoaDAO.cadastrarPessoa(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
    }
}
