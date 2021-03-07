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
@Table(name = "t_device")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TDevice.findAll", query = "SELECT t FROM TDevice t"),
    @NamedQuery(name = "TDevice.findByFIdrecord", query = "SELECT t FROM TDevice t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TDevice.findByFIdempresa", query = "SELECT t FROM TDevice t WHERE t.fIdempresa = :fIdempresa"),
    @NamedQuery(name = "TDevice.findByFIdusuario", query = "SELECT t FROM TDevice t WHERE t.fIdusuario = :fIdusuario"),
    @NamedQuery(name = "TDevice.findByFTipo", query = "SELECT t FROM TDevice t WHERE t.fTipo = :fTipo"),
    @NamedQuery(name = "TDevice.findByFIdindentificacion", query = "SELECT t FROM TDevice t WHERE t.fIdindentificacion = :fIdindentificacion"),
    @NamedQuery(name = "TDevice.findByFMarca", query = "SELECT t FROM TDevice t WHERE t.fMarca = :fMarca"),
    @NamedQuery(name = "TDevice.findByFModelo", query = "SELECT t FROM TDevice t WHERE t.fModelo = :fModelo"),
    @NamedQuery(name = "TDevice.findByFDescripcion", query = "SELECT t FROM TDevice t WHERE t.fDescripcion = :fDescripcion"),
    @NamedQuery(name = "TDevice.findByFComentario", query = "SELECT t FROM TDevice t WHERE t.fComentario = :fComentario")})
public class TDevice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_idempresa")
    private Integer fIdempresa;
    @Column(name = "f_idusuario")
    private Integer fIdusuario;
    @Column(name = "f_tipo")
    private Integer fTipo;
    @Column(name = "f_idindentificacion")
    private String fIdindentificacion;
    @Column(name = "f_marca")
    private String fMarca;
    @Column(name = "f_modelo")
    private String fModelo;
    @Column(name = "f_descripcion")
    private String fDescripcion;
    @Column(name = "f_comentario")
    private String fComentario;

    public TDevice() {
    }

    public TDevice(Integer fIdrecord) {
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

    public Integer getFIdusuario() {
        return fIdusuario;
    }

    public void setFIdusuario(Integer fIdusuario) {
        this.fIdusuario = fIdusuario;
    }

    public Integer getFTipo() {
        return fTipo;
    }

    public void setFTipo(Integer fTipo) {
        this.fTipo = fTipo;
    }

    public String getFIdindentificacion() {
        return fIdindentificacion;
    }

    public void setFIdindentificacion(String fIdindentificacion) {
        this.fIdindentificacion = fIdindentificacion;
    }

    public String getFMarca() {
        return fMarca;
    }

    public void setFMarca(String fMarca) {
        this.fMarca = fMarca;
    }

    public String getFModelo() {
        return fModelo;
    }

    public void setFModelo(String fModelo) {
        this.fModelo = fModelo;
    }

    public String getFDescripcion() {
        return fDescripcion;
    }

    public void setFDescripcion(String fDescripcion) {
        this.fDescripcion = fDescripcion;
    }

    public String getFComentario() {
        return fComentario;
    }

    public void setFComentario(String fComentario) {
        this.fComentario = fComentario;
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
        if (!(object instanceof TDevice)) {
            return false;
        }
        TDevice other = (TDevice) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TDevice[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
