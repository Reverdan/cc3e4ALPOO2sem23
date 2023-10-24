package managedBean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Controle;

//@Named(value = "bgrCadastro")
@RequestScoped
@ManagedBean

public class bgrCadastro
{
    private String mensagem;
    private String nome;
    private String rg;
    private String cpf;
    
    public bgrCadastro()
    {
    }
    
    public String cadastrarPessoa()
    {
        this.mensagem = "";
        Controle controle = new Controle();
        List<String> listaDadosPessoa = new ArrayList<String>();
        listaDadosPessoa.add(nome);
        listaDadosPessoa.add(rg);
        listaDadosPessoa.add(cpf);
        controle.cadastrarPessoa(listaDadosPessoa);
        this.mensagem = controle.mensagem;
        return "/paginas/respostaCadastro";
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String mensagem)
    {
        this.mensagem = mensagem;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getRg()
    {
        return rg;
    }

    public void setRg(String rg)
    {
        this.rg = rg;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
    
    
}
