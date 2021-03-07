/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jqmicrosistemas.abacus.model;

import java.io.Serializable;
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
@Table(name = "t_facturas_impresion_pendiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TFacturasImpresionPendiente.findAll", query = "SELECT t FROM TFacturasImpresionPendiente t"),
    @NamedQuery(name = "TFacturasImpresionPendiente.findByFIdrecord", query = "SELECT t FROM TFacturasImpresionPendiente t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TFacturasImpresionPendiente.findByFIdsession", query = "SELECT t FROM TFacturasImpresionPendiente t WHERE t.fIdsession = :fIdsession"),
    @NamedQuery(name = "TFacturasImpresionPendiente.findByFFactura", query = "SELECT t FROM TFacturasImpresionPendiente t WHERE t.fFactura = :fFactura"),
    @NamedQuery(name = "TFacturasImpresionPendiente.findByFFecha", query = "SELECT t FROM TFacturasImpresionPendiente t WHERE t.fFecha = :fFecha"),
    @NamedQuery(name = "TFacturasImpresionPendiente.findByFIdempresa", query = "SELECT t FROM TFacturasImpresionPendiente t WHERE t.fIdempresa = :fIdempresa")})
public class TFacturasImpresionPendiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_idsession")
    private String fIdsession;
    @Column(name = "f_factura")
    private String fFactura;
    @Column(name = "f_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFecha;
    @Column(name = "f_idempresa")
    private Integer fIdempresa;

    public TFacturasImpresionPendiente() {
    }

    public TFacturasImpresionPendiente(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public Integer getFIdrecord() {
        return fIdrecord;
    }

    public void setFIdrecord(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public String getFIdsession() {
        return fIdsession;
    }

    public void setFIdsession(String fIdsession) {
        this.fIdsession = fIdsession;
    }

    public String getFFactura() {
        return fFactura;
    }

    public void setFFactura(String fFactura) {
        this.fFactura = fFactura;
    }

    public Date getFFecha() {
        return fFecha;
    }

    public void setFFecha(Date fFecha) {
        this.fFecha = fFecha;
    }

    public Integer getFIdempresa() {
        return fIdempresa;
    }

    public void setFIdempresa(Integer fIdempresa) {
        this.fIdempresa = fIdempresa;
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
        if (!(object instanceof TFacturasImpresionPendiente)) {
            return false;
        }
        TFacturasImpresionPendiente other = (TFacturasImpresionPendiente) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TFacturasImpresionPendiente[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
