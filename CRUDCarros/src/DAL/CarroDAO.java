package DAL;

import modelo.Carro;
import java.sql.*;

public class CarroDAO
{

    public String mensagem;

    public void cadastrarCarro(Carro carro)
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
            String comSql = "insert into carros "
                    + "(fabricante, modelo, cor, ano, valor) "
                    + "values(?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setString(1, carro.fabricante);
            stmt.setString(2, carro.modelo);
            stmt.setString(3, carro.cor);
            stmt.setString(4, carro.ano);
            stmt.setDouble(5, carro.valor);
            stmt.execute();
            this.mensagem = "Cadastro efetuado com sucesso!";
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

    public Carro pesquisarPorId(Carro carro)
    {
        return carro;
    }

    public void editarCarro(Carro carro)
    {

    }

    public void excluirCarro(Carro carro)
    {

    }
}
