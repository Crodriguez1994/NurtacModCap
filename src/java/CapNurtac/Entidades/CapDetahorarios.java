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
@Table(name = "cap_detahorarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapDetahorarios.findAll", query = "SELECT c FROM CapDetahorarios c")
    , @NamedQuery(name = "CapDetahorarios.findByCabhorarioid", query = "SELECT c FROM CapDetahorarios c WHERE c.capDetahorariosPK.cabhorarioid = :cabhorarioid")
    , @NamedQuery(name = "CapDetahorarios.findByDetahorarioid", query = "SELECT c FROM CapDetahorarios c WHERE c.capDetahorariosPK.detahorarioid = :detahorarioid")
    , @NamedQuery(name = "CapDetahorarios.findByHorafin", query = "SELECT c FROM CapDetahorarios c WHERE c.horafin = :horafin")
    , @NamedQuery(name = "CapDetahorarios.findByHorainicio", query = "SELECT c FROM CapDetahorarios c WHERE c.horainicio = :horainicio")})
public class CapDetahorarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapDetahorariosPK capDetahorariosPK;
    @Size(max = 6)
    @Column(name = "horafin")
    private String horafin;
    @Size(max = 6)
    @Column(name = "horainicio")
    private String horainicio;
    @JoinColumn(name = "diaid", referencedColumnName = "diaid")
    @ManyToOne
    private BioDias diaid;
    @JoinColumn(name = "cabhorarioid", referencedColumnName = "cabhorarioid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CapCabhorarios capCabhorarios;

 public static int Id=0;
    public CapDetahorarios() {
    }

    public CapDetahorarios(CapDetahorariosPK capDetahorariosPK) {
        this.capDetahorariosPK = capDetahorariosPK;
    }

    public CapDetahorarios(int cabhorarioid, int detahorarioid) {
       
     
        this.capDetahorariosPK = new CapDetahorariosPK(cabhorarioid, detahorarioid);
    }

    public CapDetahorariosPK getCapDetahorariosPK() {
        
           if(capDetahorariosPK.getDetahorarioid()==0){
              Id =Id + 1;
            capDetahorariosPK.setDetahorarioid(Id);
        }
        else{           
            Id = capDetahorariosPK.getDetahorarioid();
           }

        return capDetahorariosPK;
    }

    public void setCapDetahorariosPK(CapDetahorariosPK capDetahorariosPK) {
        this.capDetahorariosPK = capDetahorariosPK;
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

    public BioDias getDiaid() {
        return diaid;
    }

    public void setDiaid(BioDias diaid) {
        this.diaid = diaid;
    }

    public CapCabhorarios getCapCabhorarios() {
        return capCabhorarios;
    }

    public void setCapCabhorarios(CapCabhorarios capCabhorarios) {
        this.capCabhorarios = capCabhorarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capDetahorariosPK != null ? capDetahorariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapDetahorarios)) {
            return false;
        }
        CapDetahorarios other = (CapDetahorarios) object;
        if ((this.capDetahorariosPK == null && other.capDetahorariosPK != null) || (this.capDetahorariosPK != null && !this.capDetahorariosPK.equals(other.capDetahorariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapNurtac.Entidades.CapDetahorarios[ capDetahorariosPK=" + capDetahorariosPK + " ]";
    }
    
}
