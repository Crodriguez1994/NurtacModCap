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
import javax.persistence.Id;
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
@Table(name = "cap_proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapProyectos.findAll", query = "SELECT c FROM CapProyectos c")
    , @NamedQuery(name = "CapProyectos.findByProyectoid", query = "SELECT c FROM CapProyectos c WHERE c.proyectoid = :proyectoid")
    , @NamedQuery(name = "CapProyectos.findByEstado", query = "SELECT c FROM CapProyectos c WHERE c.estado = :estado")
    , @NamedQuery(name = "CapProyectos.findByFecha", query = "SELECT c FROM CapProyectos c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CapProyectos.findByFechafin", query = "SELECT c FROM CapProyectos c WHERE c.fechafin = :fechafin")
    , @NamedQuery(name = "CapProyectos.findByFechainicio", query = "SELECT c FROM CapProyectos c WHERE c.fechainicio = :fechainicio")
    , @NamedQuery(name = "CapProyectos.findByNombre", query = "SELECT c FROM CapProyectos c WHERE c.nombre = :nombre")})
public class CapProyectos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectoid")
    private Integer proyectoid;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "proyectoid")
    private List<CapAsigproyectos> capAsigproyectosList;
    @OneToMany(mappedBy = "proyectoid")
    private List<CapUnidadesatencion> capUnidadesatencionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capProyectos")
    private List<CapAsigproyectosector> capAsigproyectosectorList;

    public CapProyectos() {
    }

    public CapProyectos(Integer proyectoid) {
        this.proyectoid = proyectoid;
    }

    public Integer getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(Integer proyectoid) {
        this.proyectoid = proyectoid;
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

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<CapAsigproyectos> getCapAsigproyectosList() {
        return capAsigproyectosList;
    }

    public void setCapAsigproyectosList(List<CapAsigproyectos> capAsigproyectosList) {
        this.capAsigproyectosList = capAsigproyectosList;
    }

    @XmlTransient
    public List<CapUnidadesatencion> getCapUnidadesatencionList() {
        return capUnidadesatencionList;
    }

    public void setCapUnidadesatencionList(List<CapUnidadesatencion> capUnidadesatencionList) {
        this.capUnidadesatencionList = capUnidadesatencionList;
    }

    @XmlTransient
    public List<CapAsigproyectosector> getCapAsigproyectosectorList() {
        return capAsigproyectosectorList;
    }

    public void setCapAsigproyectosectorList(List<CapAsigproyectosector> capAsigproyectosectorList) {
        this.capAsigproyectosectorList = capAsigproyectosectorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectoid != null ? proyectoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapProyectos)) {
            return false;
        }
        CapProyectos other = (CapProyectos) object;
        if ((this.proyectoid == null && other.proyectoid != null) || (this.proyectoid != null && !this.proyectoid.equals(other.proyectoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  Integer.toString(this.proyectoid);
    }
    
}
