/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import entity.Klant;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import session.KlantFacade;

/**
 *
 * @author jeroenO
 */
@Named
@SessionScoped

public class PasswordManager implements Serializable{
    
    private String inlogNr;
    private String ingevuld;
    private String opgeslagen = "1";
    private Boolean verified;
    private Klant ingelogdeKlant;

    @Inject
    KlantFacade klantFacade;
    
//    @Inject
//    FirstManager firstManager;

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }
    
    public Boolean verify() {
        verified = (opgeslagen.equals(ingevuld));
        
        return verified;
    }
    
    
    public String getIngevuld() {
        return ingevuld;
    }

    public void setIngevuld(String ingevuld) {
        this.ingevuld = ingevuld;
    }

    public String getOpgeslagen() {
        return opgeslagen;
    }

    public void setOpgeslagen(String opgeslagen) {
        this.opgeslagen = opgeslagen;
    }
    
    public void pwTest() {
        ingelogdeKlant = klantFacade.find(Integer.parseInt(inlogNr));
    }
    public void info() {
        FacesContext.getCurrentInstance().addMessage("message1", new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
    }
    public Klant getIngelogdeKlant() {
        return ingelogdeKlant;
    }

    public void setIngelogdeKlant(Klant ingelogdeKlant) {
        this.ingelogdeKlant = ingelogdeKlant;
    }

    public String getInlogNr() {
        return inlogNr;
    }

    public void setInlogNr(String inlogNr) {
        this.inlogNr = inlogNr;
    }
}
