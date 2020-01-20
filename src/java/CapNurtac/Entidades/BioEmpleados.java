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
@Table(name = "bio_empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BioEmpleados.findAll", query = "SELECT b FROM BioEmpleados b")
    , @NamedQuery(name = "BioEmpleados.findByEmpleadoid", query = "SELECT b FROM BioEmpleados b WHERE b.empleadoid = :empleadoid")
    , @NamedQuery(name = "BioEmpleados.findByApellidos", query = "SELECT b FROM BioEmpleados b WHERE b.apellidos = :apellidos")
    , @NamedQuery(name = "BioEmpleados.findByCargo", query = "SELECT b FROM BioEmpleados b WHERE b.cargo = :cargo")
    , @NamedQuery(name = "BioEmpleados.findByCedula", query = "SELECT b FROM BioEmpleados b WHERE b.cedula = :cedula")
    , @NamedQuery(name = "BioEmpleados.findByDireccion", query = "SELECT b FROM BioEmpleados b WHERE b.direccion = :direccion")
    , @NamedQuery(name = "BioEmpleados.findByEdad", query = "SELECT b FROM BioEmpleados b WHERE b.edad = :edad")
    , @NamedQuery(name = "BioEmpleados.findByEmail", query = "SELECT b FROM BioEmpleados b WHERE b.email = :email")
    , @NamedQuery(name = "BioEmpleados.findByEstado", query = "SELECT b FROM BioEmpleados b WHERE b.estado = :estado")
    , @NamedQuery(name = "BioEmpleados.findByFecha", query = "SELECT b FROM BioEmpleados b WHERE b.fecha = :fecha")
    , @NamedQuery(name = "BioEmpleados.findByNombres", query = "SELECT b FROM BioEmpleados b WHERE b.nombres = :nombres")
    , @NamedQuery(name = "BioEmpleados.findByTelefono", query = "SELECT b FROM BioEmpleados b WHERE b.telefono = :telefono")})
public class BioEmpleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empleadoid")
    private Integer empleadoid;
    @Size(max = 30)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 25)
    @Column(name = "cargo")
    private String cargo;
    @Size(max = 13)
    @Column(name = "cedula")
    private String cedula;
    @Size(max = 30)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 255)
    @Column(name = "edad")
    private String edad;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 30)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(mappedBy = "empleadoid")
    private List<CapFacilitadores> capFacilitadoresList;
    @OneToMany(mappedBy = "empleadoid")
    private List<CapCoordinadores> capCoordinadoresList;

    public BioEmpleados() {
    }

    public BioEmpleados(Integer empleadoid) {
        this.empleadoid = empleadoid;
    }

    public Integer getEmpleadoid() {
        return empleadoid;
    }

    public void setEmpleadoid(Integer empleadoid) {
        this.empleadoid = empleadoid;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<CapFacilitadores> getCapFacilitadoresList() {
        return capFacilitadoresList;
    }

    public void setCapFacilitadoresList(List<CapFacilitadores> capFacilitadoresList) {
        this.capFacilitadoresList = capFacilitadoresList;
    }

    @XmlTransient
    public List<CapCoordinadores> getCapCoordinadoresList() {
        return capCoordinadoresList;
    }

    public void setCapCoordinadoresList(List<CapCoordinadores> capCoordinadoresList) {
        this.capCoordinadoresList = capCoordinadoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoid != null ? empleadoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BioEmpleados)) {
            return false;
        }
        BioEmpleados other = (BioEmpleados) object;
        if ((this.empleadoid == null && other.empleadoid != null) || (this.empleadoid != null && !this.empleadoid.equals(other.empleadoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Integer.toString(this.empleadoid);
    }
    
}
