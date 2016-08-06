/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jeroenO
 */
@Entity
@Named
@RequestScoped
@Table(name = "adres")
@NamedQueries({
    @NamedQuery(name = "Adres.findAll", query = "SELECT a FROM Adres a")})
public class Adres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idadres")
    private Integer idadres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "straat")
    private String straat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "huisnr")
    private String huisnr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "postcode")
    private String postcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "plaatsnaam")
    private String plaatsnaam;
    @JoinTable(name = "klant_has_adres", joinColumns = {
        @JoinColumn(name = "adres_idadres", referencedColumnName = "idadres")}, inverseJoinColumns = {
        @JoinColumn(name = "klant_idklant", referencedColumnName = "idklant")})
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Collection<Klant> klantCollection = new HashSet<>();

    public Adres() {
    }

    public Adres(Integer idadres) {
        this.idadres = idadres;
    }

    public Adres(Integer idadres, String straat, String huisnr, String postcode, String plaatsnaam) {
        this.idadres = idadres;
        this.straat = straat;
        this.huisnr = huisnr;
        this.postcode = postcode;
        this.plaatsnaam = plaatsnaam;
    }

    public Integer getIdadres() {
        return idadres;
    }

    public void setIdadres(Integer idadres) {
        this.idadres = idadres;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getHuisnr() {
        return huisnr;
    }

    public void setHuisnr(String huisnr) {
        this.huisnr = huisnr;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPlaatsnaam() {
        return plaatsnaam;
    }

    public void setPlaatsnaam(String plaatsnaam) {
        this.plaatsnaam = plaatsnaam;
    }

    public Collection<Klant> getKlantCollection() {
        return klantCollection;
    }

    public void setKlantCollection(Collection<Klant> klantCollection) {
        this.klantCollection = klantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadres != null ? idadres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adres)) {
            return false;
        }
        Adres other = (Adres) object;
        if ((this.idadres == null && other.idadres != null) || (this.idadres != null && !this.idadres.equals(other.idadres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Adres[ idadres=" + idadres + " ]";
    }
    
}