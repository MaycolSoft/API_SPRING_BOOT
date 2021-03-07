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
@Table(name = "t_logs_ncf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLogsNcf.findAll", query = "SELECT t FROM TLogsNcf t"),
    @NamedQuery(name = "TLogsNcf.findByFIdrecord", query = "SELECT t FROM TLogsNcf t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TLogsNcf.findByFFecha", query = "SELECT t FROM TLogsNcf t WHERE t.fFecha = :fFecha"),
    @NamedQuery(name = "TLogsNcf.findByFTipoNcf", query = "SELECT t FROM TLogsNcf t WHERE t.fTipoNcf = :fTipoNcf"),
    @NamedQuery(name = "TLogsNcf.findByFHechoPor", query = "SELECT t FROM TLogsNcf t WHERE t.fHechoPor = :fHechoPor"),
    @NamedQuery(name = "TLogsNcf.findByFFechaInicio", query = "SELECT t FROM TLogsNcf t WHERE t.fFechaInicio = :fFechaInicio"),
    @NamedQuery(name = "TLogsNcf.findByFFechaFinal", query = "SELECT t FROM TLogsNcf t WHERE t.fFechaFinal = :fFechaFinal"),
    @NamedQuery(name = "TLogsNcf.findByFSecuenciaInicial", query = "SELECT t FROM TLogsNcf t WHERE t.fSecuenciaInicial = :fSecuenciaInicial"),
    @NamedQuery(name = "TLogsNcf.findByFSecuenciaFinal", query = "SELECT t FROM TLogsNcf t WHERE t.fSecuenciaFinal = :fSecuenciaFinal"),
    @NamedQuery(name = "TLogsNcf.findByFIdempresa", query = "SELECT t FROM TLogsNcf t WHERE t.fIdempresa = :fIdempresa"),
    @NamedQuery(name = "TLogsNcf.findByFActivo", query = "SELECT t FROM TLogsNcf t WHERE t.fActivo = :fActivo"),
    @NamedQuery(name = "TLogsNcf.findByFRango", query = "SELECT t FROM TLogsNcf t WHERE t.fRango = :fRango")})
public class TLogsNcf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFecha;
    @Column(name = "f_tipo_ncf")
    private Integer fTipoNcf;
    @Column(name = "f_hecho_por")
    private Integer fHechoPor;
    @Column(name = "f_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fFechaInicio;
    @Column(name = "f_fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fFechaFinal;
    @Column(name = "f_secuencia_inicial")
    private Integer fSecuenciaInicial;
    @Column(name = "f_secuencia_final")
    private Integer fSecuenciaFinal;
    @Column(name = "f_idempresa")
    private Integer fIdempresa;
    @Column(name = "f_activo")
    private Boolean fActivo;
    @Column(name = "f_rango")
    private String fRango;

    public TLogsNcf() {
    }

    public TLogsNcf(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public Integer getFIdrecord() {
        return fIdrecord;
    }

    public void setFIdrecord(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public Date getFFecha() {
        return fFecha;
    }

    public void setFFecha(Date fFecha) {
        this.fFecha = fFecha;
    }

    public Integer getFTipoNcf() {
        return fTipoNcf;
    }

    public void setFTipoNcf(Integer fTipoNcf) {
        this.fTipoNcf = fTipoNcf;
    }

    public Integer getFHechoPor() {
        return fHechoPor;
    }

    public void setFHechoPor(Integer fHechoPor) {
        this.fHechoPor = fHechoPor;
    }

    public Date getFFechaInicio() {
        return fFechaInicio;
    }

    public void setFFechaInicio(Date fFechaInicio) {
        this.fFechaInicio = fFechaInicio;
    }

    public Date getFFechaFinal() {
        return fFechaFinal;
    }

    public void setFFechaFinal(Date fFechaFinal) {
        this.fFechaFinal = fFechaFinal;
    }

    public Integer getFSecuenciaInicial() {
        return fSecuenciaInicial;
    }

    public void setFSecuenciaInicial(Integer fSecuenciaInicial) {
        this.fSecuenciaInicial = fSecuenciaInicial;
    }

    public Integer getFSecuenciaFinal() {
        return fSecuenciaFinal;
    }

    public void setFSecuenciaFinal(Integer fSecuenciaFinal) {
        this.fSecuenciaFinal = fSecuenciaFinal;
    }

    public Integer getFIdempresa() {
        return fIdempresa;
    }

    public void setFIdempresa(Integer fIdempresa) {
        this.fIdempresa = fIdempresa;
    }

    public Boolean getFActivo() {
        return fActivo;
    }

    public void setFActivo(Boolean fActivo) {
        this.fActivo = fActivo;
    }

    public String getFRango() {
        return fRango;
    }

    public void setFRango(String fRango) {
        this.fRango = fRango;
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
        if (!(object instanceof TLogsNcf)) {
            return false;
        }
        TLogsNcf other = (TLogsNcf) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TLogsNcf[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
