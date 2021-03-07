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
@Table(name = "t_ncf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TNcf.findAll", query = "SELECT t FROM TNcf t"),
    @NamedQuery(name = "TNcf.findByFIdrecord", query = "SELECT t FROM TNcf t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TNcf.findByFIdempresa", query = "SELECT t FROM TNcf t WHERE t.fIdempresa = :fIdempresa"),
    @NamedQuery(name = "TNcf.findByFCodigo", query = "SELECT t FROM TNcf t WHERE t.fCodigo = :fCodigo"),
    @NamedQuery(name = "TNcf.findByFDescripcion", query = "SELECT t FROM TNcf t WHERE t.fDescripcion = :fDescripcion"),
    @NamedQuery(name = "TNcf.findByFTipo", query = "SELECT t FROM TNcf t WHERE t.fTipo = :fTipo"),
    @NamedQuery(name = "TNcf.findByFReorden", query = "SELECT t FROM TNcf t WHERE t.fReorden = :fReorden"),
    @NamedQuery(name = "TNcf.findByFSecuenciaSolicitada", query = "SELECT t FROM TNcf t WHERE t.fSecuenciaSolicitada = :fSecuenciaSolicitada"),
    @NamedQuery(name = "TNcf.findByFSecuencia", query = "SELECT t FROM TNcf t WHERE t.fSecuencia = :fSecuencia"),
    @NamedQuery(name = "TNcf.findByFVisible", query = "SELECT t FROM TNcf t WHERE t.fVisible = :fVisible"),
    @NamedQuery(name = "TNcf.findByFOrden", query = "SELECT t FROM TNcf t WHERE t.fOrden = :fOrden"),
    @NamedQuery(name = "TNcf.findByFCobraItebis", query = "SELECT t FROM TNcf t WHERE t.fCobraItebis = :fCobraItebis"),
    @NamedQuery(name = "TNcf.findByFValidarRnc", query = "SELECT t FROM TNcf t WHERE t.fValidarRnc = :fValidarRnc"),
    @NamedQuery(name = "TNcf.findByFFechaInicio", query = "SELECT t FROM TNcf t WHERE t.fFechaInicio = :fFechaInicio"),
    @NamedQuery(name = "TNcf.findByFFechaFin", query = "SELECT t FROM TNcf t WHERE t.fFechaFin = :fFechaFin"),
    @NamedQuery(name = "TNcf.findByFValidaFechaVigencia", query = "SELECT t FROM TNcf t WHERE t.fValidaFechaVigencia = :fValidaFechaVigencia")})
public class TNcf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_idempresa")
    private Integer fIdempresa;
    @Column(name = "f_codigo")
    private Integer fCodigo;
    @Column(name = "f_descripcion")
    private String fDescripcion;
    @Column(name = "f_tipo")
    private String fTipo;
    @Column(name = "f_reorden")
    private Integer fReorden;
    @Column(name = "f_secuencia_solicitada")
    private Integer fSecuenciaSolicitada;
    @Column(name = "f_secuencia")
    private Integer fSecuencia;
    @Column(name = "f_visible")
    private Boolean fVisible;
    @Column(name = "f_orden")
    private Integer fOrden;
    @Column(name = "f_cobra_itebis")
    private Boolean fCobraItebis;
    @Column(name = "f_validar_rnc")
    private Boolean fValidarRnc;
    @Column(name = "f_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fFechaInicio;
    @Column(name = "f_fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fFechaFin;
    @Column(name = "f_valida_fecha_vigencia")
    private Boolean fValidaFechaVigencia;

    public TNcf() {
    }

    public TNcf(Integer fIdrecord) {
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

    public Integer getFCodigo() {
        return fCodigo;
    }

    public void setFCodigo(Integer fCodigo) {
        this.fCodigo = fCodigo;
    }

    public String getFDescripcion() {
        return fDescripcion;
    }

    public void setFDescripcion(String fDescripcion) {
        this.fDescripcion = fDescripcion;
    }

    public String getFTipo() {
        return fTipo;
    }

    public void setFTipo(String fTipo) {
        this.fTipo = fTipo;
    }

    public Integer getFReorden() {
        return fReorden;
    }

    public void setFReorden(Integer fReorden) {
        this.fReorden = fReorden;
    }

    public Integer getFSecuenciaSolicitada() {
        return fSecuenciaSolicitada;
    }

    public void setFSecuenciaSolicitada(Integer fSecuenciaSolicitada) {
        this.fSecuenciaSolicitada = fSecuenciaSolicitada;
    }

    public Integer getFSecuencia() {
        return fSecuencia;
    }

    public void setFSecuencia(Integer fSecuencia) {
        this.fSecuencia = fSecuencia;
    }

    public Boolean getFVisible() {
        return fVisible;
    }

    public void setFVisible(Boolean fVisible) {
        this.fVisible = fVisible;
    }

    public Integer getFOrden() {
        return fOrden;
    }

    public void setFOrden(Integer fOrden) {
        this.fOrden = fOrden;
    }

    public Boolean getFCobraItebis() {
        return fCobraItebis;
    }

    public void setFCobraItebis(Boolean fCobraItebis) {
        this.fCobraItebis = fCobraItebis;
    }

    public Boolean getFValidarRnc() {
        return fValidarRnc;
    }

    public void setFValidarRnc(Boolean fValidarRnc) {
        this.fValidarRnc = fValidarRnc;
    }

    public Date getFFechaInicio() {
        return fFechaInicio;
    }

    public void setFFechaInicio(Date fFechaInicio) {
        this.fFechaInicio = fFechaInicio;
    }

    public Date getFFechaFin() {
        return fFechaFin;
    }

    public void setFFechaFin(Date fFechaFin) {
        this.fFechaFin = fFechaFin;
    }

    public Boolean getFValidaFechaVigencia() {
        return fValidaFechaVigencia;
    }

    public void setFValidaFechaVigencia(Boolean fValidaFechaVigencia) {
        this.fValidaFechaVigencia = fValidaFechaVigencia;
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
        if (!(object instanceof TNcf)) {
            return false;
        }
        TNcf other = (TNcf) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TNcf[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
