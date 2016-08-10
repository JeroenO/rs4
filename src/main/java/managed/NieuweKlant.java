/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import entity.Adres;
import entity.Klant;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import session.AdresFacade;
import session.KlantFacade;

/**
 *
 * @author jeroenO
 */
@Named
@SessionScoped
public class NieuweKlant implements Serializable {
    
    @Inject
    private AdresFacade adresFacade;
    @Inject
    private KlantFacade klantFacade;
    
    public void saveKlantAdres(Klant nieuweKlant, Adres adres) {
        nieuweKlant.getAdresCollection().add(adres);
        adres.getKlantCollection().add(nieuweKlant);
     
     adresFacade.create(adres);
     
    }
    
    public void voegAdresToe(Integer klantID, Adres adres) {
    
        Klant bestaandeKlant = klantFacade.find(klantID);
        List<Adres> bestaand = adresFacade.findByPostcode(adres);
        if (!bestaand.isEmpty())  {
            adres = bestaand.get(0);
        }
        else {
            adresFacade.create(adres);
        }
        adres.getKlantCollection().add(bestaandeKlant);
        adresFacade.edit(adres);
        System.out.println(adresFacade.findByPostcode(adres));
      
    }
    
    
    
}
