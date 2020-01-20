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
@Table(name = "cap_detacapacitaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapDetacapacitaciones.findAll", query = "SELECT c FROM CapDetacapacitaciones c")
    , @NamedQuery(name = "CapDetacapacitaciones.findByCabcapid", query = "SELECT c FROM CapDetacapacitaciones c WHERE c.capDetacapacitacionesPK.cabcapid = :cabcapid")
    , @NamedQuery(name = "CapDetacapacitaciones.findByDetacapid", query = "SELECT c FROM CapDetacapacitaciones c WHERE c.capDetacapacitacionesPK.detacapid = :detacapid")})
public class CapDetacapacitaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapDetacapacitacionesPK capDetacapacitacionesPK;
    @JoinColumn(name = "cabcapid", referencedColumnName = "cabcapid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CapCabcapacitaciones capCabcapacitaciones;
    @JoinColumn(name = "facilitadorid", referencedColumnName = "facilitadorid")
    @ManyToOne
    private CapFacilitadores facilitadorid;

    public CapDetacapacitaciones() {
    }

    public CapDetacapacitaciones(CapDetacapacitacionesPK capDetacapacitacionesPK) {
        this.capDetacapacitacionesPK = capDetacapacitacionesPK;
    }

    public CapDetacapacitaciones(int cabcapid, int detacapid) {
        this.capDetacapacitacionesPK = new CapDetacapacitacionesPK(cabcapid, detacapid);
    }

    public CapDetacapacitacionesPK getCapDetacapacitacionesPK() {
        return capDetacapacitacionesPK;
    }

    public void setCapDetacapacitacionesPK(CapDetacapacitacionesPK capDetacapacitacionesPK) {
        this.capDetacapacitacionesPK = capDetacapacitacionesPK;
    }

    public CapCabcapacitaciones getCapCabcapacitaciones() {
        return capCabcapacitaciones;
    }

    public void setCapCabcapacitaciones(CapCabcapacitaciones capCabcapacitaciones) {
        this.capCabcapacitaciones = capCabcapacitaciones;
    }

    public CapFacilitadores getFacilitadorid() {
        return facilitadorid;
    }

    public void setFacilitadorid(CapFacilitadores facilitadorid) {
        this.facilitadorid = facilitadorid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capDetacapacitacionesPK != null ? capDetacapacitacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapDetacapacitaciones)) {
            return false;
        }
        CapDetacapacitaciones other = (CapDetacapacitaciones) object;
        if ((this.capDetacapacitacionesPK == null && other.capDetacapacitacionesPK != null) || (this.capDetacapacitacionesPK != null && !this.capDetacapacitacionesPK.equals(other.capDetacapacitacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapDetacapacitaciones[ capDetacapacitacionesPK=" + capDetacapacitacionesPK + " ]";
    }
    
}
