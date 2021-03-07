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
@Table(name = "t_sucursal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSucursal.findAll", query = "SELECT t FROM TSucursal t"),
    @NamedQuery(name = "TSucursal.findByFIdrecord", query = "SELECT t FROM TSucursal t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TSucursal.findByFIdempresa", query = "SELECT t FROM TSucursal t WHERE t.fIdempresa = ?1"),

        @NamedQuery(name = "TSucursal.findByFIdempresaNombreAndIdSucursal", query = "SELECT t.fIdsucursal, t.fNombresucursal FROM TSucursal t WHERE t.fIdempresa = ?1"),

    @NamedQuery(name = "TSucursal.findByFIdsucursal", query = "SELECT t FROM TSucursal t WHERE t.fIdsucursal = :fIdsucursal"),
    @NamedQuery(name = "TSucursal.findByFNombresucursal", query = "SELECT t FROM TSucursal t WHERE t.fNombresucursal = :fNombresucursal"),
    @NamedQuery(name = "TSucursal.findByFTelefono", query = "SELECT t FROM TSucursal t WHERE t.fTelefono = :fTelefono"),
    @NamedQuery(name = "TSucursal.findByFDireccion", query = "SELECT t FROM TSucursal t WHERE t.fDireccion = :fDireccion"),
    @NamedQuery(name = "TSucursal.findByFLabelSucursal", query = "SELECT t FROM TSucursal t WHERE t.fLabelSucursal = :fLabelSucursal"),
    @NamedQuery(name = "TSucursal.findByFOtroImpuesto", query = "SELECT t FROM TSucursal t WHERE t.fOtroImpuesto = :fOtroImpuesto"),
    @NamedQuery(name = "TSucursal.findByFImpuestoIncluido", query = "SELECT t FROM TSucursal t WHERE t.fImpuestoIncluido = :fImpuestoIncluido"),
    @NamedQuery(name = "TSucursal.findByFTipoFactura", query = "SELECT t FROM TSucursal t WHERE t.fTipoFactura = :fTipoFactura"),
    @NamedQuery(name = "TSucursal.findByFSoloCaja", query = "SELECT t FROM TSucursal t WHERE t.fSoloCaja = :fSoloCaja"),
    @NamedQuery(name = "TSucursal.findByFQtyTerminales", query = "SELECT t FROM TSucursal t WHERE t.fQtyTerminales = :fQtyTerminales"),
    @NamedQuery(name = "TSucursal.findByFActivo", query = "SELECT t FROM TSucursal t WHERE t.fActivo = :fActivo"),
    @NamedQuery(name = "TSucursal.findByFUsaNcf", query = "SELECT t FROM TSucursal t WHERE t.fUsaNcf = :fUsaNcf"),
    @NamedQuery(name = "TSucursal.findByFMensajeFacturaContado", query = "SELECT t FROM TSucursal t WHERE t.fMensajeFacturaContado = :fMensajeFacturaContado"),
    @NamedQuery(name = "TSucursal.findByFMensajeFacturaCredito", query = "SELECT t FROM TSucursal t WHERE t.fMensajeFacturaCredito = :fMensajeFacturaCredito"),
    @NamedQuery(name = "TSucursal.findByFPapelRecibo", query = "SELECT t FROM TSucursal t WHERE t.fPapelRecibo = :fPapelRecibo"),
    @NamedQuery(name = "TSucursal.findByFPapelFactCont", query = "SELECT t FROM TSucursal t WHERE t.fPapelFactCont = :fPapelFactCont"),
    @NamedQuery(name = "TSucursal.findByFPapelFactCre", query = "SELECT t FROM TSucursal t WHERE t.fPapelFactCre = :fPapelFactCre"),
    @NamedQuery(name = "TSucursal.findByFNcfDefecto", query = "SELECT t FROM TSucursal t WHERE t.fNcfDefecto = :fNcfDefecto"),
    @NamedQuery(name = "TSucursal.findByFTipoPapelTaller", query = "SELECT t FROM TSucursal t WHERE t.fTipoPapelTaller = :fTipoPapelTaller"),
    @NamedQuery(name = "TSucursal.findByFImprimeObservacion", query = "SELECT t FROM TSucursal t WHERE t.fImprimeObservacion = :fImprimeObservacion"),
    @NamedQuery(name = "TSucursal.findByFTipoPapelReciboCxc", query = "SELECT t FROM TSucursal t WHERE t.fTipoPapelReciboCxc = :fTipoPapelReciboCxc"),
    @NamedQuery(name = "TSucursal.findByFPrinterEtiquetasDeEnvio", query = "SELECT t FROM TSucursal t WHERE t.fPrinterEtiquetasDeEnvio = :fPrinterEtiquetasDeEnvio"),
    @NamedQuery(name = "TSucursal.findByFNcfNotaDebitoDefecto", query = "SELECT t FROM TSucursal t WHERE t.fNcfNotaDebitoDefecto = :fNcfNotaDebitoDefecto"),
    @NamedQuery(name = "TSucursal.findByFNcfNotaCreditoDefecto", query = "SELECT t FROM TSucursal t WHERE t.fNcfNotaCreditoDefecto = :fNcfNotaCreditoDefecto"),
    @NamedQuery(name = "TSucursal.findByFPrecioEditable", query = "SELECT t FROM TSucursal t WHERE t.fPrecioEditable = :fPrecioEditable"),
    @NamedQuery(name = "TSucursal.findByFConceptoEntrada", query = "SELECT t FROM TSucursal t WHERE t.fConceptoEntrada = :fConceptoEntrada"),
    @NamedQuery(name = "TSucursal.findByFConceptoSalida", query = "SELECT t FROM TSucursal t WHERE t.fConceptoSalida = :fConceptoSalida")})
public class TSucursal implements Serializable {

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
    @Column(name = "f_nombresucursal")
    private String fNombresucursal;
    @Column(name = "f_telefono")
    private String fTelefono;
    @Column(name = "f_direccion")
    private String fDireccion;
    @Column(name = "f_label_sucursal")
    private String fLabelSucursal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "f_otro_impuesto")
    private BigDecimal fOtroImpuesto;
    @Column(name = "f_impuesto_incluido")
    private Boolean fImpuestoIncluido;
    @Column(name = "f_tipo_factura")
    private Integer fTipoFactura;
    @Column(name = "f_solo_caja")
    private Boolean fSoloCaja;
    @Basic(optional = false)
    @Column(name = "f_qty_terminales")
    private int fQtyTerminales;
    @Column(name = "f_activo")
    private Boolean fActivo;
    @Column(name = "f_usa_ncf")
    private Boolean fUsaNcf;
    @Column(name = "f_mensaje_factura_contado")
    private String fMensajeFacturaContado;
    @Column(name = "f_mensaje_factura_credito")
    private String fMensajeFacturaCredito;
    @Column(name = "f_papel_recibo")
    private Integer fPapelRecibo;
    @Column(name = "f_papel_fact_cont")
    private Integer fPapelFactCont;
    @Column(name = "f_papel_fact_cre")
    private Integer fPapelFactCre;
    @Column(name = "f_ncf_defecto")
    private Integer fNcfDefecto;
    @Column(name = "f_tipo_papel_taller")
    private Integer fTipoPapelTaller;
    @Column(name = "f_imprime_observacion")
    private Boolean fImprimeObservacion;
    @Column(name = "f_tipo_papel_recibo_cxc")
    private Integer fTipoPapelReciboCxc;
    @Column(name = "f_printer_etiquetas_de_envio")
    private String fPrinterEtiquetasDeEnvio;
    @Column(name = "f_ncf_nota_debito_defecto")
    private Integer fNcfNotaDebitoDefecto;
    @Column(name = "f_ncf_nota_credito_defecto")
    private Integer fNcfNotaCreditoDefecto;
    @Column(name = "f_precio_editable")
    private Boolean fPrecioEditable;
    @Column(name = "f_concepto_entrada")
    private Integer fConceptoEntrada;
    @Column(name = "f_concepto_salida")
    private Integer fConceptoSalida;

    public TSucursal() {
    }

    public TSucursal(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public TSucursal(Integer fIdrecord, int fIdempresa, int fIdsucursal, int fQtyTerminales) {
        this.fIdrecord = fIdrecord;
        this.fIdempresa = fIdempresa;
        this.fIdsucursal = fIdsucursal;
        this.fQtyTerminales = fQtyTerminales;
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

    public String getFNombresucursal() {
        return fNombresucursal;
    }

    public void setFNombresucursal(String fNombresucursal) {
        this.fNombresucursal = fNombresucursal;
    }

    public String getFTelefono() {
        return fTelefono;
    }

    public void setFTelefono(String fTelefono) {
        this.fTelefono = fTelefono;
    }

    public String getFDireccion() {
        return fDireccion;
    }

    public void setFDireccion(String fDireccion) {
        this.fDireccion = fDireccion;
    }

    public String getFLabelSucursal() {
        return fLabelSucursal;
    }

    public void setFLabelSucursal(String fLabelSucursal) {
        this.fLabelSucursal = fLabelSucursal;
    }

    public BigDecimal getFOtroImpuesto() {
        return fOtroImpuesto;
    }

    public void setFOtroImpuesto(BigDecimal fOtroImpuesto) {
        this.fOtroImpuesto = fOtroImpuesto;
    }

    public Boolean getFImpuestoIncluido() {
        return fImpuestoIncluido;
    }

    public void setFImpuestoIncluido(Boolean fImpuestoIncluido) {
        this.fImpuestoIncluido = fImpuestoIncluido;
    }

    public Integer getFTipoFactura() {
        return fTipoFactura;
    }

    public void setFTipoFactura(Integer fTipoFactura) {
        this.fTipoFactura = fTipoFactura;
    }

    public Boolean getFSoloCaja() {
        return fSoloCaja;
    }

    public void setFSoloCaja(Boolean fSoloCaja) {
        this.fSoloCaja = fSoloCaja;
    }

    public int getFQtyTerminales() {
        return fQtyTerminales;
    }

    public void setFQtyTerminales(int fQtyTerminales) {
        this.fQtyTerminales = fQtyTerminales;
    }

    public Boolean getFActivo() {
        return fActivo;
    }

    public void setFActivo(Boolean fActivo) {
        this.fActivo = fActivo;
    }

    public Boolean getFUsaNcf() {
        return fUsaNcf;
    }

    public void setFUsaNcf(Boolean fUsaNcf) {
        this.fUsaNcf = fUsaNcf;
    }

    public String getFMensajeFacturaContado() {
        return fMensajeFacturaContado;
    }

    public void setFMensajeFacturaContado(String fMensajeFacturaContado) {
        this.fMensajeFacturaContado = fMensajeFacturaContado;
    }

    public String getFMensajeFacturaCredito() {
        return fMensajeFacturaCredito;
    }

    public void setFMensajeFacturaCredito(String fMensajeFacturaCredito) {
        this.fMensajeFacturaCredito = fMensajeFacturaCredito;
    }

    public Integer getFPapelRecibo() {
        return fPapelRecibo;
    }

    public void setFPapelRecibo(Integer fPapelRecibo) {
        this.fPapelRecibo = fPapelRecibo;
    }

    public Integer getFPapelFactCont() {
        return fPapelFactCont;
    }

    public void setFPapelFactCont(Integer fPapelFactCont) {
        this.fPapelFactCont = fPapelFactCont;
    }

    public Integer getFPapelFactCre() {
        return fPapelFactCre;
    }

    public void setFPapelFactCre(Integer fPapelFactCre) {
        this.fPapelFactCre = fPapelFactCre;
    }

    public Integer getFNcfDefecto() {
        return fNcfDefecto;
    }

    public void setFNcfDefecto(Integer fNcfDefecto) {
        this.fNcfDefecto = fNcfDefecto;
    }

    public Integer getFTipoPapelTaller() {
        return fTipoPapelTaller;
    }

    public void setFTipoPapelTaller(Integer fTipoPapelTaller) {
        this.fTipoPapelTaller = fTipoPapelTaller;
    }

    public Boolean getFImprimeObservacion() {
        return fImprimeObservacion;
    }

    public void setFImprimeObservacion(Boolean fImprimeObservacion) {
        this.fImprimeObservacion = fImprimeObservacion;
    }

    public Integer getFTipoPapelReciboCxc() {
        return fTipoPapelReciboCxc;
    }

    public void setFTipoPapelReciboCxc(Integer fTipoPapelReciboCxc) {
        this.fTipoPapelReciboCxc = fTipoPapelReciboCxc;
    }

    public String getFPrinterEtiquetasDeEnvio() {
        return fPrinterEtiquetasDeEnvio;
    }

    public void setFPrinterEtiquetasDeEnvio(String fPrinterEtiquetasDeEnvio) {
        this.fPrinterEtiquetasDeEnvio = fPrinterEtiquetasDeEnvio;
    }

    public Integer getFNcfNotaDebitoDefecto() {
        return fNcfNotaDebitoDefecto;
    }

    public void setFNcfNotaDebitoDefecto(Integer fNcfNotaDebitoDefecto) {
        this.fNcfNotaDebitoDefecto = fNcfNotaDebitoDefecto;
    }

    public Integer getFNcfNotaCreditoDefecto() {
        return fNcfNotaCreditoDefecto;
    }

    public void setFNcfNotaCreditoDefecto(Integer fNcfNotaCreditoDefecto) {
        this.fNcfNotaCreditoDefecto = fNcfNotaCreditoDefecto;
    }

    public Boolean getFPrecioEditable() {
        return fPrecioEditable;
    }

    public void setFPrecioEditable(Boolean fPrecioEditable) {
        this.fPrecioEditable = fPrecioEditable;
    }

    public Integer getFConceptoEntrada() {
        return fConceptoEntrada;
    }

    public void setFConceptoEntrada(Integer fConceptoEntrada) {
        this.fConceptoEntrada = fConceptoEntrada;
    }

    public Integer getFConceptoSalida() {
        return fConceptoSalida;
    }

    public void setFConceptoSalida(Integer fConceptoSalida) {
        this.fConceptoSalida = fConceptoSalida;
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
        if (!(object instanceof TSucursal)) {
            return false;
        }
        TSucursal other = (TSucursal) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TSucursal[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
