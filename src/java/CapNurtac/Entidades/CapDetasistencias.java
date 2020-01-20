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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "cap_detasistencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapDetasistencias.findAll", query = "SELECT c FROM CapDetasistencias c")
    , @NamedQuery(name = "CapDetasistencias.findByCabasistenciaid", query = "SELECT c FROM CapDetasistencias c WHERE c.capDetasistenciasPK.cabasistenciaid = :cabasistenciaid")
    , @NamedQuery(name = "CapDetasistencias.findByDetasistenciaid", query = "SELECT c FROM CapDetasistencias c WHERE c.capDetasistenciasPK.detasistenciaid = :detasistenciaid")
    , @NamedQuery(name = "CapDetasistencias.findByAsistencia", query = "SELECT c FROM CapDetasistencias c WHERE c.asistencia = :asistencia")})
public class CapDetasistencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapDetasistenciasPK capDetasistenciasPK;
    @Column(name = "asistencia")
    private Boolean asistencia;
    @JoinColumn(name = "beneficiarioid", referencedColumnName = "beneficiarioid")
    @ManyToOne
    private CapBeneficiarios beneficiarioid;
    @JoinColumn(name = "cabasistenciaid", referencedColumnName = "cabasistenciaid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CapCabasistencias capCabasistencias;

    public CapDetasistencias() {
    }

    public CapDetasistencias(CapDetasistenciasPK capDetasistenciasPK) {
        this.capDetasistenciasPK = capDetasistenciasPK;
    }

    public CapDetasistencias(int cabasistenciaid, int detasistenciaid) {
        this.capDetasistenciasPK = new CapDetasistenciasPK(cabasistenciaid, detasistenciaid);
    }

    public CapDetasistenciasPK getCapDetasistenciasPK() {
        return capDetasistenciasPK;
    }

    public void setCapDetasistenciasPK(CapDetasistenciasPK capDetasistenciasPK) {
        this.capDetasistenciasPK = capDetasistenciasPK;
    }

    public Boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Boolean asistencia) {
        this.asistencia = asistencia;
    }

    public CapBeneficiarios getBeneficiarioid() {
        return beneficiarioid;
    }

    public void setBeneficiarioid(CapBeneficiarios beneficiarioid) {
        this.beneficiarioid = beneficiarioid;
    }

    public CapCabasistencias getCapCabasistencias() {
        return capCabasistencias;
    }

    public void setCapCabasistencias(CapCabasistencias capCabasistencias) {
        this.capCabasistencias = capCabasistencias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capDetasistenciasPK != null ? capDetasistenciasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapDetasistencias)) {
            return false;
        }
        CapDetasistencias other = (CapDetasistencias) object;
        if ((this.capDetasistenciasPK == null && other.capDetasistenciasPK != null) || (this.capDetasistenciasPK != null && !this.capDetasistenciasPK.equals(other.capDetasistenciasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapDetasistencias[ capDetasistenciasPK=" + capDetasistenciasPK + " ]";
    }
    
}
