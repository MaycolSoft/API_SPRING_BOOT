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
@Table(name = "t_direccion_envio_clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TDireccionEnvioClientes.findAll", query = "SELECT t FROM TDireccionEnvioClientes t"),
    @NamedQuery(name = "TDireccionEnvioClientes.findByFIdrecord", query = "SELECT t FROM TDireccionEnvioClientes t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TDireccionEnvioClientes.findByFIdcliente", query = "SELECT t FROM TDireccionEnvioClientes t WHERE t.fIdcliente = :fIdcliente"),
    @NamedQuery(name = "TDireccionEnvioClientes.findByFDireccion1", query = "SELECT t FROM TDireccionEnvioClientes t WHERE t.fDireccion1 = :fDireccion1"),
    @NamedQuery(name = "TDireccionEnvioClientes.findByFDireccion2", query = "SELECT t FROM TDireccionEnvioClientes t WHERE t.fDireccion2 = :fDireccion2"),
    @NamedQuery(name = "TDireccionEnvioClientes.findByFProvincia", query = "SELECT t FROM TDireccionEnvioClientes t WHERE t.fProvincia = :fProvincia"),
    @NamedQuery(name = "TDireccionEnvioClientes.findByFMunicipio", query = "SELECT t FROM TDireccionEnvioClientes t WHERE t.fMunicipio = :fMunicipio"),
    @NamedQuery(name = "TDireccionEnvioClientes.findByFSector", query = "SELECT t FROM TDireccionEnvioClientes t WHERE t.fSector = :fSector"),
    @NamedQuery(name = "TDireccionEnvioClientes.findByFZip", query = "SELECT t FROM TDireccionEnvioClientes t WHERE t.fZip = :fZip"),
    @NamedQuery(name = "TDireccionEnvioClientes.findByFComentario", query = "SELECT t FROM TDireccionEnvioClientes t WHERE t.fComentario = :fComentario"),
    @NamedQuery(name = "TDireccionEnvioClientes.findByFDefecto", query = "SELECT t FROM TDireccionEnvioClientes t WHERE t.fDefecto = :fDefecto"),
    @NamedQuery(name = "TDireccionEnvioClientes.findByFIdempresa", query = "SELECT t FROM TDireccionEnvioClientes t WHERE t.fIdempresa = :fIdempresa")})
public class TDireccionEnvioClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_idcliente")
    private Integer fIdcliente;
    @Column(name = "f_direccion1")
    private String fDireccion1;
    @Column(name = "f_direccion2")
    private String fDireccion2;
    @Column(name = "f_provincia")
    private String fProvincia;
    @Column(name = "f_municipio")
    private String fMunicipio;
    @Column(name = "f_sector")
    private String fSector;
    @Column(name = "f_zip")
    private String fZip;
    @Column(name = "f_comentario")
    private String fComentario;
    @Column(name = "f_defecto")
    private Boolean fDefecto;
    @Column(name = "f_idempresa")
    private Integer fIdempresa;

    public TDireccionEnvioClientes() {
    }

    public TDireccionEnvioClientes(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public Integer getFIdrecord() {
        return fIdrecord;
    }

    public void setFIdrecord(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public Integer getFIdcliente() {
        return fIdcliente;
    }

    public void setFIdcliente(Integer fIdcliente) {
        this.fIdcliente = fIdcliente;
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

    public String getFMunicipio() {
        return fMunicipio;
    }

    public void setFMunicipio(String fMunicipio) {
        this.fMunicipio = fMunicipio;
    }

    public String getFSector() {
        return fSector;
    }

    public void setFSector(String fSector) {
        this.fSector = fSector;
    }

    public String getFZip() {
        return fZip;
    }

    public void setFZip(String fZip) {
        this.fZip = fZip;
    }

    public String getFComentario() {
        return fComentario;
    }

    public void setFComentario(String fComentario) {
        this.fComentario = fComentario;
    }

    public Boolean getFDefecto() {
        return fDefecto;
    }

    public void setFDefecto(Boolean fDefecto) {
        this.fDefecto = fDefecto;
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
        if (!(object instanceof TDireccionEnvioClientes)) {
            return false;
        }
        TDireccionEnvioClientes other = (TDireccionEnvioClientes) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TDireccionEnvioClientes[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
