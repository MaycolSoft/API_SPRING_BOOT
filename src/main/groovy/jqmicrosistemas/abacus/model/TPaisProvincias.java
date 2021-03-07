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
@Table(name = "t_pais_provincias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPaisProvincias.findAll", query = "SELECT t FROM TPaisProvincias t"),
    @NamedQuery(name = "TPaisProvincias.findByFIdrecord", query = "SELECT t FROM TPaisProvincias t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TPaisProvincias.findByFIdpais", query = "SELECT t FROM TPaisProvincias t WHERE t.fIdpais = :fIdpais"),
    @NamedQuery(name = "TPaisProvincias.findByFIdprovincia", query = "SELECT t FROM TPaisProvincias t WHERE t.fIdprovincia = :fIdprovincia"),
    @NamedQuery(name = "TPaisProvincias.findByFIdempresa", query = "SELECT t FROM TPaisProvincias t WHERE t.fIdempresa = :fIdempresa")})
public class TPaisProvincias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_idpais")
    private Integer fIdpais;
    @Column(name = "f_idprovincia")
    private Integer fIdprovincia;
    @Column(name = "f_idempresa")
    private Integer fIdempresa;

    public TPaisProvincias() {
    }

    public TPaisProvincias(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public Integer getFIdrecord() {
        return fIdrecord;
    }

    public void setFIdrecord(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public Integer getFIdpais() {
        return fIdpais;
    }

    public void setFIdpais(Integer fIdpais) {
        this.fIdpais = fIdpais;
    }

    public Integer getFIdprovincia() {
        return fIdprovincia;
    }

    public void setFIdprovincia(Integer fIdprovincia) {
        this.fIdprovincia = fIdprovincia;
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
        if (!(object instanceof TPaisProvincias)) {
            return false;
        }
        TPaisProvincias other = (TPaisProvincias) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TPaisProvincias[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
