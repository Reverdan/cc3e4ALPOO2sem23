package DAL;

import modelo.Pessoa;
import org.hibernate.Session;

public class PessoaDAO
{
    public String mensagem;
    public Session session = 
            Conexao.getSessionFactory().openSession();
    
    public void cadastrarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.save(pessoa);
            session.getTransaction().commit();
            session.close();
            this.mensagem = "Pessoa cadastrada com sucesso";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro de BD";
        }
    }
}
