/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jqmicrosistemas.abacus.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maycol
 */
@Entity
@Table(name = "t_recargas_respuestas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TRecargasRespuestas.findAll", query = "SELECT t FROM TRecargasRespuestas t"),
    @NamedQuery(name = "TRecargasRespuestas.findByFIdrecord", query = "SELECT t FROM TRecargasRespuestas t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TRecargasRespuestas.findByFIdempresa", query = "SELECT t FROM TRecargasRespuestas t WHERE t.fIdempresa = :fIdempresa"),
    @NamedQuery(name = "TRecargasRespuestas.findByFRespuesta", query = "SELECT t FROM TRecargasRespuestas t WHERE t.fRespuesta = :fRespuesta"),
    @NamedQuery(name = "TRecargasRespuestas.findByFMonto", query = "SELECT t FROM TRecargasRespuestas t WHERE t.fMonto = :fMonto"),
    @NamedQuery(name = "TRecargasRespuestas.findByFIsp", query = "SELECT t FROM TRecargasRespuestas t WHERE t.fIsp = :fIsp")})
public class TRecargasRespuestas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_idempresa")
    private Integer fIdempresa;
    @Column(name = "f_respuesta")
    private String fRespuesta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "f_monto")
    private BigDecimal fMonto;
    @Column(name = "f_isp")
    private String fIsp;

    public TRecargasRespuestas() {
    }

    public TRecargasRespuestas(Integer fIdrecord) {
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

    public String getFRespuesta() {
        return fRespuesta;
    }

    public void setFRespuesta(String fRespuesta) {
        this.fRespuesta = fRespuesta;
    }

    public BigDecimal getFMonto() {
        return fMonto;
    }

    public void setFMonto(BigDecimal fMonto) {
        this.fMonto = fMonto;
    }

    public String getFIsp() {
        return fIsp;
    }

    public void setFIsp(String fIsp) {
        this.fIsp = fIsp;
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
        if (!(object instanceof TRecargasRespuestas)) {
            return false;
        }
        TRecargasRespuestas other = (TRecargasRespuestas) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TRecargasRespuestas[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
