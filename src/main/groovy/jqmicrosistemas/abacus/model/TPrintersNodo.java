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
@Table(name = "t_printers_nodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPrintersNodo.findAll", query = "SELECT t FROM TPrintersNodo t"),
    @NamedQuery(name = "TPrintersNodo.findByFIdrecord", query = "SELECT t FROM TPrintersNodo t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TPrintersNodo.findByFIdempresa", query = "SELECT t FROM TPrintersNodo t WHERE t.fIdempresa = :fIdempresa"),
    @NamedQuery(name = "TPrintersNodo.findByFIdsucursal", query = "SELECT t FROM TPrintersNodo t WHERE t.fIdsucursal = :fIdsucursal"),
    @NamedQuery(name = "TPrintersNodo.findByFUsuario", query = "SELECT t FROM TPrintersNodo t WHERE t.fUsuario = :fUsuario"),
    @NamedQuery(name = "TPrintersNodo.findByFPass", query = "SELECT t FROM TPrintersNodo t WHERE t.fPass = :fPass"),
    @NamedQuery(name = "TPrintersNodo.findByFTipoimpresion", query = "SELECT t FROM TPrintersNodo t WHERE t.fTipoimpresion = :fTipoimpresion"),
    @NamedQuery(name = "TPrintersNodo.findByFActivo", query = "SELECT t FROM TPrintersNodo t WHERE t.fActivo = :fActivo"),
    @NamedQuery(name = "TPrintersNodo.findByFTipodevice", query = "SELECT t FROM TPrintersNodo t WHERE t.fTipodevice = :fTipodevice"),
    @NamedQuery(name = "TPrintersNodo.findByFPrinter", query = "SELECT t FROM TPrintersNodo t WHERE t.fPrinter = :fPrinter")})
public class TPrintersNodo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Basic(optional = false)
    @Column(name = "f_idempresa")
    private int fIdempresa;
    @Basic(optional = false)
    @Column(name = "f_idsucursal")
    private int fIdsucursal;
    @Basic(optional = false)
    @Column(name = "f_usuario")
    private String fUsuario;
    @Basic(optional = false)
    @Column(name = "f_pass")
    private String fPass;
    @Column(name = "f_tipoimpresion")
    private Integer fTipoimpresion;
    @Column(name = "f_activo")
    private Boolean fActivo;
    @Basic(optional = false)
    @Column(name = "f_tipodevice")
    private int fTipodevice;
    @Column(name = "f_printer")
    private String fPrinter;

    public TPrintersNodo() {
    }

    public TPrintersNodo(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public TPrintersNodo(Integer fIdrecord, int fIdempresa, int fIdsucursal, String fUsuario, String fPass, int fTipodevice) {
        this.fIdrecord = fIdrecord;
        this.fIdempresa = fIdempresa;
        this.fIdsucursal = fIdsucursal;
        this.fUsuario = fUsuario;
        this.fPass = fPass;
        this.fTipodevice = fTipodevice;
    }

    public Integer getFIdrecord() {
        return fIdrecord;
    }

    public void setFIdrecord(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public int getFIdempresa() {
        return fIdempresa;
    }

    public void setFIdempresa(int fIdempresa) {
        this.fIdempresa = fIdempresa;
    }

    public int getFIdsucursal() {
        return fIdsucursal;
    }

    public void setFIdsucursal(int fIdsucursal) {
        this.fIdsucursal = fIdsucursal;
    }

    public String getFUsuario() {
        return fUsuario;
    }

    public void setFUsuario(String fUsuario) {
        this.fUsuario = fUsuario;
    }

    public String getFPass() {
        return fPass;
    }

    public void setFPass(String fPass) {
        this.fPass = fPass;
    }

    public Integer getFTipoimpresion() {
        return fTipoimpresion;
    }

    public void setFTipoimpresion(Integer fTipoimpresion) {
        this.fTipoimpresion = fTipoimpresion;
    }

    public Boolean getFActivo() {
        return fActivo;
    }

    public void setFActivo(Boolean fActivo) {
        this.fActivo = fActivo;
    }

    public int getFTipodevice() {
        return fTipodevice;
    }

    public void setFTipodevice(int fTipodevice) {
        this.fTipodevice = fTipodevice;
    }

    public String getFPrinter() {
        return fPrinter;
    }

    public void setFPrinter(String fPrinter) {
        this.fPrinter = fPrinter;
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
        if (!(object instanceof TPrintersNodo)) {
            return false;
        }
        TPrintersNodo other = (TPrintersNodo) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TPrintersNodo[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
