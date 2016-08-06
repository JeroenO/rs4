/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import entity.Adres;
import entity.Klant;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import session.AdresFacade;
import session.KlantFacade;

/**
 *
 * @author jeroenO
 */
@Named
@SessionScoped
public class FirstManager implements Serializable{
    
    @Inject
    private KlantFacade klantFacade;
    @Inject
    private AdresFacade adresFacade;
    
   // private Klant klant;
   // private List<Klant> klanten ;
    private int klantID;
    private Klant selectedKlant;
    private Adres selectedAdres;
    
    public FirstManager() {

    }
    
    public Klant getKlant() {
        
        
        //this.deKlant = klantFacade.find(klantID);
        return klantFacade.find(klantID);
    }
    
    public List<Klant> getKlanten(){
      //  klanten = klantFacade.findAll();
        return klantFacade.findAll();
        
    }
    public void setKlantID(int klantID) {
        this.klantID = klantID;
    }
    public int getKlantID() {
        return klantID;
    }
    
    public void saveKlant(Klant nieuweKlant){
        
        klantFacade.create(nieuweKlant);
    }
    
    public void saveKlantAdres(Klant nieuweKlant, Adres adres) {
        nieuweKlant.getAdresCollection().add(adres);
        adres.getKlantCollection().add(nieuweKlant);
     //   saveKlant(nieuweKlant);
     adresFacade.create(adres);
     
    }
    public Klant getSelectedKlant() {
                   
        return selectedKlant;
    }
     public void setSelectedKlant(Klant selectedKlant) {
                     
        this.selectedKlant = selectedKlant ;
    }
    
    public Adres getSelectedAdres() {
                   
        return selectedAdres;
    }
     public void setSelectedAdres(Adres selectedAdres) {
                     
        this.selectedAdres = selectedAdres ;
    } 
     
     public void onRowSelect(SelectEvent event) {
       FacesMessage msg = new FacesMessage("Klant Selected", Integer.toString(((Klant)(event.getObject())).getIdklant()));
       FacesContext.getCurrentInstance().addMessage("message1", msg);
       selectedKlant = (Klant)(event.getObject());
      
       Collection adressen = selectedKlant.getAdresCollection();
       if (adressen.isEmpty()) adressen.add(new Adres());
     //  selectedAdres =  (Adres)adressen.toArray()[0];
     selectedAdres =  (Adres)adressen.iterator().next();
    }
    
      
    public void info() {
        FacesContext.getCurrentInstance().addMessage("message1", new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
    }
     
    public void warn() {
        FacesContext.getCurrentInstance().addMessage("message2", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Watch out for PrimeFaces."));
    }
     
    public void error() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
    }
     
    public void fatal() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
    }
      
}
