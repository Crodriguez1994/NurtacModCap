/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapNurtac.Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "bio_dias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BioDias.findAll", query = "SELECT b FROM BioDias b")
    , @NamedQuery(name = "BioDias.findByDiaid", query = "SELECT b FROM BioDias b WHERE b.diaid = :diaid")
    , @NamedQuery(name = "BioDias.findByFecha", query = "SELECT b FROM BioDias b WHERE b.fecha = :fecha")
    , @NamedQuery(name = "BioDias.findByNombre", query = "SELECT b FROM BioDias b WHERE b.nombre = :nombre")})
public class BioDias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "diaid")
    private Integer diaid;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 15)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "diaid")
    private List<CapDetahorarios> capDetahorariosList;

     public static int Id=0;
    public BioDias() {
    }

    public BioDias(Integer diaid) {
        this.diaid = diaid;
    }

    public Integer getDiaid() {
         if (diaid==null){
              Id =Id + 1;
            diaid = Id;
        }else{
            Id = diaid;
        }
        return diaid;
    }

    public void setDiaid(Integer diaid) {
        this.diaid = diaid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<CapDetahorarios> getCapDetahorariosList() {
        return capDetahorariosList;
    }

    public void setCapDetahorariosList(List<CapDetahorarios> capDetahorariosList) {
        this.capDetahorariosList = capDetahorariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diaid != null ? diaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BioDias)) {
            return false;
        }
        BioDias other = (BioDias) object;
        if ((this.diaid == null && other.diaid != null) || (this.diaid != null && !this.diaid.equals(other.diaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  Integer.toString(this.diaid);
    }
    
}
