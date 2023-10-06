package modelo;

import DAL.PessoaDAO;
import java.util.ArrayList;
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
            Endereco endRes = new Endereco();
            Endereco endCom = new Endereco();
            List<Endereco> listaEnderecos = new ArrayList<>();
            
            pessoa.setNome(listaDadosPessoa.get(1));
            pessoa.setRg(listaDadosPessoa.get(2));
            pessoa.setCpf(listaDadosPessoa.get(3));
            
            endRes.setLogradouro(listaDadosPessoa.get(4));
            endRes.setNumero(listaDadosPessoa.get(5));
            endRes.setBairro(listaDadosPessoa.get(6));
            endRes.setCidade(listaDadosPessoa.get(7));
            
            endCom.setLogradouro(listaDadosPessoa.get(8));
            endCom.setNumero(listaDadosPessoa.get(9));
            endCom.setBairro(listaDadosPessoa.get(10));
            endCom.setCidade(listaDadosPessoa.get(11));
            
            listaEnderecos.add(endRes);
            listaEnderecos.add(endCom);
            
            pessoa.setEnderecoList(listaEnderecos);
            
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
            pessoa.setIdpessoa(validacao.id);
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
    
    /*public void editarPessoa(List<String> listaDadosPessoa)
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
    
    public List<Pessoa> pesquisarPessoaPorNome(String nome)
    {
        this.mensagem = "";
        Pessoa pessoa = new Pessoa();
        List<Pessoa> listaPessoas = new ArrayList<>();
        Validacao validacao = new Validacao();
        validacao.validarNome(nome);
        if (validacao.mensagem.equals(""))
        {
            pessoa.nome = nome;
            PessoaDAO pessoaDAO = new PessoaDAO();
            listaPessoas = pessoaDAO.pesquisarPessoaPorNome(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
        return listaPessoas;
    }*/
}
