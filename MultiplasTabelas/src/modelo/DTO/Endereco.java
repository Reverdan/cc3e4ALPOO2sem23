/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.DTO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Rever
 */
@Entity
@Table(name = "enderecos")
@NamedQueries(
{
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findByIdEndereco", query = "SELECT e FROM Endereco e WHERE e.idEndereco = :idEndereco"),
    @NamedQuery(name = "Endereco.findByLogradouro", query = "SELECT e FROM Endereco e WHERE e.logradouro = :logradouro"),
    @NamedQuery(name = "Endereco.findByNumero", query = "SELECT e FROM Endereco e WHERE e.numero = :numero"),
    @NamedQuery(name = "Endereco.findByBairro", query = "SELECT e FROM Endereco e WHERE e.bairro = :bairro"),
    @NamedQuery(name = "Endereco.findByCidade", query = "SELECT e FROM Endereco e WHERE e.cidade = :cidade")
})
public class Endereco implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEndereco")
    private Integer idEndereco;
    @Column(name = "Logradouro")
    private String logradouro;
    @Column(name = "Numero")
    private String numero;
    @Column(name = "Bairro")
    private String bairro;
    @Column(name = "Cidade")
    private String cidade;
    @JoinColumn(name = "fk_idPessoa", referencedColumnName = "idPessoa")
    @ManyToOne
    private Pessoa fkidPessoa;

    public Endereco()
    {
    }

    public Endereco(Integer idEndereco)
    {
        this.idEndereco = idEndereco;
    }

    public Integer getIdEndereco()
    {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco)
    {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro()
    {
        return logradouro;
    }

    public void setLogradouro(String logradouro)
    {
        this.logradouro = logradouro;
    }

    public String getNumero()
    {
        return numero;
    }

    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    public String getBairro()
    {
        return bairro;
    }

    public void setBairro(String bairro)
    {
        this.bairro = bairro;
    }

    public String getCidade()
    {
        return cidade;
    }

    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }

    public Pessoa getFkidPessoa()
    {
        return fkidPessoa;
    }

    public void setFkidPessoa(Pessoa fkidPessoa)
    {
        this.fkidPessoa = fkidPessoa;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idEndereco != null ? idEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco))
        {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.idEndereco == null && other.idEndereco != null) || (this.idEndereco != null && !this.idEndereco.equals(other.idEndereco)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "modelo.Endereco[ idEndereco=" + idEndereco + " ]";
    }
    
}
