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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cap_cabasistencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapCabasistencias.findAll", query = "SELECT c FROM CapCabasistencias c")
    , @NamedQuery(name = "CapCabasistencias.findByCabasistenciaid", query = "SELECT c FROM CapCabasistencias c WHERE c.cabasistenciaid = :cabasistenciaid")
    , @NamedQuery(name = "CapCabasistencias.findByEstado", query = "SELECT c FROM CapCabasistencias c WHERE c.estado = :estado")
    , @NamedQuery(name = "CapCabasistencias.findByFecha", query = "SELECT c FROM CapCabasistencias c WHERE c.fecha = :fecha")})
public class CapCabasistencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cabasistenciaid")
    private Integer cabasistenciaid;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capCabasistencias")
    private List<CapDetasistencias> capDetasistenciasList;
    @JoinColumn(name = "cabinscripcionid", referencedColumnName = "cabinscripcionid")
    @ManyToOne
    private CapCabinscripciones cabinscripcionid;

    public CapCabasistencias() {
    }

    public CapCabasistencias(Integer cabasistenciaid) {
        this.cabasistenciaid = cabasistenciaid;
    }

    public Integer getCabasistenciaid() {
        return cabasistenciaid;
    }

    public void setCabasistenciaid(Integer cabasistenciaid) {
        this.cabasistenciaid = cabasistenciaid;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<CapDetasistencias> getCapDetasistenciasList() {
        return capDetasistenciasList;
    }

    public void setCapDetasistenciasList(List<CapDetasistencias> capDetasistenciasList) {
        this.capDetasistenciasList = capDetasistenciasList;
    }

    public CapCabinscripciones getCabinscripcionid() {
        return cabinscripcionid;
    }

    public void setCabinscripcionid(CapCabinscripciones cabinscripcionid) {
        this.cabinscripcionid = cabinscripcionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cabasistenciaid != null ? cabasistenciaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapCabasistencias)) {
            return false;
        }
        CapCabasistencias other = (CapCabasistencias) object;
        if ((this.cabasistenciaid == null && other.cabasistenciaid != null) || (this.cabasistenciaid != null && !this.cabasistenciaid.equals(other.cabasistenciaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapCabasistencias[ cabasistenciaid=" + cabasistenciaid + " ]";
    }
    
}
