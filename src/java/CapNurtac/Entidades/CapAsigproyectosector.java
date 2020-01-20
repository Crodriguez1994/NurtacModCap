/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapNurtac.Entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "cap_asigproyectosector")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapAsigproyectosector.findAll", query = "SELECT c FROM CapAsigproyectosector c")
    , @NamedQuery(name = "CapAsigproyectosector.findByAsigid", query = "SELECT c FROM CapAsigproyectosector c WHERE c.capAsigproyectosectorPK.asigid = :asigid")
    , @NamedQuery(name = "CapAsigproyectosector.findByProyectoid", query = "SELECT c FROM CapAsigproyectosector c WHERE c.capAsigproyectosectorPK.proyectoid = :proyectoid")})
public class CapAsigproyectosector implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapAsigproyectosectorPK capAsigproyectosectorPK;
    @JoinColumn(name = "proyectoid", referencedColumnName = "proyectoid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CapProyectos capProyectos;
    @JoinColumn(name = "sectorid", referencedColumnName = "sectorid")
    @ManyToOne
    private CapSectores sectorid;

    public CapAsigproyectosector() {
    }

    public CapAsigproyectosector(CapAsigproyectosectorPK capAsigproyectosectorPK) {
        this.capAsigproyectosectorPK = capAsigproyectosectorPK;
    }

    public CapAsigproyectosector(int asigid, int proyectoid) {
        this.capAsigproyectosectorPK = new CapAsigproyectosectorPK(asigid, proyectoid);
    }

    public CapAsigproyectosectorPK getCapAsigproyectosectorPK() {
        return capAsigproyectosectorPK;
    }

    public void setCapAsigproyectosectorPK(CapAsigproyectosectorPK capAsigproyectosectorPK) {
        this.capAsigproyectosectorPK = capAsigproyectosectorPK;
    }

    public CapProyectos getCapProyectos() {
        return capProyectos;
    }

    public void setCapProyectos(CapProyectos capProyectos) {
        this.capProyectos = capProyectos;
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
        hash += (capAsigproyectosectorPK != null ? capAsigproyectosectorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapAsigproyectosector)) {
            return false;
        }
        CapAsigproyectosector other = (CapAsigproyectosector) object;
        if ((this.capAsigproyectosectorPK == null && other.capAsigproyectosectorPK != null) || (this.capAsigproyectosectorPK != null && !this.capAsigproyectosectorPK.equals(other.capAsigproyectosectorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapAsigproyectosector[ capAsigproyectosectorPK=" + capAsigproyectosectorPK + " ]";
    }
    
}
