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
@Table(name = "t_secuencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSecuencias.findAll", query = "SELECT t FROM TSecuencias t"),
    @NamedQuery(name = "TSecuencias.findByFIdrecord", query = "SELECT t FROM TSecuencias t WHERE t.fIdrecord = :fIdrecord"),
    @NamedQuery(name = "TSecuencias.findByFEmpresa", query = "SELECT t FROM TSecuencias t WHERE t.fEmpresa = :fEmpresa"),
    @NamedQuery(name = "TSecuencias.findByFTipoDocumento", query = "SELECT t FROM TSecuencias t WHERE t.fTipoDocumento = :fTipoDocumento"),
    @NamedQuery(name = "TSecuencias.findByFSecuencia", query = "SELECT t FROM TSecuencias t WHERE t.fSecuencia = :fSecuencia"),
    @NamedQuery(name = "TSecuencias.findByFDescripcion", query = "SELECT t FROM TSecuencias t WHERE t.fDescripcion = :fDescripcion"),
    @NamedQuery(name = "TSecuencias.findByFDesplazamiento", query = "SELECT t FROM TSecuencias t WHERE t.fDesplazamiento = :fDesplazamiento"),
    @NamedQuery(name = "TSecuencias.findByFIdsucursal", query = "SELECT t FROM TSecuencias t WHERE t.fIdsucursal = :fIdsucursal")})
public class TSecuencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "f_idrecord")
    private Integer fIdrecord;
    @Column(name = "f_empresa")
    private Integer fEmpresa;
    @Column(name = "f_tipo_documento")
    private String fTipoDocumento;
    @Column(name = "f_secuencia")
    private Integer fSecuencia;
    @Column(name = "f_descripcion")
    private String fDescripcion;
    @Column(name = "f_desplazamiento")
    private Integer fDesplazamiento;
    @Column(name = "f_idsucursal")
    private Integer fIdsucursal;

    public TSecuencias() {
    }

    public TSecuencias(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public Integer getFIdrecord() {
        return fIdrecord;
    }

    public void setFIdrecord(Integer fIdrecord) {
        this.fIdrecord = fIdrecord;
    }

    public Integer getFEmpresa() {
        return fEmpresa;
    }

    public void setFEmpresa(Integer fEmpresa) {
        this.fEmpresa = fEmpresa;
    }

    public String getFTipoDocumento() {
        return fTipoDocumento;
    }

    public void setFTipoDocumento(String fTipoDocumento) {
        this.fTipoDocumento = fTipoDocumento;
    }

    public Integer getFSecuencia() {
        return fSecuencia;
    }

    public void setFSecuencia(Integer fSecuencia) {
        this.fSecuencia = fSecuencia;
    }

    public String getFDescripcion() {
        return fDescripcion;
    }

    public void setFDescripcion(String fDescripcion) {
        this.fDescripcion = fDescripcion;
    }

    public Integer getFDesplazamiento() {
        return fDesplazamiento;
    }

    public void setFDesplazamiento(Integer fDesplazamiento) {
        this.fDesplazamiento = fDesplazamiento;
    }

    public Integer getFIdsucursal() {
        return fIdsucursal;
    }

    public void setFIdsucursal(Integer fIdsucursal) {
        this.fIdsucursal = fIdsucursal;
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
        if (!(object instanceof TSecuencias)) {
            return false;
        }
        TSecuencias other = (TSecuencias) object;
        if ((this.fIdrecord == null && other.fIdrecord != null) || (this.fIdrecord != null && !this.fIdrecord.equals(other.fIdrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jqmicrosistemas.abacus.model.TSecuencias[ fIdrecord=" + fIdrecord + " ]";
    }
    
}
