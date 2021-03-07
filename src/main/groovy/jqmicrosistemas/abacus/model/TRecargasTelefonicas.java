/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jqmicrosistemas.abacus.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maycol
 */
@Entity
@Table(name = "t_recargas_telefonicas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TRecargasTelefonicas.findAll", query = "SELECT t FROM TRecargasTelefonicas t"),
    @NamedQuery(name = "TRecargasTelefonicas.findByFIdrecord", query = "SELECT t FROM TRecargasTelefonicas t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TRecargasTelefonicas.findByFIdempresa", query = "SELECT t FROM TRecargasTelefonicas t WHERE t.fIdempresa = :fIdempresa"),
    @NamedQuery(name = "TRecargasTelefonicas.findByFFTelefono", query = "SELECT t FROM TRecargasTelefonicas t WHERE t.fFTelefono = :fFTelefono"),
    @NamedQuery(name = "TRecargasTelefonicas.findByFMonto", query = "SELECT t FROM TRecargasTelefonicas t WHERE t.fMonto = :fMonto"),
    @NamedQuery(name = "TRecargasTelefonicas.findByFConfirmacion", query = "SELECT t FROM TRecargasTelefonicas t WHERE t.fConfirmacion = :fConfirmacion"),
    @NamedQuery(name = "TRecargasTelefonicas.findByFTelefonica", query = "SELECT t FROM TRecargasTelefonicas t WHERE t.fTelefonica = :fTelefonica"),
    @NamedQuery(name = "TRecargasTelefonicas.findByFIdgenerado", query = "SELECT t FROM TRecargasTelefonicas t WHERE t.fIdgenerado = :fIdgenerado"),
    @NamedQuery(name = "TRecargasTelefonicas.findByFFechaRecarga", query = "SELECT t FROM TRecargasTelefonicas t WHERE t.fFechaRecarga = :fFechaRecarga"),
    @NamedQuery(name = "TRecargasTelefonicas.findByFFecha", query = "SELECT t FROM TRecargasTelefonicas t WHERE t.fFecha = :fFecha")})
public class TRecargasTelefonicas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_idempresa")
    private Integer fIdempresa;
    @Column(name = "f_f_telefono")
    private String fFTelefono;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "f_monto")
    private BigDecimal fMonto;
    @Column(name = "f_confirmacion")
    private String fConfirmacion;
    @Column(name = "f_telefonica")
    private String fTelefonica;
    @Column(name = "f_idgenerado")
    private String fIdgenerado;
    @Column(name = "f_fecha_recarga")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaRecarga;
    @Column(name = "f_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFecha;

    public TRecargasTelefonicas() {
    }

    public TRecargasTelefonicas(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public Integer getFIdrecord() {
        return fIdrecord;
    }

    public void setFIdrecord(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public Integer getFIdempresa() {
        return fIdempresa;
    }

    public void setFIdempresa(Integer fIdempresa) {
        this.fIdempresa = fIdempresa;
    }

    public String getFFTelefono() {
        return fFTelefono;
    }

    public void setFFTelefono(String fFTelefono) {
        this.fFTelefono = fFTelefono;
    }

    public BigDecimal getFMonto() {
        return fMonto;
    }

    public void setFMonto(BigDecimal fMonto) {
        this.fMonto = fMonto;
    }

    public String getFConfirmacion() {
        return fConfirmacion;
    }

    public void setFConfirmacion(String fConfirmacion) {
        this.fConfirmacion = fConfirmacion;
    }

    public String getFTelefonica() {
        return fTelefonica;
    }

    public void setFTelefonica(String fTelefonica) {
        this.fTelefonica = fTelefonica;
    }

    public String getFIdgenerado() {
        return fIdgenerado;
    }

    public void setFIdgenerado(String fIdgenerado) {
        this.fIdgenerado = fIdgenerado;
    }

    public Date getFFechaRecarga() {
        return fFechaRecarga;
    }

    public void setFFechaRecarga(Date fFechaRecarga) {
        this.fFechaRecarga = fFechaRecarga;
    }

    public Date getFFecha() {
        return fFecha;
    }

    public void setFFecha(Date fFecha) {
        this.fFecha = fFecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fIdrecord != null ? fIdrecord.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TRecargasTelefonicas)) {
            return false;
        }
        TRecargasTelefonicas other = (TRecargasTelefonicas) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TRecargasTelefonicas[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
