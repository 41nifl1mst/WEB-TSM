/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hft.jan.tsmproject.dao;

import de.hft.jan.tsmproject.entities.TSMUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jan
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DAO {
    
    @PersistenceContext(unitName = "jdbc/tsm")
    EntityManager em;
    
    public String saveNewTSMUser(TSMUser user){
        em.persist(user);
        return null;
    }
    
    public List<TSMUser> getAllUsers(){
        return (List<TSMUser>) em.createNamedQuery("TSMUser.findAll").getResultList();
    }
    
}
