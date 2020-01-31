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
@Table(name = "cap_sectores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapSectores.findAll", query = "SELECT c FROM CapSectores c")
    , @NamedQuery(name = "CapSectores.findBySectorid", query = "SELECT c FROM CapSectores c WHERE c.sectorid = :sectorid")
    , @NamedQuery(name = "CapSectores.findByEstado", query = "SELECT c FROM CapSectores c WHERE c.estado = :estado")
    , @NamedQuery(name = "CapSectores.findByFecha", query = "SELECT c FROM CapSectores c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CapSectores.findByNombre", query = "SELECT c FROM CapSectores c WHERE c.nombre = :nombre")})
public class CapSectores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sectorid")
    private Integer sectorid;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "sectorid")
    private List<CapUnidadesatencion> capUnidadesatencionList;
    @OneToMany(mappedBy = "sectorid")
    private List<CapAsigproyectosector> capAsigproyectosectorList;

    public static int Id=0;
    public CapSectores() {
    }

    public CapSectores(Integer sectorid) {
        this.sectorid = sectorid;
    }

    public Integer getSectorid() {
          if (sectorid==null){
              Id =Id + 1;
            sectorid = Id;
        }else{
            Id = sectorid;
        }
        return sectorid;
    }

    public void setSectorid(Integer sectorid) {
        this.sectorid = sectorid;
    }

    public String getEstado() {
          if (estado==null){
            estado = "A";
        }
         
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        if(fecha== null){
            fecha = new Date();
        }
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
    public List<CapUnidadesatencion> getCapUnidadesatencionList() {
        return capUnidadesatencionList;
    }

    public void setCapUnidadesatencionList(List<CapUnidadesatencion> capUnidadesatencionList) {
        this.capUnidadesatencionList = capUnidadesatencionList;
    }

    @XmlTransient
    public List<CapAsigproyectosector> getCapAsigproyectosectorList() {
        return capAsigproyectosectorList;
    }

    public void setCapAsigproyectosectorList(List<CapAsigproyectosector> capAsigproyectosectorList) {
        this.capAsigproyectosectorList = capAsigproyectosectorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sectorid != null ? sectorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapSectores)) {
            return false;
        }
        CapSectores other = (CapSectores) object;
        if ((this.sectorid == null && other.sectorid != null) || (this.sectorid != null && !this.sectorid.equals(other.sectorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Integer.toString(this.sectorid);
    }
    
}
