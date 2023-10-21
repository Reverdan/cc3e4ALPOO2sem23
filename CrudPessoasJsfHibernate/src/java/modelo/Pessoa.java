/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rever
 */
@Entity
@Table(name = "pessoas")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByIdPessoa", query = "SELECT p FROM Pessoa p WHERE p.idPessoa = :idPessoa"),
    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pessoa.findByRg", query = "SELECT p FROM Pessoa p WHERE p.rg = :rg"),
    @NamedQuery(name = "Pessoa.findByCpf", query = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf")
})
public class Pessoa implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPessoa")
    private Integer idPessoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 11)
    @Column(name = "rg")
    private String rg;
    @Size(max = 13)
    @Column(name = "cpf")
    private String cpf;

    public Pessoa()
    {
    }

    public Pessoa(Integer idPessoa)
    {
        this.idPessoa = idPessoa;
    }

    public Pessoa(Integer idPessoa, String nome)
    {
        this.idPessoa = idPessoa;
        this.nome = nome;
    }

    public Integer getIdPessoa()
    {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa)
    {
        this.idPessoa = idPessoa;
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

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idPessoa != null ? idPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa))
        {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.idPessoa == null && other.idPessoa != null) || (this.idPessoa != null && !this.idPessoa.equals(other.idPessoa)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "modelo.Pessoa[ idPessoa=" + idPessoa + " ]";
    }
    
}
