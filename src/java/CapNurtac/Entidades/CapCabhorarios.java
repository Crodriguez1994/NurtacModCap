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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "cap_cabhorarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapCabhorarios.findAll", query = "SELECT c FROM CapCabhorarios c")
    , @NamedQuery(name = "CapCabhorarios.findByCabhorarioid", query = "SELECT c FROM CapCabhorarios c WHERE c.cabhorarioid = :cabhorarioid")
    , @NamedQuery(name = "CapCabhorarios.findByEstado", query = "SELECT c FROM CapCabhorarios c WHERE c.estado = :estado")
    , @NamedQuery(name = "CapCabhorarios.findByFecha", query = "SELECT c FROM CapCabhorarios c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CapCabhorarios.findByNombre", query = "SELECT c FROM CapCabhorarios c WHERE c.nombre = :nombre")})
public class CapCabhorarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cabhorarioid")
    private Integer cabhorarioid;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 20)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "cabhorarioid")
    private List<CapCabinscripciones> capCabinscripcionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capCabhorarios")
    private List<CapDetahorarios> capDetahorariosList;

    public static int Id=0;
    public CapCabhorarios() {
    }

    public CapCabhorarios(Integer cabhorarioid) {
        this.cabhorarioid = cabhorarioid;
    }

    public Integer getCabhorarioid() {
        
         if (cabhorarioid ==null){
              Id =Id + 1;
            cabhorarioid = Id;
        }else{
            Id = cabhorarioid;
        }
        return cabhorarioid;
    }

    public void setCabhorarioid(Integer cabhorarioid) {
        this.cabhorarioid = cabhorarioid;
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
    public List<CapCabinscripciones> getCapCabinscripcionesList() {
        return capCabinscripcionesList;
    }

    public void setCapCabinscripcionesList(List<CapCabinscripciones> capCabinscripcionesList) {
        this.capCabinscripcionesList = capCabinscripcionesList;
    }

    @XmlTransient
    public List<CapDetahorarios> getCapDetahorariosList() {
        return capDetahorariosList;
    }

    public void setCapDetahorariosList(List<CapDetahorarios> capDetahorariosList) {
        this.capDetahorariosList = capDetahorariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cabhorarioid != null ? cabhorarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapCabhorarios)) {
            return false;
        }
        CapCabhorarios other = (CapCabhorarios) object;
        if ((this.cabhorarioid == null && other.cabhorarioid != null) || (this.cabhorarioid != null && !this.cabhorarioid.equals(other.cabhorarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Integer.toString(this.cabhorarioid);
    }
    
}
