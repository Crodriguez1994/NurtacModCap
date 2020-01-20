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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "cap_unidadesatencion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapUnidadesatencion.findAll", query = "SELECT c FROM CapUnidadesatencion c")
    , @NamedQuery(name = "CapUnidadesatencion.findByUnidadid", query = "SELECT c FROM CapUnidadesatencion c WHERE c.unidadid = :unidadid")
    , @NamedQuery(name = "CapUnidadesatencion.findByEstado", query = "SELECT c FROM CapUnidadesatencion c WHERE c.estado = :estado")
    , @NamedQuery(name = "CapUnidadesatencion.findByFecha", query = "SELECT c FROM CapUnidadesatencion c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CapUnidadesatencion.findByNombre", query = "SELECT c FROM CapUnidadesatencion c WHERE c.nombre = :nombre")})
public class CapUnidadesatencion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidadid")
    private Integer unidadid;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "unidadid")
    private List<CapCabcapacitaciones> capCabcapacitacionesList;
    @JoinColumn(name = "proyectoid", referencedColumnName = "proyectoid")
    @ManyToOne
    private CapProyectos proyectoid;
    @JoinColumn(name = "sectorid", referencedColumnName = "sectorid")
    @ManyToOne
    private CapSectores sectorid;

    public CapUnidadesatencion() {
    }

    public CapUnidadesatencion(Integer unidadid) {
        this.unidadid = unidadid;
    }

    public Integer getUnidadid() {
        return unidadid;
    }

    public void setUnidadid(Integer unidadid) {
        this.unidadid = unidadid;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<CapCabcapacitaciones> getCapCabcapacitacionesList() {
        return capCabcapacitacionesList;
    }

    public void setCapCabcapacitacionesList(List<CapCabcapacitaciones> capCabcapacitacionesList) {
        this.capCabcapacitacionesList = capCabcapacitacionesList;
    }

    public CapProyectos getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(CapProyectos proyectoid) {
        this.proyectoid = proyectoid;
    }

    public CapSectores getSectorid() {
        return sectorid;
    }

    public void setSectorid(CapSectores sectorid) {
        this.sectorid = sectorid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidadid != null ? unidadid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapUnidadesatencion)) {
            return false;
        }
        CapUnidadesatencion other = (CapUnidadesatencion) object;
        if ((this.unidadid == null && other.unidadid != null) || (this.unidadid != null && !this.unidadid.equals(other.unidadid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapUnidadesatencion[ unidadid=" + unidadid + " ]";
    }
    
}
