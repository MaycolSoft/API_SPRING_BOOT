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
@Table(name = "t_permisos_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPermisosUsuario.findAll", query = "SELECT t FROM TPermisosUsuario t"),
    @NamedQuery(name = "TPermisosUsuario.findByFUsuario", query = "SELECT t FROM TPermisosUsuario t WHERE t.fUsuario = :fUsuario"),
    @NamedQuery(name = "TPermisosUsuario.findByFFila", query = "SELECT t FROM TPermisosUsuario t WHERE t.fFila = :fFila"),
    @NamedQuery(name = "TPermisosUsuario.findByFColumna", query = "SELECT t FROM TPermisosUsuario t WHERE t.fColumna = :fColumna"),
    @NamedQuery(name = "TPermisosUsuario.findByFSubmenu", query = "SELECT t FROM TPermisosUsuario t WHERE t.fSubmenu = :fSubmenu")})
public class TPermisosUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "f_usuario")
    private Integer fUsuario;
    @Column(name = "f_fila")
    private Integer fFila;
    @Column(name = "f_columna")
    private Integer fColumna;
    @Column(name = "f_submenu")
    private Integer fSubmenu;

    public TPermisosUsuario() {
    }

    public TPermisosUsuario(Integer fUsuario) {
        this.fUsuario = fUsuario;
    }

    public Integer getFUsuario() {
        return fUsuario;
    }

    public void setFUsuario(Integer fUsuario) {
        this.fUsuario = fUsuario;
    }

    public Integer getFFila() {
        return fFila;
    }

    public void setFFila(Integer fFila) {
        this.fFila = fFila;
    }

    public Integer getFColumna() {
        return fColumna;
    }

    public void setFColumna(Integer fColumna) {
        this.fColumna = fColumna;
    }

    public Integer getFSubmenu() {
        return fSubmenu;
    }

    public void setFSubmenu(Integer fSubmenu) {
        this.fSubmenu = fSubmenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fUsuario != null ? fUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPermisosUsuario)) {
            return false;
        }
        TPermisosUsuario other = (TPermisosUsuario) object;
        if ((this.fUsuario == null && other.fUsuario != null) || (this.fUsuario != null && !this.fUsuario.equals(other.fUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TPermisosUsuario[ fUsuario=" + fUsuario + " ]";
    }
    
}
