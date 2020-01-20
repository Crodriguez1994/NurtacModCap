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
@Table(name = "cap_beneficiarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapBeneficiarios.findAll", query = "SELECT c FROM CapBeneficiarios c")
    , @NamedQuery(name = "CapBeneficiarios.findByBeneficiarioid", query = "SELECT c FROM CapBeneficiarios c WHERE c.beneficiarioid = :beneficiarioid")
    , @NamedQuery(name = "CapBeneficiarios.findByApellidos", query = "SELECT c FROM CapBeneficiarios c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "CapBeneficiarios.findByCedula", query = "SELECT c FROM CapBeneficiarios c WHERE c.cedula = :cedula")
    , @NamedQuery(name = "CapBeneficiarios.findByCelular", query = "SELECT c FROM CapBeneficiarios c WHERE c.celular = :celular")
    , @NamedQuery(name = "CapBeneficiarios.findByConvencional", query = "SELECT c FROM CapBeneficiarios c WHERE c.convencional = :convencional")
    , @NamedQuery(name = "CapBeneficiarios.findByDireccion", query = "SELECT c FROM CapBeneficiarios c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "CapBeneficiarios.findByEmail", query = "SELECT c FROM CapBeneficiarios c WHERE c.email = :email")
    , @NamedQuery(name = "CapBeneficiarios.findByEstado", query = "SELECT c FROM CapBeneficiarios c WHERE c.estado = :estado")
    , @NamedQuery(name = "CapBeneficiarios.findByFecha", query = "SELECT c FROM CapBeneficiarios c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CapBeneficiarios.findByNombres", query = "SELECT c FROM CapBeneficiarios c WHERE c.nombres = :nombres")})
public class CapBeneficiarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "beneficiarioid")
    private Integer beneficiarioid;
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
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 30)
    @Column(name = "nombres")
    private String nombres;
    @OneToMany(mappedBy = "beneficiarioid")
    private List<CapDetasistencias> capDetasistenciasList;
    @OneToMany(mappedBy = "beneficiarioid")
    private List<CapDetainscripciones> capDetainscripcionesList;

    public CapBeneficiarios() {
    }

    public CapBeneficiarios(Integer beneficiarioid) {
        this.beneficiarioid = beneficiarioid;
    }

    public Integer getBeneficiarioid() {
        return beneficiarioid;
    }

    public void setBeneficiarioid(Integer beneficiarioid) {
        this.beneficiarioid = beneficiarioid;
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

    @XmlTransient
    public List<CapDetasistencias> getCapDetasistenciasList() {
        return capDetasistenciasList;
    }

    public void setCapDetasistenciasList(List<CapDetasistencias> capDetasistenciasList) {
        this.capDetasistenciasList = capDetasistenciasList;
    }

    @XmlTransient
    public List<CapDetainscripciones> getCapDetainscripcionesList() {
        return capDetainscripcionesList;
    }

    public void setCapDetainscripcionesList(List<CapDetainscripciones> capDetainscripcionesList) {
        this.capDetainscripcionesList = capDetainscripcionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (beneficiarioid != null ? beneficiarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapBeneficiarios)) {
            return false;
        }
        CapBeneficiarios other = (CapBeneficiarios) object;
        if ((this.beneficiarioid == null && other.beneficiarioid != null) || (this.beneficiarioid != null && !this.beneficiarioid.equals(other.beneficiarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapBeneficiarios[ beneficiarioid=" + beneficiarioid + " ]";
    }
    
}
