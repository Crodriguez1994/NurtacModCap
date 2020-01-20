/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapNurtac.Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "cap_moduloscapacitaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapModuloscapacitaciones.findAll", query = "SELECT c FROM CapModuloscapacitaciones c")
    , @NamedQuery(name = "CapModuloscapacitaciones.findByCabcapid", query = "SELECT c FROM CapModuloscapacitaciones c WHERE c.capModuloscapacitacionesPK.cabcapid = :cabcapid")
    , @NamedQuery(name = "CapModuloscapacitaciones.findByModuloid", query = "SELECT c FROM CapModuloscapacitaciones c WHERE c.capModuloscapacitacionesPK.moduloid = :moduloid")
    , @NamedQuery(name = "CapModuloscapacitaciones.findByEstado", query = "SELECT c FROM CapModuloscapacitaciones c WHERE c.estado = :estado")
    , @NamedQuery(name = "CapModuloscapacitaciones.findByFecha", query = "SELECT c FROM CapModuloscapacitaciones c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CapModuloscapacitaciones.findByNombre", query = "SELECT c FROM CapModuloscapacitaciones c WHERE c.nombre = :nombre")})
public class CapModuloscapacitaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapModuloscapacitacionesPK capModuloscapacitacionesPK;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "cabcapid", referencedColumnName = "cabcapid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CapCabcapacitaciones capCabcapacitaciones;
    @OneToMany(mappedBy = "capModuloscapacitaciones")
    private List<CapCabagendas> capCabagendasList;

    public CapModuloscapacitaciones() {
    }

    public CapModuloscapacitaciones(CapModuloscapacitacionesPK capModuloscapacitacionesPK) {
        this.capModuloscapacitacionesPK = capModuloscapacitacionesPK;
    }

    public CapModuloscapacitaciones(int cabcapid, int moduloid) {
        this.capModuloscapacitacionesPK = new CapModuloscapacitacionesPK(cabcapid, moduloid);
    }

    public CapModuloscapacitacionesPK getCapModuloscapacitacionesPK() {
        return capModuloscapacitacionesPK;
    }

    public void setCapModuloscapacitacionesPK(CapModuloscapacitacionesPK capModuloscapacitacionesPK) {
        this.capModuloscapacitacionesPK = capModuloscapacitacionesPK;
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

    public CapCabcapacitaciones getCapCabcapacitaciones() {
        return capCabcapacitaciones;
    }

    public void setCapCabcapacitaciones(CapCabcapacitaciones capCabcapacitaciones) {
        this.capCabcapacitaciones = capCabcapacitaciones;
    }

    @XmlTransient
    public List<CapCabagendas> getCapCabagendasList() {
        return capCabagendasList;
    }

    public void setCapCabagendasList(List<CapCabagendas> capCabagendasList) {
        this.capCabagendasList = capCabagendasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capModuloscapacitacionesPK != null ? capModuloscapacitacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapModuloscapacitaciones)) {
            return false;
        }
        CapModuloscapacitaciones other = (CapModuloscapacitaciones) object;
        if ((this.capModuloscapacitacionesPK == null && other.capModuloscapacitacionesPK != null) || (this.capModuloscapacitacionesPK != null && !this.capModuloscapacitacionesPK.equals(other.capModuloscapacitacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapModuloscapacitaciones[ capModuloscapacitacionesPK=" + capModuloscapacitacionesPK + " ]";
    }
    
}
