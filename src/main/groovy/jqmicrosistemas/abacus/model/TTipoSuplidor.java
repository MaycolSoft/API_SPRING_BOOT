/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jqmicrosistemas.abacus.model;

import java.io.Serializable;
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
@Table(name = "t_tipo_suplidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTipoSuplidor.findAll", query = "SELECT t FROM TTipoSuplidor t"),
    @NamedQuery(name = "TTipoSuplidor.findByFIdrecord", query = "SELECT t FROM TTipoSuplidor t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TTipoSuplidor.findByFIdempresa", query = "SELECT t FROM TTipoSuplidor t WHERE t.fIdempresa = :fIdempresa"),
    @NamedQuery(name = "TTipoSuplidor.findByFDescripcion", query = "SELECT t FROM TTipoSuplidor t WHERE t.fDescripcion = :fDescripcion"),
    @NamedQuery(name = "TTipoSuplidor.findByFCuenta", query = "SELECT t FROM TTipoSuplidor t WHERE t.fCuenta = :fCuenta")})
public class TTipoSuplidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_idempresa")
    private Integer fIdempresa;
    @Column(name = "f_descripcion")
    private String fDescripcion;
    @Column(name = "f_cuenta")
    private String fCuenta;

    public TTipoSuplidor() {
    }

    public TTipoSuplidor(Integer fIdrecord) {
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

    public String getFDescripcion() {
        return fDescripcion;
    }

    public void setFDescripcion(String fDescripcion) {
        this.fDescripcion = fDescripcion;
    }

    public String getFCuenta() {
        return fCuenta;
    }

    public void setFCuenta(String fCuenta) {
        this.fCuenta = fCuenta;
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
        if (!(object instanceof TTipoSuplidor)) {
            return false;
        }
        TTipoSuplidor other = (TTipoSuplidor) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TTipoSuplidor[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
