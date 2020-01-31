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
@Table(name = "cap_facilitadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapFacilitadores.findAll", query = "SELECT c FROM CapFacilitadores c")
    , @NamedQuery(name = "CapFacilitadores.findByFacilitadorid", query = "SELECT c FROM CapFacilitadores c WHERE c.facilitadorid = :facilitadorid")
    , @NamedQuery(name = "CapFacilitadores.findByApellidos", query = "SELECT c FROM CapFacilitadores c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "CapFacilitadores.findByCedula", query = "SELECT c FROM CapFacilitadores c WHERE c.cedula = :cedula")
    , @NamedQuery(name = "CapFacilitadores.findByCelular", query = "SELECT c FROM CapFacilitadores c WHERE c.celular = :celular")
    , @NamedQuery(name = "CapFacilitadores.findByConvencional", query = "SELECT c FROM CapFacilitadores c WHERE c.convencional = :convencional")
    , @NamedQuery(name = "CapFacilitadores.findByDireccion", query = "SELECT c FROM CapFacilitadores c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "CapFacilitadores.findByEmail", query = "SELECT c FROM CapFacilitadores c WHERE c.email = :email")
    , @NamedQuery(name = "CapFacilitadores.findByEstado", query = "SELECT c FROM CapFacilitadores c WHERE c.estado = :estado")
    , @NamedQuery(name = "CapFacilitadores.findByFechaingreso", query = "SELECT c FROM CapFacilitadores c WHERE c.fechaingreso = :fechaingreso")
    , @NamedQuery(name = "CapFacilitadores.findByNombres", query = "SELECT c FROM CapFacilitadores c WHERE c.nombres = :nombres")
    , @NamedQuery(name = "CapFacilitadores.findByTipo", query = "SELECT c FROM CapFacilitadores c WHERE c.tipo = :tipo")})
public class CapFacilitadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "facilitadorid")
    private Integer facilitadorid;
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
    @JoinColumn(name = "empleadoid", referencedColumnName = "empleadoid")
    @ManyToOne
    private BioEmpleados empleadoid;
    @JoinColumn(name = "especialidadid", referencedColumnName = "especialidadid")
    @ManyToOne
    private CapEspecialidades especialidadid;
    @OneToMany(mappedBy = "facilitadorid")
    private List<CapDetacapacitaciones> capDetacapacitacionesList;

    public static int Id=0;
    public CapFacilitadores() {
    }

    public CapFacilitadores(Integer facilitadorid) {
        this.facilitadorid = facilitadorid;
    }

    public Integer getFacilitadorid() {
          if (facilitadorid ==null){
              Id =Id + 1;
            facilitadorid = Id;
        }else{
            Id = facilitadorid;
        }
        return facilitadorid;
    }

    public void setFacilitadorid(Integer facilitadorid) {
        this.facilitadorid = facilitadorid;
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

    public BioEmpleados getEmpleadoid() {
        return empleadoid;
    }

    public void setEmpleadoid(BioEmpleados empleadoid) {
        this.empleadoid = empleadoid;
    }

    public CapEspecialidades getEspecialidadid() {
        return especialidadid;
    }

    public void setEspecialidadid(CapEspecialidades especialidadid) {
        this.especialidadid = especialidadid;
    }

    @XmlTransient
    public List<CapDetacapacitaciones> getCapDetacapacitacionesList() {
        return capDetacapacitacionesList;
    }

    public void setCapDetacapacitacionesList(List<CapDetacapacitaciones> capDetacapacitacionesList) {
        this.capDetacapacitacionesList = capDetacapacitacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facilitadorid != null ? facilitadorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapFacilitadores)) {
            return false;
        }
        CapFacilitadores other = (CapFacilitadores) object;
        if ((this.facilitadorid == null && other.facilitadorid != null) || (this.facilitadorid != null && !this.facilitadorid.equals(other.facilitadorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapFacilitadores[ facilitadorid=" + facilitadorid + " ]";
    }
    
}
