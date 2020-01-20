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
@Table(name = "cap_detainscripciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapDetainscripciones.findAll", query = "SELECT c FROM CapDetainscripciones c")
    , @NamedQuery(name = "CapDetainscripciones.findByCabinscripcionid", query = "SELECT c FROM CapDetainscripciones c WHERE c.capDetainscripcionesPK.cabinscripcionid = :cabinscripcionid")
    , @NamedQuery(name = "CapDetainscripciones.findByDetainsid", query = "SELECT c FROM CapDetainscripciones c WHERE c.capDetainscripcionesPK.detainsid = :detainsid")})
public class CapDetainscripciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapDetainscripcionesPK capDetainscripcionesPK;
    @JoinColumn(name = "beneficiarioid", referencedColumnName = "beneficiarioid")
    @ManyToOne
    private CapBeneficiarios beneficiarioid;
    @JoinColumn(name = "cabinscripcionid", referencedColumnName = "cabinscripcionid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CapCabinscripciones capCabinscripciones;

    public CapDetainscripciones() {
    }

    public CapDetainscripciones(CapDetainscripcionesPK capDetainscripcionesPK) {
        this.capDetainscripcionesPK = capDetainscripcionesPK;
    }

    public CapDetainscripciones(int cabinscripcionid, int detainsid) {
        this.capDetainscripcionesPK = new CapDetainscripcionesPK(cabinscripcionid, detainsid);
    }

    public CapDetainscripcionesPK getCapDetainscripcionesPK() {
        return capDetainscripcionesPK;
    }

    public void setCapDetainscripcionesPK(CapDetainscripcionesPK capDetainscripcionesPK) {
        this.capDetainscripcionesPK = capDetainscripcionesPK;
    }

    public CapBeneficiarios getBeneficiarioid() {
        return beneficiarioid;
    }

    public void setBeneficiarioid(CapBeneficiarios beneficiarioid) {
        this.beneficiarioid = beneficiarioid;
    }

    public CapCabinscripciones getCapCabinscripciones() {
        return capCabinscripciones;
    }

    public void setCapCabinscripciones(CapCabinscripciones capCabinscripciones) {
        this.capCabinscripciones = capCabinscripciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capDetainscripcionesPK != null ? capDetainscripcionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapDetainscripciones)) {
            return false;
        }
        CapDetainscripciones other = (CapDetainscripciones) object;
        if ((this.capDetainscripcionesPK == null && other.capDetainscripcionesPK != null) || (this.capDetainscripcionesPK != null && !this.capDetainscripcionesPK.equals(other.capDetainscripcionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapDetainscripciones[ capDetainscripcionesPK=" + capDetainscripcionesPK + " ]";
    }
    
}
