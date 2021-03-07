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
@Table(name = "t_usuarios")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "TUsuarios.findAll", query = "SELECT t FROM TUsuarios t"),

        @NamedQuery(name = "TUsuarios.findByFIdrecord", query = "SELECT t FROM TUsuarios t WHERE t.fIdrecord = ?1"),
        @NamedQuery(name = "TUsuarios.findByFIdempresa", query = "SELECT t FROM TUsuarios t WHERE t.fIdempresa = ?1"),
        @NamedQuery(name = "TUsuarios.findByFUsername", query = "SELECT t FROM TUsuarios t WHERE t.fUsername = ?1"),
        @NamedQuery(name = "TUsuarios.findByFPassword", query = "SELECT t FROM TUsuarios t WHERE t.fPassword = ?1"),
        @NamedQuery(name = "TUsuarios.findByFActivo", query = "SELECT t FROM TUsuarios t WHERE t.fActivo = ?1"),
        @NamedQuery(name = "TUsuarios.findByFIdtipo", query = "SELECT t FROM TUsuarios t WHERE t.fIdtipo = ?1"),
        @NamedQuery(name = "TUsuarios.findByFIdidioma", query = "SELECT t FROM TUsuarios t WHERE t.fIdidioma = ?1"),
        @NamedQuery(name = "TUsuarios.findByFCamarero", query = "SELECT t FROM TUsuarios t WHERE t.fCamarero = ?1"),
        @NamedQuery(name = "TUsuarios.findByFNombre", query = "SELECT t FROM TUsuarios t WHERE t.fNombre = ?1"),
        @NamedQuery(name = "TUsuarios.findByFApellido", query = "SELECT t FROM TUsuarios t WHERE t.fApellido = ?1"),
        @NamedQuery(name = "TUsuarios.findByFEmail", query = "SELECT t FROM TUsuarios t WHERE t.fEmail = ?1"),
        @NamedQuery(name = "TUsuarios.findByFTelefono", query = "SELECT t FROM TUsuarios t WHERE t.fTelefono = ?1"),
        @NamedQuery(name = "TUsuarios.findByFIdsucursal", query = "SELECT t FROM TUsuarios t WHERE t.fIdsucursal = ?1"),
        @NamedQuery(name = "TUsuarios.findByFSuperUser", query = "SELECT t FROM TUsuarios t WHERE t.fSuperUser = ?1"),
        @NamedQuery(name = "TUsuarios.findByFWebUser", query = "SELECT t FROM TUsuarios t WHERE t.fWebUser = ?1"),
        @NamedQuery(name = "TUsuarios.findByFCajero", query = "SELECT t FROM TUsuarios t WHERE t.fCajero = ?1"),
        @NamedQuery(name = "TUsuarios.findByFDesactivaSoloCaja", query = "SELECT t FROM TUsuarios t WHERE t.fDesactivaSoloCaja = ?1")
})
public class TUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_idempresa")
    private Integer fIdempresa;
    @Column(name = "f_username")
    private String fUsername;
    @Column(name = "f_password")
    private String fPassword;
    @Column(name = "f_activo")
    private Boolean fActivo;
    @Column(name = "f_idtipo")
    private Integer fIdtipo;
    @Column(name = "f_ididioma")
    private Integer fIdidioma;
    @Column(name = "f_camarero")
    private Boolean fCamarero;
    @Column(name = "f_nombre")
    private String fNombre;
    @Column(name = "f_apellido")
    private String fApellido;
    @Column(name = "f_email")
    private String fEmail;
    @Column(name = "f_telefono")
    private String fTelefono;
    @Column(name = "f_idsucursal")
    private Integer fIdsucursal;
    @Column(name = "f_super_user")
    private Boolean fSuperUser;
    @Column(name = "f_web_user")
    private Boolean fWebUser;
    @Column(name = "f_cajero")
    private Boolean fCajero;
    @Column(name = "f_desactiva_solo_caja")
    private Boolean fDesactivaSoloCaja;

    public TUsuarios() {
    }

    public TUsuarios(Integer fIdrecord) {
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

    public String getFUsername() {
        return fUsername;
    }

    public void setFUsername(String fUsername) {
        this.fUsername = fUsername;
    }

    public String getFPassword() {
        return fPassword;
    }

    public void setFPassword(String fPassword) {
        this.fPassword = fPassword;
    }

    public Boolean getFActivo() {
        return fActivo;
    }

    public void setFActivo(Boolean fActivo) {
        this.fActivo = fActivo;
    }

    public Integer getFIdtipo() {
        return fIdtipo;
    }

    public void setFIdtipo(Integer fIdtipo) {
        this.fIdtipo = fIdtipo;
    }

    public Integer getFIdidioma() {
        return fIdidioma;
    }

    public void setFIdidioma(Integer fIdidioma) {
        this.fIdidioma = fIdidioma;
    }

    public Boolean getFCamarero() {
        return fCamarero;
    }

    public void setFCamarero(Boolean fCamarero) {
        this.fCamarero = fCamarero;
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

    public String getFEmail() {
        return fEmail;
    }

    public void setFEmail(String fEmail) {
        this.fEmail = fEmail;
    }

    public String getFTelefono() {
        return fTelefono;
    }

    public void setFTelefono(String fTelefono) {
        this.fTelefono = fTelefono;
    }

    public Integer getFIdsucursal() {
        return fIdsucursal;
    }

    public void setFIdsucursal(Integer fIdsucursal) {
        this.fIdsucursal = fIdsucursal;
    }

    public Boolean getFSuperUser() {
        return fSuperUser;
    }

    public void setFSuperUser(Boolean fSuperUser) {
        this.fSuperUser = fSuperUser;
    }

    public Boolean getFWebUser() {
        return fWebUser;
    }

    public void setFWebUser(Boolean fWebUser) {
        this.fWebUser = fWebUser;
    }

    public Boolean getFCajero() {
        return fCajero;
    }

    public void setFCajero(Boolean fCajero) {
        this.fCajero = fCajero;
    }

    public Boolean getFDesactivaSoloCaja() {
        return fDesactivaSoloCaja;
    }

    public void setFDesactivaSoloCaja(Boolean fDesactivaSoloCaja) {
        this.fDesactivaSoloCaja = fDesactivaSoloCaja;
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
        if (!(object instanceof TUsuarios)) {
            return false;
        }
        TUsuarios other = (TUsuarios) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TUsuarios[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
