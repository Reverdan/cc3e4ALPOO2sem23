package crudpessoas;

import DAL.PessoaDAO;
import Modelo.Pessoa;

public class CRUDPessoas
{
    public static void main(String[] args)
    {
        
        Pessoa pessoa = new Pessoa();
        pessoa.nome = "teste Crud";
        pessoa.rg = "teste rg";
        pessoa.cpf = "teste cpf";
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.cadastrarPessoa(pessoa);
    }
    
}
