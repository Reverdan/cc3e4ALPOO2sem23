package DAL;

import java.sql.*;
import modelo.DTO.Endereco;
import modelo.DTO.Pessoa;

public class PessoaDAO
{

    public String mensagem;

    public void cadastrarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        if (!conexao.mensagem.equals(""))
        {
            this.mensagem = conexao.mensagem;
            return;
        }
        try
        {
            String comSql = "insert into pessoas "
                    + "(nome, rg, cpf) "
                    + "values(?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(comSql, 
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getRg());
            stmt.setString(3, pessoa.getCpf());
            stmt.execute();
            ResultSet resultSet = stmt.getGeneratedKeys();
            if (resultSet.next())
            {
                int id = resultSet.getInt(1);
                if (!pessoa.getEnderecoList().isEmpty())
                {
                    for(Endereco e : pessoa.getEnderecoList())
                    {
                        comSql = "insert into enderecos "
                                + "(logradouro, numero, bairro, cidade, fk_idPessoa) "
                                + "values (?, ?, ?, ?, ?)";
                        stmt = con.prepareStatement(comSql);
                        stmt.setString(1, e.getLogradouro());
                        stmt.setString(2, e.getNumero());
                        stmt.setString(3, e.getBairro());
                        stmt.setString(4, e.getCidade());
                        stmt.setInt(5, id);
                        stmt.execute();
                    }
                }
                this.mensagem = "Cadastro efetuado com sucesso";
            }
        }
        catch (Exception e)
        {
            this.mensagem = "Erro de BD";
        }
        finally
        {
            conexao.desconectar();
        }
    }
}
