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
public class CapAsigproyectosectorPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "asigid")
    private int asigid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectoid")
    private int proyectoid;

    public CapAsigproyectosectorPK() {
    }

    public CapAsigproyectosectorPK(int asigid, int proyectoid) {
        this.asigid = asigid;
        this.proyectoid = proyectoid;
    }

    public int getAsigid() {
        return asigid;
    }

    public void setAsigid(int asigid) {
        this.asigid = asigid;
    }

    public int getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(int proyectoid) {
        this.proyectoid = proyectoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) asigid;
        hash += (int) proyectoid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapAsigproyectosectorPK)) {
            return false;
        }
        CapAsigproyectosectorPK other = (CapAsigproyectosectorPK) object;
        if (this.asigid != other.asigid) {
            return false;
        }
        if (this.proyectoid != other.proyectoid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapAsigproyectosectorPK[ asigid=" + asigid + ", proyectoid=" + proyectoid + " ]";
    }
    
}
