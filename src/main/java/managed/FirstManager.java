/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import entity.Klant;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
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

    private List<Klant> onzeKlanten ;
    private Klant selectedKlant;
    private int selectedID;
   
    public FirstManager() {

    }
    
    public void onRowSelect(SelectEvent event) {
       
       selectedKlant = (Klant)(event.getObject());
       selectedID = selectedKlant.getIdklant();//klant wordt niet ontjhouden id wel
        
    }
    public void onRowEdit(RowEditEvent event){
               
        updateKlant();
    }  
    public void updateKlant() {
        klantFacade.edit(selectedKlant);
    }
    public void refreshLijst() {
        
        onzeKlanten = klantFacade.findAll();
    }
             
    public List<Klant> getOnzeKlanten() {
       
        if (onzeKlanten == null) onzeKlanten = klantFacade.findAll();
        return onzeKlanten;
    }

    public void setOnzeklanten(List<Klant> onzeklanten) {
        this.onzeKlanten = onzeklanten;
    }
    public Klant getSelectedKlant() {
                   
        return selectedKlant;
    }
    
    public void setSelectedKlant(Klant selectedKlant) {
                     
        this.selectedKlant = selectedKlant ;
    }

    public int getSelectedID() {
        return selectedID;
    }

    public void setSelectedID(int selectedID) {
        this.selectedID = selectedID;
    }
    
      
}
