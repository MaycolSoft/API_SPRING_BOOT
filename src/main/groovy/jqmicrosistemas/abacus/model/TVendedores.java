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
@Table(name = "t_vendedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TVendedores.findAll", query = "SELECT t FROM TVendedores t"),
    @NamedQuery(name = "TVendedores.findByFIdrecord", query = "SELECT t FROM TVendedores t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TVendedores.findByFNombre", query = "SELECT t FROM TVendedores t WHERE t.fNombre = :fNombre"),
    @NamedQuery(name = "TVendedores.findByFApellido", query = "SELECT t FROM TVendedores t WHERE t.fApellido = :fApellido"),
    @NamedQuery(name = "TVendedores.findByFTelefono1", query = "SELECT t FROM TVendedores t WHERE t.fTelefono1 = :fTelefono1"),
    @NamedQuery(name = "TVendedores.findByFTelefono2", query = "SELECT t FROM TVendedores t WHERE t.fTelefono2 = :fTelefono2"),
    @NamedQuery(name = "TVendedores.findByFDireccion", query = "SELECT t FROM TVendedores t WHERE t.fDireccion = :fDireccion"),
    @NamedQuery(name = "TVendedores.findByFIddepto", query = "SELECT t FROM TVendedores t WHERE t.fIddepto = :fIddepto"),
    @NamedQuery(name = "TVendedores.findByFActivo", query = "SELECT t FROM TVendedores t WHERE t.fActivo = :fActivo"),
    @NamedQuery(name = "TVendedores.findByFIdempresa", query = "SELECT t FROM TVendedores t WHERE t.fIdempresa = :fIdempresa"),
    @NamedQuery(name = "TVendedores.findByFR11", query = "SELECT t FROM TVendedores t WHERE t.fR11 = :fR11"),
    @NamedQuery(name = "TVendedores.findByFR12", query = "SELECT t FROM TVendedores t WHERE t.fR12 = :fR12"),
    @NamedQuery(name = "TVendedores.findByFR1por", query = "SELECT t FROM TVendedores t WHERE t.fR1por = :fR1por"),
    @NamedQuery(name = "TVendedores.findByFR21", query = "SELECT t FROM TVendedores t WHERE t.fR21 = :fR21"),
    @NamedQuery(name = "TVendedores.findByFR22", query = "SELECT t FROM TVendedores t WHERE t.fR22 = :fR22"),
    @NamedQuery(name = "TVendedores.findByFR2por", query = "SELECT t FROM TVendedores t WHERE t.fR2por = :fR2por"),
    @NamedQuery(name = "TVendedores.findByFR31", query = "SELECT t FROM TVendedores t WHERE t.fR31 = :fR31"),
    @NamedQuery(name = "TVendedores.findByFR32", query = "SELECT t FROM TVendedores t WHERE t.fR32 = :fR32"),
    @NamedQuery(name = "TVendedores.findByFR3por", query = "SELECT t FROM TVendedores t WHERE t.fR3por = :fR3por"),
    @NamedQuery(name = "TVendedores.findByFR41", query = "SELECT t FROM TVendedores t WHERE t.fR41 = :fR41"),
    @NamedQuery(name = "TVendedores.findByFR42", query = "SELECT t FROM TVendedores t WHERE t.fR42 = :fR42"),
    @NamedQuery(name = "TVendedores.findByFR4por", query = "SELECT t FROM TVendedores t WHERE t.fR4por = :fR4por"),
    @NamedQuery(name = "TVendedores.findByFEmail", query = "SELECT t FROM TVendedores t WHERE t.fEmail = :fEmail"),
    @NamedQuery(name = "TVendedores.findByFIdusuario", query = "SELECT t FROM TVendedores t WHERE t.fIdusuario = :fIdusuario"),
    @NamedQuery(name = "TVendedores.findByFMontoPago", query = "SELECT t FROM TVendedores t WHERE t.fMontoPago = :fMontoPago")})
public class TVendedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_nombre")
    private String fNombre;
    @Column(name = "f_apellido")
    private String fApellido;
    @Column(name = "f_telefono1")
    private String fTelefono1;
    @Column(name = "f_telefono2")
    private String fTelefono2;
    @Column(name = "f_direccion")
    private String fDireccion;
    @Column(name = "f_iddepto")
    private Integer fIddepto;
    @Column(name = "f_activo")
    private Boolean fActivo;
    @Basic(optional = false)
    @Column(name = "f_idempresa")
    private int fIdempresa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "f_r11")
    private BigDecimal fR11;
    @Column(name = "f_r12")
    private BigDecimal fR12;
    @Column(name = "f_r1por")
    private BigDecimal fR1por;
    @Column(name = "f_r21")
    private BigDecimal fR21;
    @Column(name = "f_r22")
    private BigDecimal fR22;
    @Column(name = "f_r2por")
    private BigDecimal fR2por;
    @Column(name = "f_r31")
    private BigDecimal fR31;
    @Column(name = "f_r32")
    private BigDecimal fR32;
    @Column(name = "f_r3por")
    private BigDecimal fR3por;
    @Column(name = "f_r41")
    private BigDecimal fR41;
    @Column(name = "f_r42")
    private BigDecimal fR42;
    @Column(name = "f_r4por")
    private BigDecimal fR4por;
    @Column(name = "f_email")
    private String fEmail;
    @Column(name = "f_idusuario")
    private Integer fIdusuario;
    @Column(name = "f_monto_pago")
    private BigDecimal fMontoPago;

    public TVendedores() {
    }

    public TVendedores(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public TVendedores(Integer fIdrecord, int fIdempresa) {
        this.fIdrecord = fIdrecord;
        this.fIdempresa = fIdempresa;
    }

    public Integer getFIdrecord() {
        return fIdrecord;
    }

    public void setFIdrecord(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
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

    public String getFTelefono1() {
        return fTelefono1;
    }

    public void setFTelefono1(String fTelefono1) {
        this.fTelefono1 = fTelefono1;
    }

    public String getFTelefono2() {
        return fTelefono2;
    }

    public void setFTelefono2(String fTelefono2) {
        this.fTelefono2 = fTelefono2;
    }

    public String getFDireccion() {
        return fDireccion;
    }

    public void setFDireccion(String fDireccion) {
        this.fDireccion = fDireccion;
    }

    public Integer getFIddepto() {
        return fIddepto;
    }

    public void setFIddepto(Integer fIddepto) {
        this.fIddepto = fIddepto;
    }

    public Boolean getFActivo() {
        return fActivo;
    }

    public void setFActivo(Boolean fActivo) {
        this.fActivo = fActivo;
    }

    public int getFIdempresa() {
        return fIdempresa;
    }

    public void setFIdempresa(int fIdempresa) {
        this.fIdempresa = fIdempresa;
    }

    public BigDecimal getFR11() {
        return fR11;
    }

    public void setFR11(BigDecimal fR11) {
        this.fR11 = fR11;
    }

    public BigDecimal getFR12() {
        return fR12;
    }

    public void setFR12(BigDecimal fR12) {
        this.fR12 = fR12;
    }

    public BigDecimal getFR1por() {
        return fR1por;
    }

    public void setFR1por(BigDecimal fR1por) {
        this.fR1por = fR1por;
    }

    public BigDecimal getFR21() {
        return fR21;
    }

    public void setFR21(BigDecimal fR21) {
        this.fR21 = fR21;
    }

    public BigDecimal getFR22() {
        return fR22;
    }

    public void setFR22(BigDecimal fR22) {
        this.fR22 = fR22;
    }

    public BigDecimal getFR2por() {
        return fR2por;
    }

    public void setFR2por(BigDecimal fR2por) {
        this.fR2por = fR2por;
    }

    public BigDecimal getFR31() {
        return fR31;
    }

    public void setFR31(BigDecimal fR31) {
        this.fR31 = fR31;
    }

    public BigDecimal getFR32() {
        return fR32;
    }

    public void setFR32(BigDecimal fR32) {
        this.fR32 = fR32;
    }

    public BigDecimal getFR3por() {
        return fR3por;
    }

    public void setFR3por(BigDecimal fR3por) {
        this.fR3por = fR3por;
    }

    public BigDecimal getFR41() {
        return fR41;
    }

    public void setFR41(BigDecimal fR41) {
        this.fR41 = fR41;
    }

    public BigDecimal getFR42() {
        return fR42;
    }

    public void setFR42(BigDecimal fR42) {
        this.fR42 = fR42;
    }

    public BigDecimal getFR4por() {
        return fR4por;
    }

    public void setFR4por(BigDecimal fR4por) {
        this.fR4por = fR4por;
    }

    public String getFEmail() {
        return fEmail;
    }

    public void setFEmail(String fEmail) {
        this.fEmail = fEmail;
    }

    public Integer getFIdusuario() {
        return fIdusuario;
    }

    public void setFIdusuario(Integer fIdusuario) {
        this.fIdusuario = fIdusuario;
    }

    public BigDecimal getFMontoPago() {
        return fMontoPago;
    }

    public void setFMontoPago(BigDecimal fMontoPago) {
        this.fMontoPago = fMontoPago;
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
        if (!(object instanceof TVendedores)) {
            return false;
        }
        TVendedores other = (TVendedores) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TVendedores[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
