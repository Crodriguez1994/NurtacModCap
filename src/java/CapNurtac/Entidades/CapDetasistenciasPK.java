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
public class CapDetasistenciasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cabasistenciaid")
    private int cabasistenciaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "detasistenciaid")
    private int detasistenciaid;

    public CapDetasistenciasPK() {
    }

    public CapDetasistenciasPK(int cabasistenciaid, int detasistenciaid) {
        this.cabasistenciaid = cabasistenciaid;
        this.detasistenciaid = detasistenciaid;
    }

    public int getCabasistenciaid() {
        return cabasistenciaid;
    }

    public void setCabasistenciaid(int cabasistenciaid) {
        this.cabasistenciaid = cabasistenciaid;
    }

    public int getDetasistenciaid() {
        return detasistenciaid;
    }

    public void setDetasistenciaid(int detasistenciaid) {
        this.detasistenciaid = detasistenciaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cabasistenciaid;
        hash += (int) detasistenciaid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapDetasistenciasPK)) {
            return false;
        }
        CapDetasistenciasPK other = (CapDetasistenciasPK) object;
        if (this.cabasistenciaid != other.cabasistenciaid) {
            return false;
        }
        if (this.detasistenciaid != other.detasistenciaid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapDetasistenciasPK[ cabasistenciaid=" + cabasistenciaid + ", detasistenciaid=" + detasistenciaid + " ]";
    }
    
}
