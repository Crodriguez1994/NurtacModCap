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
@Table(name = "cap_asigproyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapAsigproyectos.findAll", query = "SELECT c FROM CapAsigproyectos c")
    , @NamedQuery(name = "CapAsigproyectos.findByAsigproyectoid", query = "SELECT c FROM CapAsigproyectos c WHERE c.asigproyectoid = :asigproyectoid")
    , @NamedQuery(name = "CapAsigproyectos.findByEstado", query = "SELECT c FROM CapAsigproyectos c WHERE c.estado = :estado")
    , @NamedQuery(name = "CapAsigproyectos.findByFecha", query = "SELECT c FROM CapAsigproyectos c WHERE c.fecha = :fecha")})
public class CapAsigproyectos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "asigproyectoid")
    private Integer asigproyectoid;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "coordinadorid", referencedColumnName = "coordinadorid")
    @ManyToOne
    private CapCoordinadores coordinadorid;
    @JoinColumn(name = "proyectoid", referencedColumnName = "proyectoid")
    @ManyToOne
    private CapProyectos proyectoid;
    @OneToMany(mappedBy = "asigproyectoid")
    private List<CapCabcapacitaciones> capCabcapacitacionesList;

    public CapAsigproyectos() {
    }

    public CapAsigproyectos(Integer asigproyectoid) {
        this.asigproyectoid = asigproyectoid;
    }

    public Integer getAsigproyectoid() {
        return asigproyectoid;
    }

    public void setAsigproyectoid(Integer asigproyectoid) {
        this.asigproyectoid = asigproyectoid;
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

    public CapCoordinadores getCoordinadorid() {
        return coordinadorid;
    }

    public void setCoordinadorid(CapCoordinadores coordinadorid) {
        this.coordinadorid = coordinadorid;
    }

    public CapProyectos getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(CapProyectos proyectoid) {
        this.proyectoid = proyectoid;
    }

    @XmlTransient
    public List<CapCabcapacitaciones> getCapCabcapacitacionesList() {
        return capCabcapacitacionesList;
    }

    public void setCapCabcapacitacionesList(List<CapCabcapacitaciones> capCabcapacitacionesList) {
        this.capCabcapacitacionesList = capCabcapacitacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asigproyectoid != null ? asigproyectoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapAsigproyectos)) {
            return false;
        }
        CapAsigproyectos other = (CapAsigproyectos) object;
        if ((this.asigproyectoid == null && other.asigproyectoid != null) || (this.asigproyectoid != null && !this.asigproyectoid.equals(other.asigproyectoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Integer.toString(this.asigproyectoid);
    }
    
}
