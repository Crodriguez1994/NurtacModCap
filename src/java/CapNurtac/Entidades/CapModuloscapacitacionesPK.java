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
public class CapModuloscapacitacionesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cabcapid")
    private int cabcapid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "moduloid")
    private int moduloid;

    public CapModuloscapacitacionesPK() {
    }

    public CapModuloscapacitacionesPK(int cabcapid, int moduloid) {
        this.cabcapid = cabcapid;
        this.moduloid = moduloid;
    }

    public int getCabcapid() {
        return cabcapid;
    }

    public void setCabcapid(int cabcapid) {
        this.cabcapid = cabcapid;
    }

    public int getModuloid() {
        return moduloid;
    }

    public void setModuloid(int moduloid) {
        this.moduloid = moduloid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cabcapid;
        hash += (int) moduloid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapModuloscapacitacionesPK)) {
            return false;
        }
        CapModuloscapacitacionesPK other = (CapModuloscapacitacionesPK) object;
        if (this.cabcapid != other.cabcapid) {
            return false;
        }
        if (this.moduloid != other.moduloid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapModuloscapacitacionesPK[ cabcapid=" + cabcapid + ", moduloid=" + moduloid + " ]";
    }
    
}
