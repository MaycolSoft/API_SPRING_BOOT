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
@Table(name = "t_pagos_tarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPagosTarjeta.findAll", query = "SELECT t FROM TPagosTarjeta t"),
    @NamedQuery(name = "TPagosTarjeta.findByFIdrecord", query = "SELECT t FROM TPagosTarjeta t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TPagosTarjeta.findByFIdempresa", query = "SELECT t FROM TPagosTarjeta t WHERE t.fIdempresa = :fIdempresa"),
    @NamedQuery(name = "TPagosTarjeta.findByFTipotarjeta", query = "SELECT t FROM TPagosTarjeta t WHERE t.fTipotarjeta = :fTipotarjeta"),
    @NamedQuery(name = "TPagosTarjeta.findByFAutorizacion", query = "SELECT t FROM TPagosTarjeta t WHERE t.fAutorizacion = :fAutorizacion"),
    @NamedQuery(name = "TPagosTarjeta.findByFMonto", query = "SELECT t FROM TPagosTarjeta t WHERE t.fMonto = :fMonto"),
    @NamedQuery(name = "TPagosTarjeta.findByFNodoc", query = "SELECT t FROM TPagosTarjeta t WHERE t.fNodoc = :fNodoc"),
    @NamedQuery(name = "TPagosTarjeta.findByFCheque", query = "SELECT t FROM TPagosTarjeta t WHERE t.fCheque = :fCheque"),
    @NamedQuery(name = "TPagosTarjeta.findByFFecha", query = "SELECT t FROM TPagosTarjeta t WHERE t.fFecha = :fFecha"),
    @NamedQuery(name = "TPagosTarjeta.findByFHechopor", query = "SELECT t FROM TPagosTarjeta t WHERE t.fHechopor = :fHechopor"),
    @NamedQuery(name = "TPagosTarjeta.findByFMontoCk", query = "SELECT t FROM TPagosTarjeta t WHERE t.fMontoCk = :fMontoCk"),
    @NamedQuery(name = "TPagosTarjeta.findByFIddocumento", query = "SELECT t FROM TPagosTarjeta t WHERE t.fIddocumento = :fIddocumento")})
public class TPagosTarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_idempresa")
    private Integer fIdempresa;
    @Column(name = "f_tipotarjeta")
    private Integer fTipotarjeta;
    @Column(name = "f_autorizacion")
    private String fAutorizacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "f_monto")
    private BigDecimal fMonto;
    @Column(name = "f_nodoc")
    private String fNodoc;
    @Column(name = "f_cheque")
    private String fCheque;
    @Column(name = "f_fecha")
    @Temporal(TemporalType.DATE)
    private Date fFecha;
    @Column(name = "f_hechopor")
    private Integer fHechopor;
    @Column(name = "f_monto_ck")
    private BigDecimal fMontoCk;
    @Column(name = "f_iddocumento")
    private Integer fIddocumento;

    public TPagosTarjeta() {
    }

    public TPagosTarjeta(Integer fIdrecord) {
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

    public Integer getFTipotarjeta() {
        return fTipotarjeta;
    }

    public void setFTipotarjeta(Integer fTipotarjeta) {
        this.fTipotarjeta = fTipotarjeta;
    }

    public String getFAutorizacion() {
        return fAutorizacion;
    }

    public void setFAutorizacion(String fAutorizacion) {
        this.fAutorizacion = fAutorizacion;
    }

    public BigDecimal getFMonto() {
        return fMonto;
    }

    public void setFMonto(BigDecimal fMonto) {
        this.fMonto = fMonto;
    }

    public String getFNodoc() {
        return fNodoc;
    }

    public void setFNodoc(String fNodoc) {
        this.fNodoc = fNodoc;
    }

    public String getFCheque() {
        return fCheque;
    }

    public void setFCheque(String fCheque) {
        this.fCheque = fCheque;
    }

    public Date getFFecha() {
        return fFecha;
    }

    public void setFFecha(Date fFecha) {
        this.fFecha = fFecha;
    }

    public Integer getFHechopor() {
        return fHechopor;
    }

    public void setFHechopor(Integer fHechopor) {
        this.fHechopor = fHechopor;
    }

    public BigDecimal getFMontoCk() {
        return fMontoCk;
    }

    public void setFMontoCk(BigDecimal fMontoCk) {
        this.fMontoCk = fMontoCk;
    }

    public Integer getFIddocumento() {
        return fIddocumento;
    }

    public void setFIddocumento(Integer fIddocumento) {
        this.fIddocumento = fIddocumento;
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
        if (!(object instanceof TPagosTarjeta)) {
            return false;
        }
        TPagosTarjeta other = (TPagosTarjeta) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TPagosTarjeta[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
