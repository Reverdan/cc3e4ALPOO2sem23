package DAL;

import modelo.Livro;
import org.hibernate.Query;
import org.hibernate.Session;

public class LivroDAO
{
    public String mensagem;
    public Session session = Conexao.getSessionFactory().openSession();
    
    public void cadastrarLivro(Livro livro)
    {
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.save(livro);
            session.getTransaction().commit();
            session.flush();
            this.mensagem = "Livro cadastrado";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro de BD";
        }
        finally
        {
            session.close();
        }
    }
    
    public void editarLivro(Livro livro)
    {
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.saveOrUpdate(livro);
            session.getTransaction().commit();
            session.flush();
            this.mensagem = "Livro editado";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro de BD";
        }
        finally
        {
            session.close();
        }
    }
    
    public void excluirLivro(Livro livro)
    {
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.delete(livro);
            session.getTransaction().commit();
            session.flush();
            this.mensagem = "Livro excluido";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro de BD";
        }
        finally
        {
            session.close();
        }
    }
    
    public void pesquisarLivroPorId(Livro livro)
    {
        this.mensagem = "";
        try
        {
            Query query = session.createQuery("from Livro l where l.idlivro = :id");
            query.setParameter("id", livro.getIdlivro());
            if (query.list().size() > 0)
            {
                livro = (Livro) query.list().get(0);
            }
            else
            {
                this.mensagem = "Registro não encontrado";
            }
            session.flush();
        }
        catch (Exception e)
        {
            this.mensagem = "Erro de BD";
        }
        finally
        {
            session.close();
        }
    }
}
