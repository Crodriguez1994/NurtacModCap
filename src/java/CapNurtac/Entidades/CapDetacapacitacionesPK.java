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
public class CapDetacapacitacionesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cabcapid")
    private int cabcapid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "detacapid")
    private int detacapid;

    public CapDetacapacitacionesPK() {
    }

    public CapDetacapacitacionesPK(int cabcapid, int detacapid) {
        this.cabcapid = cabcapid;
        this.detacapid = detacapid;
    }

    public int getCabcapid() {
        return cabcapid;
    }

    public void setCabcapid(int cabcapid) {
        this.cabcapid = cabcapid;
    }

    public int getDetacapid() {
        return detacapid;
    }

    public void setDetacapid(int detacapid) {
        this.detacapid = detacapid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cabcapid;
        hash += (int) detacapid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapDetacapacitacionesPK)) {
            return false;
        }
        CapDetacapacitacionesPK other = (CapDetacapacitacionesPK) object;
        if (this.cabcapid != other.cabcapid) {
            return false;
        }
        if (this.detacapid != other.detacapid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapDetacapacitacionesPK[ cabcapid=" + cabcapid + ", detacapid=" + detacapid + " ]";
    }
    
}
