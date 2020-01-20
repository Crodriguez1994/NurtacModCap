/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapNurtac.Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "cap_especialidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapEspecialidades.findAll", query = "SELECT c FROM CapEspecialidades c")
    , @NamedQuery(name = "CapEspecialidades.findByEspecialidadid", query = "SELECT c FROM CapEspecialidades c WHERE c.especialidadid = :especialidadid")
    , @NamedQuery(name = "CapEspecialidades.findByEstado", query = "SELECT c FROM CapEspecialidades c WHERE c.estado = :estado")
    , @NamedQuery(name = "CapEspecialidades.findByFecha", query = "SELECT c FROM CapEspecialidades c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CapEspecialidades.findByNombre", query = "SELECT c FROM CapEspecialidades c WHERE c.nombre = :nombre")})
public class CapEspecialidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "especialidadid")
    private Integer especialidadid;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "especialidadid")
    private List<CapFacilitadores> capFacilitadoresList;

    public CapEspecialidades() {
    }

    public CapEspecialidades(Integer especialidadid) {
        this.especialidadid = especialidadid;
    }

    public Integer getEspecialidadid() {
        return especialidadid;
    }

    public void setEspecialidadid(Integer especialidadid) {
        this.especialidadid = especialidadid;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<CapFacilitadores> getCapFacilitadoresList() {
        return capFacilitadoresList;
    }

    public void setCapFacilitadoresList(List<CapFacilitadores> capFacilitadoresList) {
        this.capFacilitadoresList = capFacilitadoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especialidadid != null ? especialidadid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapEspecialidades)) {
            return false;
        }
        CapEspecialidades other = (CapEspecialidades) object;
        if ((this.especialidadid == null && other.especialidadid != null) || (this.especialidadid != null && !this.especialidadid.equals(other.especialidadid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Integer.toString(this.especialidadid);
    }
    
}
