/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "JUGADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j")
    , @NamedQuery(name = "Jugador.findById", query = "SELECT j FROM Jugador j WHERE j.id = :id")
    , @NamedQuery(name = "Jugador.findByNombre", query = "SELECT j FROM Jugador j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Jugador.findByImagen", query = "SELECT j FROM Jugador j WHERE j.imagen = :imagen")
    , @NamedQuery(name = "Jugador.findByLink", query = "SELECT j FROM Jugador j WHERE j.link = :link")
    , @NamedQuery(name = "Jugador.findByPais", query = "SELECT j FROM Jugador j WHERE j.pais = :pais")
    , @NamedQuery(name = "Jugador.findByEstatura", query = "SELECT j FROM Jugador j WHERE j.estatura = :estatura")
    , @NamedQuery(name = "Jugador.findByEdad", query = "SELECT j FROM Jugador j WHERE j.edad = :edad")
    , @NamedQuery(name = "Jugador.findByLikes", query = "SELECT j FROM Jugador j WHERE j.likes = :likes")})
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Short id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "IMAGEN")
    private String imagen;
    @Column(name = "LINK")
    private String link;
    @Column(name = "PAIS")
    private String pais;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ESTATURA")
    private BigDecimal estatura;
    @Column(name = "EDAD")
    private Short edad;
    @Column(name = "LIKES")
    private Short likes;
    @JoinColumn(name = "EQUIPO", referencedColumnName = "ID")
    @ManyToOne
    private Equipo equipo;

    public Jugador() {
    }

    public Jugador(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public BigDecimal getEstatura() {
        return estatura;
    }

    public void setEstatura(BigDecimal estatura) {
        this.estatura = estatura;
    }

    public Short getEdad() {
        return edad;
    }

    public void setEdad(Short edad) {
        this.edad = edad;
    }

    public Short getLikes() {
        return likes;
    }

    public void setLikes(Short likes) {
        this.likes = likes;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Jugador[ id=" + id + " ]";
    }
    
}
