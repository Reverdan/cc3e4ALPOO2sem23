package multiplastabelas;

import DAL.PessoaDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.DTO.Endereco;
import modelo.DTO.Pessoa;

public class MultiplasTabelas
{
    public static void main(String[] args)
    {
        Pessoa pessoa = new Pessoa();
        Endereco endRes = new Endereco();
        Endereco endCom = new Endereco();
        List<Endereco> listaEnderecos = new ArrayList<>();
        
        pessoa.setNome("Oswaldo");
        pessoa.setRg("11111");
        pessoa.setCpf("22222");
        
        endRes.setLogradouro("Rua dos Manacas");
        endRes.setNumero("500");
        endRes.setBairro("Centro");
        endRes.setCidade("São Paulo");
        
        endCom.setLogradouro("Rua dos Juritis");
        endCom.setNumero("430");
        endCom.setBairro("Santa Cruz");
        endCom.setCidade("Sorocaba");
        
        listaEnderecos.add(endRes);
        listaEnderecos.add(endCom);
        
        pessoa.setEnderecoList(listaEnderecos);
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.cadastrarPessoa(pessoa);
    }
    
}
