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
@Table(name = "smartphones")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Smartphone.findAll", query = "SELECT s FROM Smartphone s"),
    @NamedQuery(name = "Smartphone.findByIdsmartphone", query = "SELECT s FROM Smartphone s WHERE s.idsmartphone = :idsmartphone"),
    @NamedQuery(name = "Smartphone.findByFabricante", query = "SELECT s FROM Smartphone s WHERE s.fabricante = :fabricante"),
    @NamedQuery(name = "Smartphone.findByModelo", query = "SELECT s FROM Smartphone s WHERE s.modelo = :modelo"),
    @NamedQuery(name = "Smartphone.findBySistemaOperacional", query = "SELECT s FROM Smartphone s WHERE s.sistemaOperacional = :sistemaOperacional"),
    @NamedQuery(name = "Smartphone.findByCor", query = "SELECT s FROM Smartphone s WHERE s.cor = :cor")
})
public class Smartphone implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsmartphone")
    private Integer idsmartphone;
    @Column(name = "fabricante")
    private String fabricante;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "sistemaOperacional")
    private String sistemaOperacional;
    @Column(name = "cor")
    private String cor;

    public Smartphone()
    {
    }

    public Smartphone(Integer idsmartphone)
    {
        this.idsmartphone = idsmartphone;
    }

    public Integer getIdsmartphone()
    {
        return idsmartphone;
    }

    public void setIdsmartphone(Integer idsmartphone)
    {
        this.idsmartphone = idsmartphone;
    }

    public String getFabricante()
    {
        return fabricante;
    }

    public void setFabricante(String fabricante)
    {
        this.fabricante = fabricante;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public String getSistemaOperacional()
    {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional)
    {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getCor()
    {
        return cor;
    }

    public void setCor(String cor)
    {
        this.cor = cor;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idsmartphone != null ? idsmartphone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Smartphone))
        {
            return false;
        }
        Smartphone other = (Smartphone) object;
        if ((this.idsmartphone == null && other.idsmartphone != null) || (this.idsmartphone != null && !this.idsmartphone.equals(other.idsmartphone)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "modelo.Smartphone[ idsmartphone=" + idsmartphone + " ]";
    }
    
}
