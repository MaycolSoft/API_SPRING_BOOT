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
@Table(name = "t_tipo_billete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTipoBillete.findAll", query = "SELECT t FROM TTipoBillete t"),
    @NamedQuery(name = "TTipoBillete.findByFIdrecord", query = "SELECT t FROM TTipoBillete t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TTipoBillete.findByFDescripcion", query = "SELECT t FROM TTipoBillete t WHERE t.fDescripcion = :fDescripcion"),
    @NamedQuery(name = "TTipoBillete.findByFValor", query = "SELECT t FROM TTipoBillete t WHERE t.fValor = :fValor")})
public class TTipoBillete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_descripcion")
    private String fDescripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "f_valor")
    private BigDecimal fValor;

    public TTipoBillete() {
    }

    public TTipoBillete(Integer fIdrecord) {
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

    public BigDecimal getFValor() {
        return fValor;
    }

    public void setFValor(BigDecimal fValor) {
        this.fValor = fValor;
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
        if (!(object instanceof TTipoBillete)) {
            return false;
        }
        TTipoBillete other = (TTipoBillete) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TTipoBillete[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
