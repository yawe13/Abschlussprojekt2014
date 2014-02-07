/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.dao;

import fh.ostfalia.projekt2014.mp3files.Mp3Bean;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author David
 */
@Stateless
public class Mp3Dao implements Mp3DaoLocal {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addMp3(Mp3Bean mp3) {
      em.persist(mp3);
    }

    @Override
    public void deleteMp3(int mp3_id) {
       em.remove(getMp3(mp3_id));
    }

    @Override
    public Mp3Bean getMp3(int mp3_id) {
        return em.find(Mp3Bean.class, mp3_id);
    }
    
    public int getMp3_artist(int mp3_id) {
        return em.find(Mp3Bean.class, mp3_id).getMp3_id();
    }
    
    public String getMp3_title(int mp3_id) {
        return em.find(Mp3Bean.class, mp3_id).getMp3_title();
    }
    
    public byte[] getMp3_file(int mp3_id) {
        return em.find(Mp3Bean.class, mp3_id).getMp3_file();
    }
       
    @Override
    public List<Mp3Bean> getAllMp3() {
        return em.createNamedQuery("Mp3.getAll").getResultList();
    }
    
   // Methoden zum Extrahieren der Id aus der URI, um Mp3 zu identifizieren 
    
   private String passedParameter;

    public String getPassedParameter() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        this.passedParameter = (String) facesContext.getExternalContext().
                getRequestParameterMap().get("id");
        return this.passedParameter;
    }

    public void setPassedParameter(String passedParameter) {
        this.passedParameter = passedParameter;
    }
    
}