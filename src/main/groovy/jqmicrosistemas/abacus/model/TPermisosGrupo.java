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
@Table(name = "t_permisos_grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPermisosGrupo.findAll", query = "SELECT t FROM TPermisosGrupo t"),
    @NamedQuery(name = "TPermisosGrupo.findByFIdrecord", query = "SELECT t FROM TPermisosGrupo t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TPermisosGrupo.findByFIdempresa", query = "SELECT t FROM TPermisosGrupo t WHERE t.fIdempresa = :fIdempresa"),
    @NamedQuery(name = "TPermisosGrupo.findByFFila", query = "SELECT t FROM TPermisosGrupo t WHERE t.fFila = :fFila"),
    @NamedQuery(name = "TPermisosGrupo.findByFColumna", query = "SELECT t FROM TPermisosGrupo t WHERE t.fColumna = :fColumna"),
    @NamedQuery(name = "TPermisosGrupo.findByFUsuario", query = "SELECT t FROM TPermisosGrupo t WHERE t.fUsuario = :fUsuario"),
    @NamedQuery(name = "TPermisosGrupo.findByFSubmenu", query = "SELECT t FROM TPermisosGrupo t WHERE t.fSubmenu = :fSubmenu")})
public class TPermisosGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_idempresa")
    private Integer fIdempresa;
    @Column(name = "f_fila")
    private Integer fFila;
    @Column(name = "f_columna")
    private Integer fColumna;
    @Column(name = "f_usuario")
    private Integer fUsuario;
    @Column(name = "f_submenu")
    private Integer fSubmenu;

    public TPermisosGrupo() {
    }

    public TPermisosGrupo(Integer fIdrecord) {
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

    public Integer getFUsuario() {
        return fUsuario;
    }

    public void setFUsuario(Integer fUsuario) {
        this.fUsuario = fUsuario;
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
        hash += (fIdrecord != null ? fIdrecord.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPermisosGrupo)) {
            return false;
        }
        TPermisosGrupo other = (TPermisosGrupo) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TPermisosGrupo[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
