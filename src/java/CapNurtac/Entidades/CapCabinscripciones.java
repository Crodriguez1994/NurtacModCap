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
@Table(name = "cap_cabinscripciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapCabinscripciones.findAll", query = "SELECT c FROM CapCabinscripciones c")
    , @NamedQuery(name = "CapCabinscripciones.findByCabinscripcionid", query = "SELECT c FROM CapCabinscripciones c WHERE c.cabinscripcionid = :cabinscripcionid")
    , @NamedQuery(name = "CapCabinscripciones.findByEstado", query = "SELECT c FROM CapCabinscripciones c WHERE c.estado = :estado")
    , @NamedQuery(name = "CapCabinscripciones.findByFecha", query = "SELECT c FROM CapCabinscripciones c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CapCabinscripciones.findByResponsable", query = "SELECT c FROM CapCabinscripciones c WHERE c.responsable = :responsable")})
public class CapCabinscripciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cabinscripcionid")
    private Integer cabinscripcionid;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 50)
    @Column(name = "responsable")
    private String responsable;
    @JoinColumn(name = "cabcapid", referencedColumnName = "cabcapid")
    @ManyToOne
    private CapCabcapacitaciones cabcapid;
    @JoinColumn(name = "cabhorarioid", referencedColumnName = "cabhorarioid")
    @ManyToOne
    private CapCabhorarios cabhorarioid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capCabinscripciones")
    private List<CapDetainscripciones> capDetainscripcionesList;
    @OneToMany(mappedBy = "cabinscripcionid")
    private List<CapCabasistencias> capCabasistenciasList;

    public CapCabinscripciones() {
    }

    public CapCabinscripciones(Integer cabinscripcionid) {
        this.cabinscripcionid = cabinscripcionid;
    }

    public Integer getCabinscripcionid() {
        return cabinscripcionid;
    }

    public void setCabinscripcionid(Integer cabinscripcionid) {
        this.cabinscripcionid = cabinscripcionid;
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

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public CapCabcapacitaciones getCabcapid() {
        return cabcapid;
    }

    public void setCabcapid(CapCabcapacitaciones cabcapid) {
        this.cabcapid = cabcapid;
    }

    public CapCabhorarios getCabhorarioid() {
        return cabhorarioid;
    }

    public void setCabhorarioid(CapCabhorarios cabhorarioid) {
        this.cabhorarioid = cabhorarioid;
    }

    @XmlTransient
    public List<CapDetainscripciones> getCapDetainscripcionesList() {
        return capDetainscripcionesList;
    }

    public void setCapDetainscripcionesList(List<CapDetainscripciones> capDetainscripcionesList) {
        this.capDetainscripcionesList = capDetainscripcionesList;
    }

    @XmlTransient
    public List<CapCabasistencias> getCapCabasistenciasList() {
        return capCabasistenciasList;
    }

    public void setCapCabasistenciasList(List<CapCabasistencias> capCabasistenciasList) {
        this.capCabasistenciasList = capCabasistenciasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cabinscripcionid != null ? cabinscripcionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapCabinscripciones)) {
            return false;
        }
        CapCabinscripciones other = (CapCabinscripciones) object;
        if ((this.cabinscripcionid == null && other.cabinscripcionid != null) || (this.cabinscripcionid != null && !this.cabinscripcionid.equals(other.cabinscripcionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapCabinscripciones[ cabinscripcionid=" + cabinscripcionid + " ]";
    }
    
}
