/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testertje;

import entity.Klant;
import session.AbstractFacade;
import session.KlantFacade;

/**
 *
 * @author jeroenO
 */
public class tester {
    
    public static void main(String[] args) {
        AbstractFacade klantfacade = new KlantFacade();
        Klant piet = (Klant)klantfacade.find(1);
        System.out.println("naam is : "+ piet.getVoornaam());
    }
}
