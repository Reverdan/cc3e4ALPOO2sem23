package DAL;

import modelo.Endereco;
import java.sql.*;
import modelo.Pessoa;
import java.util.ArrayList;
import java.util.List;

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
                    for (Endereco e : pessoa.getEnderecoList())
                    {
                        comSql = "insert into enderecos "
                                + "(logradouro, numero, bairro, cidade, fk_idPessoas) "
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

    public Pessoa pesquisarPessoaPorId(Pessoa pessoa)
    {
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        if (!conexao.mensagem.equals(""))
        {
            this.mensagem = conexao.mensagem;
            return pessoa;
        }
        try
        {
            String comSql = "select * from pessoas "
                    + "join enderecos "
                    + "on enderecos.fk_idPessoas = pessoas.idPessoa "
                    + "where idPessoa = ?";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setInt(1, pessoa.getIdpessoa());
            ResultSet resultset = stmt.executeQuery();
            if (resultset.next())
            {
                pessoa.setNome(resultset.getString("nome"));
                pessoa.setRg(resultset.getString("rg"));
                pessoa.setCpf(resultset.getString("cpf"));
                Endereco endRes = new Endereco();
                Endereco endCom = new Endereco();
                
                endRes.setLogradouro(resultset.getString("logradouro"));
                endRes.setNumero(resultset.getString("numero"));
                endRes.setBairro(resultset.getString("bairro"));
                endRes.setCidade(resultset.getString("cidade"));
                if (resultset.next())
                {
                    endCom.setLogradouro(resultset.getString("logradouro"));
                    endCom.setNumero(resultset.getString("numero"));
                    endCom.setBairro(resultset.getString("bairro"));
                    endCom.setCidade(resultset.getString("cidade"));
                }
                List<Endereco> listaEnderecos = new ArrayList<>();
                if (endRes != null)
                    listaEnderecos.add(endRes);
                if (endCom != null)
                    listaEnderecos.add(endCom);
                pessoa.setEnderecoList(listaEnderecos);
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

    /*public void editarPessoa(Pessoa pessoa)
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
     String comSql = "update pessoas " +
     "set nome = ?, rg = ?, cpf = ? " +
     "where idPessoa = ?";
     PreparedStatement stmt = con.prepareStatement(comSql);
     stmt.setString(1, pessoa.nome);
     stmt.setString(2, pessoa.rg);
     stmt.setString(3, pessoa.cpf);
     stmt.setInt(4, pessoa.idPessoa);
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
    
     public void excluirPessoa(Pessoa pessoa)
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
     String comSql = "delete from pessoas " +
     "where idPessoa = ?";
     PreparedStatement stmt = con.prepareStatement(comSql);
     stmt.setInt(1, pessoa.idPessoa);
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
    
     public List<Pessoa> pesquisarPessoaPorNome(Pessoa pessoa)
     {
     this.mensagem = "";
     Conexao conexao = new Conexao();
     Connection con = conexao.conectar();
     List<Pessoa> listaPessoas = new ArrayList<>();
     if (!conexao.mensagem.equals(""))
     {
     this.mensagem = conexao.mensagem;
     return null;
     }
     try
     {
     String comSql = "select * from pessoas "
     + "where nome like ?";
     PreparedStatement stmt = con.prepareStatement(comSql);
     stmt.setString(1, pessoa.nome + "%");
     ResultSet resultset = stmt.executeQuery();
     while (resultset.next())
     {
     Pessoa pessoaResultado = new Pessoa();
     pessoaResultado.idPessoa = resultset.getInt("idPessoa");
     pessoaResultado.nome = resultset.getString("nome");
     pessoaResultado.rg = resultset.getString("rg");
     pessoaResultado.cpf = resultset.getString("cpf");
     listaPessoas.add(pessoaResultado);
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
     return listaPessoas;
     }*/
}
