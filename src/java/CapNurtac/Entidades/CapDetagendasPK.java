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
public class CapDetagendasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cabagendaid")
    private int cabagendaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "detagendaid")
    private int detagendaid;

    public CapDetagendasPK() {
    }

    public CapDetagendasPK(int cabagendaid, int detagendaid) {
        this.cabagendaid = cabagendaid;
        this.detagendaid = detagendaid;
    }

    public int getCabagendaid() {
        return cabagendaid;
    }

    public void setCabagendaid(int cabagendaid) {
        this.cabagendaid = cabagendaid;
    }

    public int getDetagendaid() {
        return detagendaid;
    }

    public void setDetagendaid(int detagendaid) {
        this.detagendaid = detagendaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cabagendaid;
        hash += (int) detagendaid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapDetagendasPK)) {
            return false;
        }
        CapDetagendasPK other = (CapDetagendasPK) object;
        if (this.cabagendaid != other.cabagendaid) {
            return false;
        }
        if (this.detagendaid != other.detagendaid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapDetagendasPK[ cabagendaid=" + cabagendaid + ", detagendaid=" + detagendaid + " ]";
    }
    
}
