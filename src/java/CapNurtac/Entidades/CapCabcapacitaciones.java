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
@Table(name = "cap_cabcapacitaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapCabcapacitaciones.findAll", query = "SELECT c FROM CapCabcapacitaciones c")
    , @NamedQuery(name = "CapCabcapacitaciones.findByCabcapid", query = "SELECT c FROM CapCabcapacitaciones c WHERE c.cabcapid = :cabcapid")
    , @NamedQuery(name = "CapCabcapacitaciones.findByCupo", query = "SELECT c FROM CapCabcapacitaciones c WHERE c.cupo = :cupo")
    , @NamedQuery(name = "CapCabcapacitaciones.findByEstado", query = "SELECT c FROM CapCabcapacitaciones c WHERE c.estado = :estado")
    , @NamedQuery(name = "CapCabcapacitaciones.findByFecha", query = "SELECT c FROM CapCabcapacitaciones c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CapCabcapacitaciones.findByFechaapertura", query = "SELECT c FROM CapCabcapacitaciones c WHERE c.fechaapertura = :fechaapertura")
    , @NamedQuery(name = "CapCabcapacitaciones.findByFechacierre", query = "SELECT c FROM CapCabcapacitaciones c WHERE c.fechacierre = :fechacierre")
    , @NamedQuery(name = "CapCabcapacitaciones.findByLugar", query = "SELECT c FROM CapCabcapacitaciones c WHERE c.lugar = :lugar")
    , @NamedQuery(name = "CapCabcapacitaciones.findByNombre", query = "SELECT c FROM CapCabcapacitaciones c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CapCabcapacitaciones.findByTipo", query = "SELECT c FROM CapCabcapacitaciones c WHERE c.tipo = :tipo")})
public class CapCabcapacitaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cabcapid")
    private Integer cabcapid;
    @Column(name = "cupo")
    private Integer cupo;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "fechaapertura")
    @Temporal(TemporalType.DATE)
    private Date fechaapertura;
    @Column(name = "fechacierre")
    @Temporal(TemporalType.DATE)
    private Date fechacierre;
    @Size(max = 25)
    @Column(name = "lugar")
    private String lugar;
    @Size(max = 35)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 1)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "asigproyectoid", referencedColumnName = "asigproyectoid")
    @ManyToOne
    private CapAsigproyectos asigproyectoid;
    @JoinColumn(name = "unidadid", referencedColumnName = "unidadid")
    @ManyToOne
    private CapUnidadesatencion unidadid;
    @OneToMany(mappedBy = "cabcapid")
    private List<CapCabinscripciones> capCabinscripcionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capCabcapacitaciones")
    private List<CapModuloscapacitaciones> capModuloscapacitacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capCabcapacitaciones")
    private List<CapDetacapacitaciones> capDetacapacitacionesList;

    public CapCabcapacitaciones() {
    }

    public CapCabcapacitaciones(Integer cabcapid) {
        this.cabcapid = cabcapid;
    }

    public Integer getCabcapid() {
        return cabcapid;
    }

    public void setCabcapid(Integer cabcapid) {
        this.cabcapid = cabcapid;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
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

    public Date getFechaapertura() {
        return fechaapertura;
    }

    public void setFechaapertura(Date fechaapertura) {
        this.fechaapertura = fechaapertura;
    }

    public Date getFechacierre() {
        return fechacierre;
    }

    public void setFechacierre(Date fechacierre) {
        this.fechacierre = fechacierre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public CapAsigproyectos getAsigproyectoid() {
        return asigproyectoid;
    }

    public void setAsigproyectoid(CapAsigproyectos asigproyectoid) {
        this.asigproyectoid = asigproyectoid;
    }

    public CapUnidadesatencion getUnidadid() {
        return unidadid;
    }

    public void setUnidadid(CapUnidadesatencion unidadid) {
        this.unidadid = unidadid;
    }

    @XmlTransient
    public List<CapCabinscripciones> getCapCabinscripcionesList() {
        return capCabinscripcionesList;
    }

    public void setCapCabinscripcionesList(List<CapCabinscripciones> capCabinscripcionesList) {
        this.capCabinscripcionesList = capCabinscripcionesList;
    }

    @XmlTransient
    public List<CapModuloscapacitaciones> getCapModuloscapacitacionesList() {
        return capModuloscapacitacionesList;
    }

    public void setCapModuloscapacitacionesList(List<CapModuloscapacitaciones> capModuloscapacitacionesList) {
        this.capModuloscapacitacionesList = capModuloscapacitacionesList;
    }

    @XmlTransient
    public List<CapDetacapacitaciones> getCapDetacapacitacionesList() {
        return capDetacapacitacionesList;
    }

    public void setCapDetacapacitacionesList(List<CapDetacapacitaciones> capDetacapacitacionesList) {
        this.capDetacapacitacionesList = capDetacapacitacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cabcapid != null ? cabcapid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapCabcapacitaciones)) {
            return false;
        }
        CapCabcapacitaciones other = (CapCabcapacitaciones) object;
        if ((this.cabcapid == null && other.cabcapid != null) || (this.cabcapid != null && !this.cabcapid.equals(other.cabcapid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapCabcapacitaciones[ cabcapid=" + cabcapid + " ]";
    }
    
}
