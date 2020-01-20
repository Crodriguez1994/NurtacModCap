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
public class CapDetahorariosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cabhorarioid")
    private int cabhorarioid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "detahorarioid")
    private int detahorarioid;

    public CapDetahorariosPK() {
    }

    public CapDetahorariosPK(int cabhorarioid, int detahorarioid) {
        this.cabhorarioid = cabhorarioid;
        this.detahorarioid = detahorarioid;
    }

    public int getCabhorarioid() {
        return cabhorarioid;
    }

    public void setCabhorarioid(int cabhorarioid) {
        this.cabhorarioid = cabhorarioid;
    }

    public int getDetahorarioid() {
        return detahorarioid;
    }

    public void setDetahorarioid(int detahorarioid) {
        this.detahorarioid = detahorarioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cabhorarioid;
        hash += (int) detahorarioid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapDetahorariosPK)) {
            return false;
        }
        CapDetahorariosPK other = (CapDetahorariosPK) object;
        if (this.cabhorarioid != other.cabhorarioid) {
            return false;
        }
        if (this.detahorarioid != other.detahorarioid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapDetahorariosPK[ cabhorarioid=" + cabhorarioid + ", detahorarioid=" + detahorarioid + " ]";
    }
    
}
