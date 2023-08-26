package DAL;

import java.sql.*;
import Modelo.Pessoa;

public class PessoaDAO
{

    public String mensagem;

    public void cadastrarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try
        {
            if (!conexao.mensagem.equals(""))
            {
                throw new Exception();
            }
            String comSql = "insert into pessoas "
                    + "(nome, rg, cpf) "
                    + "values(?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setString(1, pessoa.nome);
            stmt.setString(2, pessoa.rg);
            stmt.setString(3, pessoa.cpf);
            stmt.execute();
            this.mensagem = "Cadastro efetuado com sucesso!";
        } catch (Exception e)
        {
            this.mensagem = "Erro de conexao BD";
        } finally
        {
            conexao.desconectar();
        }
    }

    public Pessoa pesquisarPessoaPorId(Pessoa pessoa)
    {
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try
        {
            if (!conexao.mensagem.equals(""))
            {
                throw new Exception();
            }
            String comSql = "select * from pessoas "
                    + "where idPessoas = ?";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setInt(1, pessoa.idPessoa);
            ResultSet resultset = stmt.executeQuery();
            if (resultset.next())
            {
                pessoa.nome = resultset.getString("nome");
                pessoa.rg = resultset.getString("rg");
                pessoa.cpf = resultset.getString("cpf");
            }
            else
            {
                this.mensagem = "Não existe registro com este ID";
            }
            
        } 
        catch (Exception e)
        {
            this.mensagem = "Erro de conexao BD";
        } 
        finally
        {
            conexao.desconectar();
        }
        return pessoa;
    }

}
