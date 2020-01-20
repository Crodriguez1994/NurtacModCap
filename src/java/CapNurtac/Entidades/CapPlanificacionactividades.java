/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapNurtac.Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "cap_planificacionactividades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapPlanificacionactividades.findAll", query = "SELECT c FROM CapPlanificacionactividades c")
    , @NamedQuery(name = "CapPlanificacionactividades.findByPlanificacionid", query = "SELECT c FROM CapPlanificacionactividades c WHERE c.planificacionid = :planificacionid")
    , @NamedQuery(name = "CapPlanificacionactividades.findByActividad", query = "SELECT c FROM CapPlanificacionactividades c WHERE c.actividad = :actividad")
    , @NamedQuery(name = "CapPlanificacionactividades.findByFecha", query = "SELECT c FROM CapPlanificacionactividades c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CapPlanificacionactividades.findByLugar", query = "SELECT c FROM CapPlanificacionactividades c WHERE c.lugar = :lugar")
    , @NamedQuery(name = "CapPlanificacionactividades.findByObjetivo", query = "SELECT c FROM CapPlanificacionactividades c WHERE c.objetivo = :objetivo")
    , @NamedQuery(name = "CapPlanificacionactividades.findByResultados", query = "SELECT c FROM CapPlanificacionactividades c WHERE c.resultados = :resultados")
    , @NamedQuery(name = "CapPlanificacionactividades.findByTipo", query = "SELECT c FROM CapPlanificacionactividades c WHERE c.tipo = :tipo")})
public class CapPlanificacionactividades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "planificacionid")
    private Integer planificacionid;
    @Size(max = 200)
    @Column(name = "actividad")
    private String actividad;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 20)
    @Column(name = "lugar")
    private String lugar;
    @Size(max = 200)
    @Column(name = "objetivo")
    private String objetivo;
    @Size(max = 200)
    @Column(name = "resultados")
    private String resultados;
    @Size(max = 1)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "cabagendaid", referencedColumnName = "cabagendaid")
    @ManyToOne
    private CapCabagendas cabagendaid;

    public CapPlanificacionactividades() {
    }

    public CapPlanificacionactividades(Integer planificacionid) {
        this.planificacionid = planificacionid;
    }

    public Integer getPlanificacionid() {
        return planificacionid;
    }

    public void setPlanificacionid(Integer planificacionid) {
        this.planificacionid = planificacionid;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public CapCabagendas getCabagendaid() {
        return cabagendaid;
    }

    public void setCabagendaid(CapCabagendas cabagendaid) {
        this.cabagendaid = cabagendaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planificacionid != null ? planificacionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapPlanificacionactividades)) {
            return false;
        }
        CapPlanificacionactividades other = (CapPlanificacionactividades) object;
        if ((this.planificacionid == null && other.planificacionid != null) || (this.planificacionid != null && !this.planificacionid.equals(other.planificacionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapPlanificacionactividades[ planificacionid=" + planificacionid + " ]";
    }
    
}
