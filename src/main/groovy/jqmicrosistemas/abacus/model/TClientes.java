/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jqmicrosistemas.abacus.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maycol
 */
@Entity
@Table(name = "t_clientes")

@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "TClientes.findAllByFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fIdempresa = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFIdrecordAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fIdrecord = ?1 and t.fIdempresa = ?2 "),
        @NamedQuery(name = "TClientes.findByFIdclienteAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fIdcliente = ?1  and t.fIdempresa = ?2 "),
        @NamedQuery(name = "TClientes.findByFNombreAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fNombre = ?1 and t.fIdempresa = ?2 "),
        @NamedQuery(name = "TClientes.findByFApellidoAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fApellido = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFSucursalAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fSucursal = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFBalanceAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fBalance = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFCedulaAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fCedula = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFFechaAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fFecha = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFLimiteCreditoAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fLimiteCredito = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFFacturarcreditoAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fFacturarcredito = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFDiasCreditoAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fDiasCredito = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFCelularAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fCelular = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFDireccion1AndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fDireccion1 = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFDireccion2AndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fDireccion2 = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFProvinciaAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fProvincia = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFZipcodeAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fZipcode = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFDireccionEnvioAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fDireccionEnvio = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFFechaYearAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fFechaYear = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFEmpresa", query = "SELECT t FROM TClientes t WHERE t.fEmpresa = ?1"),
        @NamedQuery(name = "TClientes.findByFMensajeAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fMensaje = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFIdzonaAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fIdzona = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFTipoClienteAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fTipoCliente = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFFormaEnvioAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fFormaEnvio = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFExentoImpuestosAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fExentoImpuestos = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFTipoMonedaAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fTipoMoneda = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFDescripcionAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fDescripcion = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFContactoAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fContacto = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFEmailAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fEmail = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFNcfDefectoAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fNcfDefecto = ?1 and t.fIdempresa = ?2"),
        @NamedQuery(name = "TClientes.findByFPorcientoDescuentoAndFIdEmpresa", query = "SELECT t FROM TClientes t WHERE t.fPorcientoDescuento = ?1")
})
public class TClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_idempresa")
    private Integer fIdempresa;
    @Column(name = "f_idcliente")
    private Integer fIdcliente;
    @Column(name = "f_nombre")
    private String fNombre;
    @Column(name = "f_apellido")
    private String fApellido;
    @Column(name = "f_sucursal")
    private Integer fSucursal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "f_balance")
    private BigDecimal fBalance;
    @Column(name = "f_cedula")
    private String fCedula;
    @Column(name = "f_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFecha;
    @Column(name = "f_limite_credito")
    private BigDecimal fLimiteCredito;
    @Column(name = "f_facturarcredito")
    private Boolean fFacturarcredito;
    @Column(name = "f_dias_credito")
    private BigDecimal fDiasCredito;
    @Column(name = "f_celular")
    private String fCelular;
    @Column(name = "f_direccion1")
    private String fDireccion1;
    @Column(name = "f_direccion2")
    private String fDireccion2;
    @Column(name = "f_provincia")
    private String fProvincia;
    @Column(name = "f_zipcode")
    private String fZipcode;
    @Column(name = "f_direccion_envio")
    private String fDireccionEnvio;
    @Column(name = "f_fecha_year")
    @Temporal(TemporalType.DATE)
    private Date fFechaYear;
    @Column(name = "f_empresa")
    private String fEmpresa;
    @Column(name = "f_mensaje")
    private String fMensaje;
    @Column(name = "f_idzona")
    private Integer fIdzona;
    @Column(name = "f_tipo_cliente")
    private Integer fTipoCliente;
    @Column(name = "f_forma_envio")
    private String fFormaEnvio;
    @Column(name = "f_exento_impuestos")
    private Boolean fExentoImpuestos;
    @Column(name = "f_tipo_moneda")
    private Integer fTipoMoneda;
    @Column(name = "f_descripcion")
    private String fDescripcion;
    @Column(name = "f_contacto")
    private String fContacto;
    @Column(name = "f_email")
    private String fEmail;
    @Column(name = "f_ncf_defecto")
    private Integer fNcfDefecto;
    @Column(name = "f_porciento_descuento")
    private BigDecimal fPorcientoDescuento;

    public TClientes() {
    }


    public TClientes(Integer fIdrecord) {
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

    public Integer getFIdcliente() {
        return fIdcliente;
    }

    public void setFIdcliente(Integer fIdcliente) {
        this.fIdcliente = fIdcliente;
    }

    public String getFNombre() {
        return fNombre;
    }

    public void setFNombre(String fNombre) {
        this.fNombre = fNombre;
    }

    public String getFApellido() {
        return fApellido;
    }

    public void setFApellido(String fApellido) {
        this.fApellido = fApellido;
    }

    public Integer getFSucursal() {
        return fSucursal;
    }

    public void setFSucursal(Integer fSucursal) {
        this.fSucursal = fSucursal;
    }

    public BigDecimal getFBalance() {
        return fBalance;
    }

    public void setFBalance(BigDecimal fBalance) {
        this.fBalance = fBalance;
    }

    public String getFCedula() {
        return fCedula;
    }

    public void setFCedula(String fCedula) {
        this.fCedula = fCedula;
    }

    public Date getFFecha() {
        return fFecha;
    }

    public void setFFecha(Date fFecha) {
        this.fFecha = fFecha;
    }

    public BigDecimal getFLimiteCredito() {
        return fLimiteCredito;
    }

    public void setFLimiteCredito(BigDecimal fLimiteCredito) {
        this.fLimiteCredito = fLimiteCredito;
    }

    public Boolean getFFacturarcredito() {
        return fFacturarcredito;
    }

    public void setFFacturarcredito(Boolean fFacturarcredito) {
        this.fFacturarcredito = fFacturarcredito;
    }

    public BigDecimal getFDiasCredito() {
        return fDiasCredito;
    }

    public void setFDiasCredito(BigDecimal fDiasCredito) {
        this.fDiasCredito = fDiasCredito;
    }

    public String getFCelular() {
        return fCelular;
    }

    public void setFCelular(String fCelular) {
        this.fCelular = fCelular;
    }

    public String getFDireccion1() {
        return fDireccion1;
    }

    public void setFDireccion1(String fDireccion1) {
        this.fDireccion1 = fDireccion1;
    }

    public String getFDireccion2() {
        return fDireccion2;
    }

    public void setFDireccion2(String fDireccion2) {
        this.fDireccion2 = fDireccion2;
    }

    public String getFProvincia() {
        return fProvincia;
    }

    public void setFProvincia(String fProvincia) {
        this.fProvincia = fProvincia;
    }

    public String getFZipcode() {
        return fZipcode;
    }

    public void setFZipcode(String fZipcode) {
        this.fZipcode = fZipcode;
    }

    public String getFDireccionEnvio() {
        return fDireccionEnvio;
    }

    public void setFDireccionEnvio(String fDireccionEnvio) {
        this.fDireccionEnvio = fDireccionEnvio;
    }

    public Date getFFechaYear() {
        return fFechaYear;
    }

    public void setFFechaYear(Date fFechaYear) {
        this.fFechaYear = fFechaYear;
    }

    public String getFEmpresa() {
        return fEmpresa;
    }

    public void setFEmpresa(String fEmpresa) {
        this.fEmpresa = fEmpresa;
    }

    public String getFMensaje() {
        return fMensaje;
    }

    public void setFMensaje(String fMensaje) {
        this.fMensaje = fMensaje;
    }

    public Integer getFIdzona() {
        return fIdzona;
    }

    public void setFIdzona(Integer fIdzona) {
        this.fIdzona = fIdzona;
    }

    public Integer getFTipoCliente() {
        return fTipoCliente;
    }

    public void setFTipoCliente(Integer fTipoCliente) {
        this.fTipoCliente = fTipoCliente;
    }

    public String getFFormaEnvio() {
        return fFormaEnvio;
    }

    public void setFFormaEnvio(String fFormaEnvio) {
        this.fFormaEnvio = fFormaEnvio;
    }

    public Boolean getFExentoImpuestos() {
        return fExentoImpuestos;
    }

    public void setFExentoImpuestos(Boolean fExentoImpuestos) {
        this.fExentoImpuestos = fExentoImpuestos;
    }

    public Integer getFTipoMoneda() {
        return fTipoMoneda;
    }

    public void setFTipoMoneda(Integer fTipoMoneda) {
        this.fTipoMoneda = fTipoMoneda;
    }

    public String getFDescripcion() {
        return fDescripcion;
    }

    public void setFDescripcion(String fDescripcion) {
        this.fDescripcion = fDescripcion;
    }

    public String getFContacto() {
        return fContacto;
    }

    public void setFContacto(String fContacto) {
        this.fContacto = fContacto;
    }

    public String getFEmail() {
        return fEmail;
    }

    public void setFEmail(String fEmail) {
        this.fEmail = fEmail;
    }

    public Integer getFNcfDefecto() {
        return fNcfDefecto;
    }

    public void setFNcfDefecto(Integer fNcfDefecto) {
        this.fNcfDefecto = fNcfDefecto;
    }

    public BigDecimal getFPorcientoDescuento() {
        return fPorcientoDescuento;
    }

    public void setFPorcientoDescuento(BigDecimal fPorcientoDescuento) {
        this.fPorcientoDescuento = fPorcientoDescuento;
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
        if (!(object instanceof TClientes)) {
            return false;
        }
        TClientes other = (TClientes) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.TClientes[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
