/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hft.jan.tsmproject.beans;

import de.hft.jan.tsmproject.dao.DAO;
import de.hft.jan.tsmproject.entities.TSMUser;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Jan
 */
@Named(value = "usermanager")
@RequestScoped
public class TSMUserManager implements Serializable{
    
    @EJB
    private DAO dao;
    
    private TSMUser user;
    
    private List<TSMUser> currentUsers;

    @PostConstruct
    public void init(){
        user = new TSMUser();
        currentUsers = dao.getAllUsers();
    }
    
    public List<TSMUser> getCurrentUsers(){
        return this.currentUsers;
    }
    
    public TSMUser getUser() {
        return user;
    }

    public void setUser(TSMUser user) {
        this.user = user;
    }
    
    public String saveUser(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful",  "You saved a new TSM USER =)") );
        return dao.saveNewTSMUser(user);
    }
    
    
}
