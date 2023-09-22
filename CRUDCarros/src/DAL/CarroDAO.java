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
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        if (!conexao.mensagem.equals(""))
        {
            this.mensagem = conexao.mensagem;
            return carro;
        }
        try
        {
            String comSql = "select * from carros "
                    + "where idCarro = ?";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setInt(1, carro.idCarro);
            ResultSet resultset = stmt.executeQuery();
            if (resultset.next())
            {
                carro.fabricante = resultset.getString("fabricante");
                carro.modelo = resultset.getString("modelo");
                carro.cor = resultset.getString("cor");
                carro.ano = resultset.getString("ano");
                carro.valor = resultset.getDouble("valor");
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
        return carro;
    }

    public void editarCarro(Carro carro)
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
            String comSql = "update carros "
                    + "set fabricante = ?, "
                    + "modelo = ?, "
                    + "cor = ?, "
                    + "ano = ?, "
                    + "valor = ? "
                    + "where idCarro = ?";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setString(1, carro.fabricante);
            stmt.setString(2, carro.modelo);
            stmt.setString(3, carro.cor);
            stmt.setString(4, carro.ano);
            stmt.setDouble(5, carro.valor);
            stmt.setInt(6, carro.idCarro);
            stmt.execute();
            this.mensagem = "Edição efetuada com sucesso!";
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

    public void excluirCarro(Carro carro)
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
            String comSql = "delete from carros " +
                        "where idCarro = ?";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setInt(1, carro.idCarro);
            stmt.execute();
            this.mensagem = "Exclusão efetuada com sucesso!";
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
