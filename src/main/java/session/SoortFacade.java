/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Soort;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jeroenO
 */
@Stateless
public class SoortFacade extends AbstractFacade<Soort> {

    @PersistenceContext(unitName = "com.mycompany_ws3deel1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SoortFacade() {
        super(Soort.class);
    }
    
}
