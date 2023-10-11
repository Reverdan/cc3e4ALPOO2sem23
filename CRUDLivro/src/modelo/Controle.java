package modelo;

import DAL.LivroDAO;
import java.util.List;

public class Controle
{
    public String mensagem;
    
    public void cadastrarLivro(List<String> listaDadosLivro)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarLivro(listaDadosLivro);
        if (validacao.mensagem.equals(""))
        {
            Livro livro = new Livro();
            livro.setAutor(listaDadosLivro.get(0));
            livro.setTitulo(listaDadosLivro.get(1));
            livro.setNumPaginas(listaDadosLivro.get(2));
            livro.setEditora(listaDadosLivro.get(3));
            LivroDAO livroDAO = new LivroDAO();
            livroDAO.cadastrarLivro(livro);
            this.mensagem = livroDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
    }
}
