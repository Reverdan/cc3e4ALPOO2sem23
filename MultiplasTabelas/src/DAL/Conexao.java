package DAL;
import java.sql.*;

public class Conexao
{
    public String stringConexao = ""
            + "jdbc:mysql://localhost:3306/ALPOO";
    private Connection con;
    public String mensagem;
    
    public Connection conectar()
    {
        this.mensagem = "";
        try
        {
            if (con == null || con.isClosed())
            {
                con = DriverManager.getConnection(
                        stringConexao, "root", "rever489");
            }
        } 
        catch (SQLException e)
        {
            this.mensagem = "Erro de conexâo com BD";
        }
        return con;
    }
    
    public void desconectar()
    {
        try
        {
            if (con != null && !con.isClosed())
            {
                con.close();
            }
        } 
        catch (SQLException e)
        {
            this.mensagem = "Erro ao fechar BD";
        }
    }
}
