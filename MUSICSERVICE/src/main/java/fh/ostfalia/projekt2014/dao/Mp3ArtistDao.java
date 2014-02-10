/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.dao;

import fh.ostfalia.projekt2014.mp3files.Mp3ArtistBean;
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
public class Mp3ArtistDao implements Mp3ArtistDaoLocal {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addMp3Artist(Mp3ArtistBean mp3Artist) {
      em.persist(mp3Artist);
    }

    @Override
    public void deleteMp3Artist(int mp3ArtistId) {
       em.remove(getMp3Artist(mp3ArtistId));
    }

    @Override
    public Mp3ArtistBean getMp3Artist(int mp3_id) {
        return em.find(Mp3ArtistBean.class, mp3_id);
    }
    
    public String getMp3ArtistName(int mp3_id) {
        return em.find(Mp3ArtistBean.class, mp3_id).getArtistName();
    }
    
       
    @Override
    public List<Mp3ArtistBean> getAllMp3Artist() {
        return em.createNamedQuery("Mp3Artist.getAll").getResultList();
    }
    
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