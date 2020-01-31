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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cap_coordinadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapCoordinadores.findAll", query = "SELECT c FROM CapCoordinadores c")
    , @NamedQuery(name = "CapCoordinadores.findByCoordinadorid", query = "SELECT c FROM CapCoordinadores c WHERE c.coordinadorid = :coordinadorid")
    , @NamedQuery(name = "CapCoordinadores.findByApellidos", query = "SELECT c FROM CapCoordinadores c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "CapCoordinadores.findByCedula", query = "SELECT c FROM CapCoordinadores c WHERE c.cedula = :cedula")
    , @NamedQuery(name = "CapCoordinadores.findByCelular", query = "SELECT c FROM CapCoordinadores c WHERE c.celular = :celular")
    , @NamedQuery(name = "CapCoordinadores.findByConvencional", query = "SELECT c FROM CapCoordinadores c WHERE c.convencional = :convencional")
    , @NamedQuery(name = "CapCoordinadores.findByDireccion", query = "SELECT c FROM CapCoordinadores c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "CapCoordinadores.findByEmail", query = "SELECT c FROM CapCoordinadores c WHERE c.email = :email")
    , @NamedQuery(name = "CapCoordinadores.findByEstado", query = "SELECT c FROM CapCoordinadores c WHERE c.estado = :estado")
    , @NamedQuery(name = "CapCoordinadores.findByFechaingreso", query = "SELECT c FROM CapCoordinadores c WHERE c.fechaingreso = :fechaingreso")
    , @NamedQuery(name = "CapCoordinadores.findByNombres", query = "SELECT c FROM CapCoordinadores c WHERE c.nombres = :nombres")
    , @NamedQuery(name = "CapCoordinadores.findByTipo", query = "SELECT c FROM CapCoordinadores c WHERE c.tipo = :tipo")})
public class CapCoordinadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "coordinadorid")
    private Integer coordinadorid;
    @Size(max = 30)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 13)
    @Column(name = "cedula")
    private String cedula;
    @Size(max = 15)
    @Column(name = "celular")
    private String celular;
    @Size(max = 15)
    @Column(name = "convencional")
    private String convencional;
    @Size(max = 30)
    @Column(name = "direccion")
    private String direccion;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    @Size(max = 30)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 1)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(mappedBy = "coordinadorid")
    private List<CapAsigproyectos> capAsigproyectosList;
    @JoinColumn(name = "empleadoid", referencedColumnName = "empleadoid")
    @ManyToOne
    private BioEmpleados empleadoid;

    public static int Id=0;
    public CapCoordinadores() {
    }

    public CapCoordinadores(Integer coordinadorid) {
        this.coordinadorid = coordinadorid;
    }

    public Integer getCoordinadorid() {
         if (coordinadorid ==null){
              Id =Id + 1;
            coordinadorid = Id;
        }else{
            Id = coordinadorid;
        }
        return coordinadorid;
    }

    public void setCoordinadorid(Integer coordinadorid) {
        this.coordinadorid = coordinadorid;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getConvencional() {
        return convencional;
    }

    public void setConvencional(String convencional) {
        this.convencional = convencional;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getFechaingreso() {
        
        if(fechaingreso== null){
            fechaingreso = new Date();
        }
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<CapAsigproyectos> getCapAsigproyectosList() {
        return capAsigproyectosList;
    }

    public void setCapAsigproyectosList(List<CapAsigproyectos> capAsigproyectosList) {
        this.capAsigproyectosList = capAsigproyectosList;
    }

    public BioEmpleados getEmpleadoid() {
        return empleadoid;
    }

    public void setEmpleadoid(BioEmpleados empleadoid) {
        this.empleadoid = empleadoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coordinadorid != null ? coordinadorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapCoordinadores)) {
            return false;
        }
        CapCoordinadores other = (CapCoordinadores) object;
        if ((this.coordinadorid == null && other.coordinadorid != null) || (this.coordinadorid != null && !this.coordinadorid.equals(other.coordinadorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Integer.toString(this.coordinadorid);
    }
    
}
