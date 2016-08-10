/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import entity.Adres;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import session.AdresFacade;

/**
 *
 * @author jeroenO
 */
@Named
@SessionScoped
public class AdressenTabel implements Serializable{
    
    @Inject
    private AdresFacade adresFacade;
    
    private List<Adres> adressen;
    private Adres selectedAdres;

    
    public void onRowEdit(RowEditEvent event){
          
        selectedAdres = (Adres)(event.getObject());
        updateAdres();
    } 
       
    public void updateAdres() {
        adresFacade.edit(selectedAdres);
    }
        
    public List<Adres> getAdressen() {
        return adressen;
    }

    public void setAdressen(List<Adres> adressen) {
        this.adressen = adressen;
    }

    public Adres getSelectedAdres() {
        return selectedAdres;
    }

    public void setSelectedAdres(Adres selectedAdres) {
        this.selectedAdres = selectedAdres;
    }
   
    
    
}
