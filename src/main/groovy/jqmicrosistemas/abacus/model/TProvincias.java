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
@Table(name = "t_provincias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TProvincias.findAll", query = "SELECT t FROM TProvincias t"),
    @NamedQuery(name = "TProvincias.findByFIdrecord", query = "SELECT t FROM TProvincias t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TProvincias.findByFDescripcion", query = "SELECT t FROM TProvincias t WHERE t.fDescripcion = :fDescripcion"),
    @NamedQuery(name = "TProvincias.findByFIdempresa", query = "SELECT t FROM TProvincias t WHERE t.fIdempresa = :fIdempresa")})
public class TProvincias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_descripcion")
    private String fDescripcion;
    @Column(name = "f_idempresa")
    private Integer fIdempresa;

    public TProvincias() {
    }

    public TProvincias(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public Integer getFIdrecord() {
        return fIdrecord;
    }

    public void setFIdrecord(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public String getFDescripcion() {
        return fDescripcion;
    }

    public void setFDescripcion(String fDescripcion) {
        this.fDescripcion = fDescripcion;
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
        if (!(object instanceof TProvincias)) {
            return false;
        }
        TProvincias other = (TProvincias) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TProvincias[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
