/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jqmicrosistemas.abacus.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "t_suplidores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSuplidores.findAll", query = "SELECT t FROM TSuplidores t"),
    @NamedQuery(name = "TSuplidores.findByFIdrecord", query = "SELECT t FROM TSuplidores t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TSuplidores.findByFIdempresa", query = "SELECT t FROM TSuplidores t WHERE t.fIdempresa = :fIdempresa"),
    @NamedQuery(name = "TSuplidores.findByFIdsuplidor", query = "SELECT t FROM TSuplidores t WHERE t.fIdsuplidor = :fIdsuplidor"),
    @NamedQuery(name = "TSuplidores.findByFNombre", query = "SELECT t FROM TSuplidores t WHERE t.fNombre = :fNombre"),
    @NamedQuery(name = "TSuplidores.findByFVendedor", query = "SELECT t FROM TSuplidores t WHERE t.fVendedor = :fVendedor"),
    @NamedQuery(name = "TSuplidores.findByFDireccion", query = "SELECT t FROM TSuplidores t WHERE t.fDireccion = :fDireccion"),
    @NamedQuery(name = "TSuplidores.findByFFax", query = "SELECT t FROM TSuplidores t WHERE t.fFax = :fFax"),
    @NamedQuery(name = "TSuplidores.findByFTelefono", query = "SELECT t FROM TSuplidores t WHERE t.fTelefono = :fTelefono"),
    @NamedQuery(name = "TSuplidores.findByFEmail", query = "SELECT t FROM TSuplidores t WHERE t.fEmail = :fEmail"),
    @NamedQuery(name = "TSuplidores.findByFRnc", query = "SELECT t FROM TSuplidores t WHERE t.fRnc = :fRnc"),
    @NamedQuery(name = "TSuplidores.findByFBalance", query = "SELECT t FROM TSuplidores t WHERE t.fBalance = :fBalance"),
    @NamedQuery(name = "TSuplidores.findByFPais", query = "SELECT t FROM TSuplidores t WHERE t.fPais = :fPais"),
    @NamedQuery(name = "TSuplidores.findByFWeb", query = "SELECT t FROM TSuplidores t WHERE t.fWeb = :fWeb"),
    @NamedQuery(name = "TSuplidores.findByFCuentaContable", query = "SELECT t FROM TSuplidores t WHERE t.fCuentaContable = :fCuentaContable"),
    @NamedQuery(name = "TSuplidores.findByFEsFormal", query = "SELECT t FROM TSuplidores t WHERE t.fEsFormal = :fEsFormal"),
    @NamedQuery(name = "TSuplidores.findByFPorcentajeRetencion", query = "SELECT t FROM TSuplidores t WHERE t.fPorcentajeRetencion = :fPorcentajeRetencion"),
    @NamedQuery(name = "TSuplidores.findByFFechaIngreso", query = "SELECT t FROM TSuplidores t WHERE t.fFechaIngreso = :fFechaIngreso")})
public class TSuplidores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Basic(optional = false)
    @Column(name = "f_idempresa")
    private int fIdempresa;
    @Column(name = "f_idsuplidor")
    private Integer fIdsuplidor;
    @Basic(optional = false)
    @Column(name = "f_nombre")
    private String fNombre;
    @Column(name = "f_vendedor")
    private String fVendedor;
    @Column(name = "f_direccion")
    private String fDireccion;
    @Column(name = "f_fax")
    private String fFax;
    @Column(name = "f_telefono")
    private String fTelefono;
    @Column(name = "f_email")
    private String fEmail;
    @Column(name = "f_rnc")
    private String fRnc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "f_balance")
    private BigDecimal fBalance;
    @Column(name = "f_pais")
    private String fPais;
    @Column(name = "f_web")
    private String fWeb;
    @Column(name = "f_cuenta_contable")
    private String fCuentaContable;
    @Column(name = "f_es_formal")
    private Boolean fEsFormal;
    @Column(name = "f_porcentaje_retencion")
    private BigDecimal fPorcentajeRetencion;
    @Column(name = "f_fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fFechaIngreso;

    public TSuplidores() {
    }

    public TSuplidores(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public TSuplidores(Integer fIdrecord, int fIdempresa, String fNombre) {
        this.fIdrecord = fIdrecord;
        this.fIdempresa = fIdempresa;
        this.fNombre = fNombre;
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

    public Integer getFIdsuplidor() {
        return fIdsuplidor;
    }

    public void setFIdsuplidor(Integer fIdsuplidor) {
        this.fIdsuplidor = fIdsuplidor;
    }

    public String getFNombre() {
        return fNombre;
    }

    public void setFNombre(String fNombre) {
        this.fNombre = fNombre;
    }

    public String getFVendedor() {
        return fVendedor;
    }

    public void setFVendedor(String fVendedor) {
        this.fVendedor = fVendedor;
    }

    public String getFDireccion() {
        return fDireccion;
    }

    public void setFDireccion(String fDireccion) {
        this.fDireccion = fDireccion;
    }

    public String getFFax() {
        return fFax;
    }

    public void setFFax(String fFax) {
        this.fFax = fFax;
    }

    public String getFTelefono() {
        return fTelefono;
    }

    public void setFTelefono(String fTelefono) {
        this.fTelefono = fTelefono;
    }

    public String getFEmail() {
        return fEmail;
    }

    public void setFEmail(String fEmail) {
        this.fEmail = fEmail;
    }

    public String getFRnc() {
        return fRnc;
    }

    public void setFRnc(String fRnc) {
        this.fRnc = fRnc;
    }

    public BigDecimal getFBalance() {
        return fBalance;
    }

    public void setFBalance(BigDecimal fBalance) {
        this.fBalance = fBalance;
    }

    public String getFPais() {
        return fPais;
    }

    public void setFPais(String fPais) {
        this.fPais = fPais;
    }

    public String getFWeb() {
        return fWeb;
    }

    public void setFWeb(String fWeb) {
        this.fWeb = fWeb;
    }

    public String getFCuentaContable() {
        return fCuentaContable;
    }

    public void setFCuentaContable(String fCuentaContable) {
        this.fCuentaContable = fCuentaContable;
    }

    public Boolean getFEsFormal() {
        return fEsFormal;
    }

    public void setFEsFormal(Boolean fEsFormal) {
        this.fEsFormal = fEsFormal;
    }

    public BigDecimal getFPorcentajeRetencion() {
        return fPorcentajeRetencion;
    }

    public void setFPorcentajeRetencion(BigDecimal fPorcentajeRetencion) {
        this.fPorcentajeRetencion = fPorcentajeRetencion;
    }

    public Date getFFechaIngreso() {
        return fFechaIngreso;
    }

    public void setFFechaIngreso(Date fFechaIngreso) {
        this.fFechaIngreso = fFechaIngreso;
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
        if (!(object instanceof TSuplidores)) {
            return false;
        }
        TSuplidores other = (TSuplidores) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TSuplidores[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
