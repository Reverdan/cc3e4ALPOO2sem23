package modelo;

import java.util.List;
import DAL.PessoaDAO;

public class Controle
{
    public String mensagem;
    
    public void cadastrarPessoa(List<String> listaDadosPessoa)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarDadosPessoa(listaDadosPessoa);
        if (validacao.mensagem.equals(""))
        {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(listaDadosPessoa.get(0));
            pessoa.setRg(listaDadosPessoa.get(1));
            pessoa.setCpf(listaDadosPessoa.get(2));
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
