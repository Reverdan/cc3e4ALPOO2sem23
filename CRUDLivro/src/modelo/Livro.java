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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rever
 */
@Entity
@Table(name = "livros")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l"),
    @NamedQuery(name = "Livro.findByIdlivro", query = "SELECT l FROM Livro l WHERE l.idlivro = :idlivro"),
    @NamedQuery(name = "Livro.findByAutor", query = "SELECT l FROM Livro l WHERE l.autor = :autor"),
    @NamedQuery(name = "Livro.findByTitulo", query = "SELECT l FROM Livro l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Livro.findByNumPaginas", query = "SELECT l FROM Livro l WHERE l.numPaginas = :numPaginas"),
    @NamedQuery(name = "Livro.findByEditora", query = "SELECT l FROM Livro l WHERE l.editora = :editora")
})
public class Livro implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlivro")
    private Integer idlivro;
    @Column(name = "autor")
    private String autor;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "num_paginas")
    private String numPaginas;
    @Column(name = "editora")
    private String editora;

    public Livro()
    {
    }

    public Livro(Integer idlivro)
    {
        this.idlivro = idlivro;
    }

    public Integer getIdlivro()
    {
        return idlivro;
    }

    public void setIdlivro(Integer idlivro)
    {
        this.idlivro = idlivro;
    }

    public String getAutor()
    {
        return autor;
    }

    public void setAutor(String autor)
    {
        this.autor = autor;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getNumPaginas()
    {
        return numPaginas;
    }

    public void setNumPaginas(String numPaginas)
    {
        this.numPaginas = numPaginas;
    }

    public String getEditora()
    {
        return editora;
    }

    public void setEditora(String editora)
    {
        this.editora = editora;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idlivro != null ? idlivro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro))
        {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.idlivro == null && other.idlivro != null) || (this.idlivro != null && !this.idlivro.equals(other.idlivro)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "modelo.Livro[ idlivro=" + idlivro + " ]";
    }
    
}
