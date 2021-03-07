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
@Table(name = "t_mensajeros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TMensajeros.findAll", query = "SELECT t FROM TMensajeros t"),
    @NamedQuery(name = "TMensajeros.findByFIdrecord", query = "SELECT t FROM TMensajeros t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TMensajeros.findByFNombreMensajero", query = "SELECT t FROM TMensajeros t WHERE t.fNombreMensajero = :fNombreMensajero"),
    @NamedQuery(name = "TMensajeros.findByFFechaHora", query = "SELECT t FROM TMensajeros t WHERE t.fFechaHora = :fFechaHora"),
    @NamedQuery(name = "TMensajeros.findByFActivo", query = "SELECT t FROM TMensajeros t WHERE t.fActivo = :fActivo"),
    @NamedQuery(name = "TMensajeros.findByFIdempresa", query = "SELECT t FROM TMensajeros t WHERE t.fIdempresa = :fIdempresa")})
public class TMensajeros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_nombre_mensajero")
    private String fNombreMensajero;
    @Column(name = "f_fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaHora;
    @Column(name = "f_activo")
    private Boolean fActivo;
    @Column(name = "f_idempresa")
    private Integer fIdempresa;

    public TMensajeros() {
    }

    public TMensajeros(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public Integer getFIdrecord() {
        return fIdrecord;
    }

    public void setFIdrecord(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public String getFNombreMensajero() {
        return fNombreMensajero;
    }

    public void setFNombreMensajero(String fNombreMensajero) {
        this.fNombreMensajero = fNombreMensajero;
    }

    public Date getFFechaHora() {
        return fFechaHora;
    }

    public void setFFechaHora(Date fFechaHora) {
        this.fFechaHora = fFechaHora;
    }

    public Boolean getFActivo() {
        return fActivo;
    }

    public void setFActivo(Boolean fActivo) {
        this.fActivo = fActivo;
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
        if (!(object instanceof TMensajeros)) {
            return false;
        }
        TMensajeros other = (TMensajeros) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TMensajeros[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
