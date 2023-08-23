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
            String comSql = "insert into pessoas "
                    + "(nome, rg, cpf) "
                    + "values(?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setString(1, pessoa.nome);
            stmt.setString(2, pessoa.rg);
            stmt.setString(3, pessoa.cpf);
            stmt.execute();
        } 
        catch (Exception e)
        {
            this.mensagem = "Erro de conexao BD";
        }
        finally
        {
            conexao.desconectar();
        }
    }
}
