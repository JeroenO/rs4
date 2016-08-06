/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import entity.Artikel;
import entity.BesteldeArtikelen;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import session.ArtikelFacade;

/**
 * 
 *
 * @author jeroenO
 */
@Named
@SessionScoped
public class CatalogusManager implements Serializable {
    
    @Inject
    private ArtikelFacade artikelFacade;
   
    private List<Artikel> catalogus; 
    private Collection<BesteldeArtikelen> besteldeArtikelenCollection;
    private Artikel selectedArtikel;
    
    public void voegToeAanCatalogus(Artikel artikel) {
      
      artikelFacade.create(artikel);
    }
    
    
    public void onRowSelect(SelectEvent event) {
      
       selectedArtikel = (Artikel)(event.getObject());
    }
    
    public List<Artikel> getCatalogus() {
        catalogus = artikelFacade.findAll();
        return catalogus;
    }

    public void setCatalogus(List<Artikel> catalogus) {
        this.catalogus = catalogus;
    }

    public Collection<BesteldeArtikelen> getBesteldeArtikelenCollection() {
        return besteldeArtikelenCollection;
    }

    public void setBesteldeArtikelenCollection(Collection<BesteldeArtikelen> besteldeArtikelenCollection) {
        this.besteldeArtikelenCollection = besteldeArtikelenCollection;
    }

    public Artikel getSelectedArtikel() {
        return selectedArtikel;
    }

    public void setSelectedArtikel(Artikel selectedArtikel) {
        this.selectedArtikel = selectedArtikel;
    }
    
    

   
}
