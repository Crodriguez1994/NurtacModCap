/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapNurtac.Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author User
 */
@Embeddable
public class CapDetainscripcionesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cabinscripcionid")
    private int cabinscripcionid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "detainsid")
    private int detainsid;

    public CapDetainscripcionesPK() {
    }

    public CapDetainscripcionesPK(int cabinscripcionid, int detainsid) {
        this.cabinscripcionid = cabinscripcionid;
        this.detainsid = detainsid;
    }

    public int getCabinscripcionid() {
        return cabinscripcionid;
    }

    public void setCabinscripcionid(int cabinscripcionid) {
        this.cabinscripcionid = cabinscripcionid;
    }

    public int getDetainsid() {
        return detainsid;
    }

    public void setDetainsid(int detainsid) {
        this.detainsid = detainsid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cabinscripcionid;
        hash += (int) detainsid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapDetainscripcionesPK)) {
            return false;
        }
        CapDetainscripcionesPK other = (CapDetainscripcionesPK) object;
        if (this.cabinscripcionid != other.cabinscripcionid) {
            return false;
        }
        if (this.detainsid != other.detainsid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapDetainscripcionesPK[ cabinscripcionid=" + cabinscripcionid + ", detainsid=" + detainsid + " ]";
    }
    
}
