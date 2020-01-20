/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapNurtac.Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "cap_detagendas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapDetagendas.findAll", query = "SELECT c FROM CapDetagendas c")
    , @NamedQuery(name = "CapDetagendas.findByCabagendaid", query = "SELECT c FROM CapDetagendas c WHERE c.capDetagendasPK.cabagendaid = :cabagendaid")
    , @NamedQuery(name = "CapDetagendas.findByDetagendaid", query = "SELECT c FROM CapDetagendas c WHERE c.capDetagendasPK.detagendaid = :detagendaid")
    , @NamedQuery(name = "CapDetagendas.findByActividad", query = "SELECT c FROM CapDetagendas c WHERE c.actividad = :actividad")
    , @NamedQuery(name = "CapDetagendas.findByEstrategia", query = "SELECT c FROM CapDetagendas c WHERE c.estrategia = :estrategia")
    , @NamedQuery(name = "CapDetagendas.findByHorafin", query = "SELECT c FROM CapDetagendas c WHERE c.horafin = :horafin")
    , @NamedQuery(name = "CapDetagendas.findByHorainicio", query = "SELECT c FROM CapDetagendas c WHERE c.horainicio = :horainicio")
    , @NamedQuery(name = "CapDetagendas.findByResponsable", query = "SELECT c FROM CapDetagendas c WHERE c.responsable = :responsable")})
public class CapDetagendas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapDetagendasPK capDetagendasPK;
    @Size(max = 300)
    @Column(name = "actividad")
    private String actividad;
    @Size(max = 300)
    @Column(name = "estrategia")
    private String estrategia;
    @Size(max = 6)
    @Column(name = "horafin")
    private String horafin;
    @Size(max = 6)
    @Column(name = "horainicio")
    private String horainicio;
    @Size(max = 30)
    @Column(name = "responsable")
    private String responsable;
    @JoinColumn(name = "cabagendaid", referencedColumnName = "cabagendaid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CapCabagendas capCabagendas;

    public CapDetagendas() {
    }

    public CapDetagendas(CapDetagendasPK capDetagendasPK) {
        this.capDetagendasPK = capDetagendasPK;
    }

    public CapDetagendas(int cabagendaid, int detagendaid) {
        this.capDetagendasPK = new CapDetagendasPK(cabagendaid, detagendaid);
    }

    public CapDetagendasPK getCapDetagendasPK() {
        return capDetagendasPK;
    }

    public void setCapDetagendasPK(CapDetagendasPK capDetagendasPK) {
        this.capDetagendasPK = capDetagendasPK;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public CapCabagendas getCapCabagendas() {
        return capCabagendas;
    }

    public void setCapCabagendas(CapCabagendas capCabagendas) {
        this.capCabagendas = capCabagendas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capDetagendasPK != null ? capDetagendasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapDetagendas)) {
            return false;
        }
        CapDetagendas other = (CapDetagendas) object;
        if ((this.capDetagendasPK == null && other.capDetagendasPK != null) || (this.capDetagendasPK != null && !this.capDetagendasPK.equals(other.capDetagendasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapDetagendas[ capDetagendasPK=" + capDetagendasPK + " ]";
    }
    
}
