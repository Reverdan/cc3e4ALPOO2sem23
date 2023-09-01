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
            pessoa.nome = listaDadosPessoa.get(1);
            pessoa.rg = listaDadosPessoa.get(2);
            pessoa.cpf = listaDadosPessoa.get(3);
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoaDAO.cadastrarPessoa(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
    }
    
    public Pessoa pesquisarPessoaPorId(String numId)
    {
        this.mensagem = "";
        Pessoa pessoa = new Pessoa();
        Validacao validacao = new Validacao();
        validacao.validarId(numId);
        if (validacao.mensagem.equals(""))
        {
            pessoa.idPessoa = validacao.id;
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoa = pessoaDAO.pesquisarPessoaPorId(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
        return pessoa;
    }
    
    public void editarPessoa(List<String> listaDadosPessoa)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarPessoa(listaDadosPessoa);
        if (validacao.mensagem.equals(""))
        {
            Pessoa pessoa = new Pessoa();
            pessoa.idPessoa = validacao.id;
            pessoa.nome = listaDadosPessoa.get(1);
            pessoa.rg = listaDadosPessoa.get(2);
            pessoa.cpf = listaDadosPessoa.get(3);
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoaDAO.editarPessoa(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
    }
    
    public void excluirPessoa(String numId)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarId(numId);
        if (validacao.mensagem.equals(""))
        {
            Pessoa pessoa = new Pessoa();
            pessoa.idPessoa = validacao.id;
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoaDAO.excluirPessoa(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
    }
}
