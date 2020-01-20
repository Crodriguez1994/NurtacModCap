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
import javax.persistence.JoinColumns;
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
@Table(name = "cap_cabagendas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapCabagendas.findAll", query = "SELECT c FROM CapCabagendas c")
    , @NamedQuery(name = "CapCabagendas.findByCabagendaid", query = "SELECT c FROM CapCabagendas c WHERE c.cabagendaid = :cabagendaid")
    , @NamedQuery(name = "CapCabagendas.findByDia", query = "SELECT c FROM CapCabagendas c WHERE c.dia = :dia")
    , @NamedQuery(name = "CapCabagendas.findByEstado", query = "SELECT c FROM CapCabagendas c WHERE c.estado = :estado")
    , @NamedQuery(name = "CapCabagendas.findByFecha", query = "SELECT c FROM CapCabagendas c WHERE c.fecha = :fecha")})
public class CapCabagendas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cabagendaid")
    private Integer cabagendaid;
    @Column(name = "dia")
    private Integer dia;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(mappedBy = "cabagendaid")
    private List<CapPlanificacionactividades> capPlanificacionactividadesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capCabagendas")
    private List<CapDetagendas> capDetagendasList;
    @JoinColumns({
        @JoinColumn(name = "cabcapid", referencedColumnName = "cabcapid")
        , @JoinColumn(name = "moduloid", referencedColumnName = "moduloid")})
    @ManyToOne
    private CapModuloscapacitaciones capModuloscapacitaciones;

    public CapCabagendas() {
    }

    public CapCabagendas(Integer cabagendaid) {
        this.cabagendaid = cabagendaid;
    }

    public Integer getCabagendaid() {
        return cabagendaid;
    }

    public void setCabagendaid(Integer cabagendaid) {
        this.cabagendaid = cabagendaid;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
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
    public List<CapPlanificacionactividades> getCapPlanificacionactividadesList() {
        return capPlanificacionactividadesList;
    }

    public void setCapPlanificacionactividadesList(List<CapPlanificacionactividades> capPlanificacionactividadesList) {
        this.capPlanificacionactividadesList = capPlanificacionactividadesList;
    }

    @XmlTransient
    public List<CapDetagendas> getCapDetagendasList() {
        return capDetagendasList;
    }

    public void setCapDetagendasList(List<CapDetagendas> capDetagendasList) {
        this.capDetagendasList = capDetagendasList;
    }

    public CapModuloscapacitaciones getCapModuloscapacitaciones() {
        return capModuloscapacitaciones;
    }

    public void setCapModuloscapacitaciones(CapModuloscapacitaciones capModuloscapacitaciones) {
        this.capModuloscapacitaciones = capModuloscapacitaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cabagendaid != null ? cabagendaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapCabagendas)) {
            return false;
        }
        CapCabagendas other = (CapCabagendas) object;
        if ((this.cabagendaid == null && other.cabagendaid != null) || (this.cabagendaid != null && !this.cabagendaid.equals(other.cabagendaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapCabagendas[ cabagendaid=" + cabagendaid + " ]";
    }
    
}
