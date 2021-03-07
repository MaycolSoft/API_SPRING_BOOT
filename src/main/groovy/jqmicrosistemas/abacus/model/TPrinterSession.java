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
@Table(name = "t_printer_session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPrinterSession.findAll", query = "SELECT t FROM TPrinterSession t"),
    @NamedQuery(name = "TPrinterSession.findByFIdrecord", query = "SELECT t FROM TPrinterSession t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TPrinterSession.findByFIdClientPrinter", query = "SELECT t FROM TPrinterSession t WHERE t.fIdClientPrinter = :fIdClientPrinter"),
    @NamedQuery(name = "TPrinterSession.findByTSeccion", query = "SELECT t FROM TPrinterSession t WHERE t.tSeccion = :tSeccion"),
    @NamedQuery(name = "TPrinterSession.findByFFecha", query = "SELECT t FROM TPrinterSession t WHERE t.fFecha = :fFecha")})
public class TPrinterSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_id_client_printer")
    private String fIdClientPrinter;
    @Column(name = "t_seccion")
    private String tSeccion;
    @Column(name = "f_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFecha;

    public TPrinterSession() {
    }

    public TPrinterSession(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public Integer getFIdrecord() {
        return fIdrecord;
    }

    public void setFIdrecord(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public String getFIdClientPrinter() {
        return fIdClientPrinter;
    }

    public void setFIdClientPrinter(String fIdClientPrinter) {
        this.fIdClientPrinter = fIdClientPrinter;
    }

    public String getTSeccion() {
        return tSeccion;
    }

    public void setTSeccion(String tSeccion) {
        this.tSeccion = tSeccion;
    }

    public Date getFFecha() {
        return fFecha;
    }

    public void setFFecha(Date fFecha) {
        this.fFecha = fFecha;
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
        if (!(object instanceof TPrinterSession)) {
            return false;
        }
        TPrinterSession other = (TPrinterSession) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TPrinterSession[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
