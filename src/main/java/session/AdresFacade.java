/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Adres;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jeroenO
 */
@Stateless
public class AdresFacade extends AbstractFacade<Adres> {

    @PersistenceContext(unitName = "com.mycompany_ws3deel1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdresFacade() {
        super(Adres.class);
    }
    
    public List<Adres> findByPostcode(Adres adres) {
        String qlString = "select a FROM Adres a where a.postcode = :pc ";
        Query q = em.createQuery(qlString).setParameter("pc", adres.getPostcode());
        return (List<Adres>)q.getResultList();
        
    }
    
}
