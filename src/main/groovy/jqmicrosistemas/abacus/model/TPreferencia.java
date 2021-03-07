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
import javax.persistence.Lob;
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
@Table(name = "t_preferencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPreferencia.findAll", query = "SELECT t FROM TPreferencia t"),
    @NamedQuery(name = "TPreferencia.findByFIdrecord", query = "SELECT t FROM TPreferencia t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TPreferencia.findByFIdempresa", query = "SELECT t FROM TPreferencia t WHERE t.fIdempresa = :fIdempresa"),
    @NamedQuery(name = "TPreferencia.findByFNombrecia", query = "SELECT t FROM TPreferencia t WHERE t.fNombrecia = :fNombrecia"),
    @NamedQuery(name = "TPreferencia.findByFEmpresa", query = "SELECT t FROM TPreferencia t WHERE t.fEmpresa = :fEmpresa"),
    @NamedQuery(name = "TPreferencia.findByFDireccion", query = "SELECT t FROM TPreferencia t WHERE t.fDireccion = :fDireccion"),
    @NamedQuery(name = "TPreferencia.findByFFax", query = "SELECT t FROM TPreferencia t WHERE t.fFax = :fFax"),
    @NamedQuery(name = "TPreferencia.findByFRnc", query = "SELECT t FROM TPreferencia t WHERE t.fRnc = :fRnc"),
    @NamedQuery(name = "TPreferencia.findByFSiglas", query = "SELECT t FROM TPreferencia t WHERE t.fSiglas = :fSiglas"),
    @NamedQuery(name = "TPreferencia.findByFItbisIncluido", query = "SELECT t FROM TPreferencia t WHERE t.fItbisIncluido = :fItbisIncluido"),
    @NamedQuery(name = "TPreferencia.findByFDiasItbis", query = "SELECT t FROM TPreferencia t WHERE t.fDiasItbis = :fDiasItbis"),
    @NamedQuery(name = "TPreferencia.findByFTelefono", query = "SELECT t FROM TPreferencia t WHERE t.fTelefono = :fTelefono"),
    @NamedQuery(name = "TPreferencia.findByFEmail", query = "SELECT t FROM TPreferencia t WHERE t.fEmail = :fEmail"),
    @NamedQuery(name = "TPreferencia.findByFFechaInicioSistema", query = "SELECT t FROM TPreferencia t WHERE t.fFechaInicioSistema = :fFechaInicioSistema"),
    @NamedQuery(name = "TPreferencia.findByFMesinicialfiscal", query = "SELECT t FROM TPreferencia t WHERE t.fMesinicialfiscal = :fMesinicialfiscal"),
    @NamedQuery(name = "TPreferencia.findByFMesfinalfiscal", query = "SELECT t FROM TPreferencia t WHERE t.fMesfinalfiscal = :fMesfinalfiscal"),
    @NamedQuery(name = "TPreferencia.findByFClaveCosto", query = "SELECT t FROM TPreferencia t WHERE t.fClaveCosto = :fClaveCosto"),
    @NamedQuery(name = "TPreferencia.findByFClavePrecio", query = "SELECT t FROM TPreferencia t WHERE t.fClavePrecio = :fClavePrecio"),
    @NamedQuery(name = "TPreferencia.findByFGrupoActivos", query = "SELECT t FROM TPreferencia t WHERE t.fGrupoActivos = :fGrupoActivos"),
    @NamedQuery(name = "TPreferencia.findByFGrupoPasivos", query = "SELECT t FROM TPreferencia t WHERE t.fGrupoPasivos = :fGrupoPasivos"),
    @NamedQuery(name = "TPreferencia.findByFGrupoCapital", query = "SELECT t FROM TPreferencia t WHERE t.fGrupoCapital = :fGrupoCapital"),
    @NamedQuery(name = "TPreferencia.findByFGrupoIngresos", query = "SELECT t FROM TPreferencia t WHERE t.fGrupoIngresos = :fGrupoIngresos"),
    @NamedQuery(name = "TPreferencia.findByFGrupoCostos", query = "SELECT t FROM TPreferencia t WHERE t.fGrupoCostos = :fGrupoCostos"),
    @NamedQuery(name = "TPreferencia.findByFGrupoGastos", query = "SELECT t FROM TPreferencia t WHERE t.fGrupoGastos = :fGrupoGastos"),
    @NamedQuery(name = "TPreferencia.findByFCuentaDebitoPago", query = "SELECT t FROM TPreferencia t WHERE t.fCuentaDebitoPago = :fCuentaDebitoPago"),
    @NamedQuery(name = "TPreferencia.findByFCuentadepositosdefecto", query = "SELECT t FROM TPreferencia t WHERE t.fCuentadepositosdefecto = :fCuentadepositosdefecto"),
    @NamedQuery(name = "TPreferencia.findByFDiasFacturas", query = "SELECT t FROM TPreferencia t WHERE t.fDiasFacturas = :fDiasFacturas"),
    @NamedQuery(name = "TPreferencia.findByFAutentificatDispositivo", query = "SELECT t FROM TPreferencia t WHERE t.fAutentificatDispositivo = :fAutentificatDispositivo"),
    @NamedQuery(name = "TPreferencia.findByFHeader", query = "SELECT t FROM TPreferencia t WHERE t.fHeader = :fHeader"),
    @NamedQuery(name = "TPreferencia.findByFUsaDetallesContables", query = "SELECT t FROM TPreferencia t WHERE t.fUsaDetallesContables = :fUsaDetallesContables"),
    @NamedQuery(name = "TPreferencia.findByFDiasDevolucion", query = "SELECT t FROM TPreferencia t WHERE t.fDiasDevolucion = :fDiasDevolucion"),
    @NamedQuery(name = "TPreferencia.findByFMoraPrestamos", query = "SELECT t FROM TPreferencia t WHERE t.fMoraPrestamos = :fMoraPrestamos"),
    @NamedQuery(name = "TPreferencia.findByFDiasMora", query = "SELECT t FROM TPreferencia t WHERE t.fDiasMora = :fDiasMora")})
public class TPreferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_idempresa")
    private Integer fIdempresa;
    @Column(name = "f_nombrecia")
    private String fNombrecia;
    @Column(name = "f_empresa")
    private String fEmpresa;
    @Column(name = "f_direccion")
    private String fDireccion;
    @Column(name = "f_fax")
    private String fFax;
    @Column(name = "f_rnc")
    private String fRnc;
    @Column(name = "f_siglas")
    private String fSiglas;
    @Column(name = "f_itbis_incluido")
    private Boolean fItbisIncluido;
    @Column(name = "f_dias_itbis")
    private Integer fDiasItbis;
    @Column(name = "f_telefono")
    private String fTelefono;
    @Lob
    @Column(name = "f_logo")
    private byte[] fLogo;
    @Column(name = "f_email")
    private String fEmail;
    @Column(name = "f_fecha_inicio_sistema")
    @Temporal(TemporalType.DATE)
    private Date fFechaInicioSistema;
    @Column(name = "f_mesinicialfiscal")
    private Integer fMesinicialfiscal;
    @Column(name = "f_mesfinalfiscal")
    private Integer fMesfinalfiscal;
    @Column(name = "f_clave_costo")
    private String fClaveCosto;
    @Column(name = "f_clave_precio")
    private String fClavePrecio;
    @Column(name = "f_grupo_activos")
    private String fGrupoActivos;
    @Column(name = "f_grupo_pasivos")
    private String fGrupoPasivos;
    @Column(name = "f_grupo_capital")
    private String fGrupoCapital;
    @Column(name = "f_grupo_ingresos")
    private String fGrupoIngresos;
    @Column(name = "f_grupo_costos")
    private String fGrupoCostos;
    @Column(name = "f_grupo_gastos")
    private String fGrupoGastos;
    @Column(name = "f_cuenta_debito_pago")
    private String fCuentaDebitoPago;
    @Column(name = "f_cuentadepositosdefecto")
    private String fCuentadepositosdefecto;
    @Column(name = "f_dias_facturas")
    private Integer fDiasFacturas;
    @Column(name = "f_autentificat_dispositivo")
    private Boolean fAutentificatDispositivo;
    @Column(name = "f_header")
    private String fHeader;
    @Column(name = "f_usa_detalles_contables")
    private Boolean fUsaDetallesContables;
    @Column(name = "f_dias_devolucion")
    private Integer fDiasDevolucion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "f_mora_prestamos")
    private BigDecimal fMoraPrestamos;
    @Column(name = "f_dias_mora")
    private Integer fDiasMora;

    public TPreferencia() {
    }

    public TPreferencia(Integer fIdrecord) {
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

    public String getFNombrecia() {
        return fNombrecia;
    }

    public void setFNombrecia(String fNombrecia) {
        this.fNombrecia = fNombrecia;
    }

    public String getFEmpresa() {
        return fEmpresa;
    }

    public void setFEmpresa(String fEmpresa) {
        this.fEmpresa = fEmpresa;
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

    public String getFRnc() {
        return fRnc;
    }

    public void setFRnc(String fRnc) {
        this.fRnc = fRnc;
    }

    public String getFSiglas() {
        return fSiglas;
    }

    public void setFSiglas(String fSiglas) {
        this.fSiglas = fSiglas;
    }

    public Boolean getFItbisIncluido() {
        return fItbisIncluido;
    }

    public void setFItbisIncluido(Boolean fItbisIncluido) {
        this.fItbisIncluido = fItbisIncluido;
    }

    public Integer getFDiasItbis() {
        return fDiasItbis;
    }

    public void setFDiasItbis(Integer fDiasItbis) {
        this.fDiasItbis = fDiasItbis;
    }

    public String getFTelefono() {
        return fTelefono;
    }

    public void setFTelefono(String fTelefono) {
        this.fTelefono = fTelefono;
    }

    public byte[] getFLogo() {
        return fLogo;
    }

    public void setFLogo(byte[] fLogo) {
        this.fLogo = fLogo;
    }

    public String getFEmail() {
        return fEmail;
    }

    public void setFEmail(String fEmail) {
        this.fEmail = fEmail;
    }

    public Date getFFechaInicioSistema() {
        return fFechaInicioSistema;
    }

    public void setFFechaInicioSistema(Date fFechaInicioSistema) {
        this.fFechaInicioSistema = fFechaInicioSistema;
    }

    public Integer getFMesinicialfiscal() {
        return fMesinicialfiscal;
    }

    public void setFMesinicialfiscal(Integer fMesinicialfiscal) {
        this.fMesinicialfiscal = fMesinicialfiscal;
    }

    public Integer getFMesfinalfiscal() {
        return fMesfinalfiscal;
    }

    public void setFMesfinalfiscal(Integer fMesfinalfiscal) {
        this.fMesfinalfiscal = fMesfinalfiscal;
    }

    public String getFClaveCosto() {
        return fClaveCosto;
    }

    public void setFClaveCosto(String fClaveCosto) {
        this.fClaveCosto = fClaveCosto;
    }

    public String getFClavePrecio() {
        return fClavePrecio;
    }

    public void setFClavePrecio(String fClavePrecio) {
        this.fClavePrecio = fClavePrecio;
    }

    public String getFGrupoActivos() {
        return fGrupoActivos;
    }

    public void setFGrupoActivos(String fGrupoActivos) {
        this.fGrupoActivos = fGrupoActivos;
    }

    public String getFGrupoPasivos() {
        return fGrupoPasivos;
    }

    public void setFGrupoPasivos(String fGrupoPasivos) {
        this.fGrupoPasivos = fGrupoPasivos;
    }

    public String getFGrupoCapital() {
        return fGrupoCapital;
    }

    public void setFGrupoCapital(String fGrupoCapital) {
        this.fGrupoCapital = fGrupoCapital;
    }

    public String getFGrupoIngresos() {
        return fGrupoIngresos;
    }

    public void setFGrupoIngresos(String fGrupoIngresos) {
        this.fGrupoIngresos = fGrupoIngresos;
    }

    public String getFGrupoCostos() {
        return fGrupoCostos;
    }

    public void setFGrupoCostos(String fGrupoCostos) {
        this.fGrupoCostos = fGrupoCostos;
    }

    public String getFGrupoGastos() {
        return fGrupoGastos;
    }

    public void setFGrupoGastos(String fGrupoGastos) {
        this.fGrupoGastos = fGrupoGastos;
    }

    public String getFCuentaDebitoPago() {
        return fCuentaDebitoPago;
    }

    public void setFCuentaDebitoPago(String fCuentaDebitoPago) {
        this.fCuentaDebitoPago = fCuentaDebitoPago;
    }

    public String getFCuentadepositosdefecto() {
        return fCuentadepositosdefecto;
    }

    public void setFCuentadepositosdefecto(String fCuentadepositosdefecto) {
        this.fCuentadepositosdefecto = fCuentadepositosdefecto;
    }

    public Integer getFDiasFacturas() {
        return fDiasFacturas;
    }

    public void setFDiasFacturas(Integer fDiasFacturas) {
        this.fDiasFacturas = fDiasFacturas;
    }

    public Boolean getFAutentificatDispositivo() {
        return fAutentificatDispositivo;
    }

    public void setFAutentificatDispositivo(Boolean fAutentificatDispositivo) {
        this.fAutentificatDispositivo = fAutentificatDispositivo;
    }

    public String getFHeader() {
        return fHeader;
    }

    public void setFHeader(String fHeader) {
        this.fHeader = fHeader;
    }

    public Boolean getFUsaDetallesContables() {
        return fUsaDetallesContables;
    }

    public void setFUsaDetallesContables(Boolean fUsaDetallesContables) {
        this.fUsaDetallesContables = fUsaDetallesContables;
    }

    public Integer getFDiasDevolucion() {
        return fDiasDevolucion;
    }

    public void setFDiasDevolucion(Integer fDiasDevolucion) {
        this.fDiasDevolucion = fDiasDevolucion;
    }

    public BigDecimal getFMoraPrestamos() {
        return fMoraPrestamos;
    }

    public void setFMoraPrestamos(BigDecimal fMoraPrestamos) {
        this.fMoraPrestamos = fMoraPrestamos;
    }

    public Integer getFDiasMora() {
        return fDiasMora;
    }

    public void setFDiasMora(Integer fDiasMora) {
        this.fDiasMora = fDiasMora;
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
        if (!(object instanceof TPreferencia)) {
            return false;
        }
        TPreferencia other = (TPreferencia) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TPreferencia[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
