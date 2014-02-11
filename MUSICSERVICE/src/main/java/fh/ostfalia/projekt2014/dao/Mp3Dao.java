/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.dao;

import fh.ostfalia.projekt2014.mp3files.Id3Tag;
import fh.ostfalia.projekt2014.mp3files.Mp3ArtistBean;
import fh.ostfalia.projekt2014.mp3files.Mp3Bean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Part;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import sun.misc.IOUtils;


/**
 *
 * @author David
 */
@Stateless
public class Mp3Dao implements Mp3DaoLocal {
    @PersistenceContext
    private EntityManager em;
    @Resource
    private UserTransaction ut; 
    
    private byte[] fileContent;
  
    private Mp3ArtistDao mp3ArtistDao;
    
    public void addMp3List(ArrayList<Mp3Bean> mp3BeanList){
       try{
           ut.begin();
            
           for(int i=0; i <= mp3BeanList.size(); i++){
             Mp3Bean tempMp3Bean = mp3BeanList.get(i);
                em.persist(tempMp3Bean);
            }
        
           ut.commit();
       }
       catch(NotSupportedException e){
           e.printStackTrace();
       } catch (RollbackException ex) {
            Logger.getLogger(Mp3Dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(Mp3Dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(Mp3Dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Mp3Dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(Mp3Dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(Mp3Dao.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
       


    @Override
    public void deleteMp3(int mp3_id) {
       em.remove(getMp3(mp3_id));
    }

    @Override
    public Mp3Bean getMp3(int mp3_id) {
        return em.find(Mp3Bean.class, mp3_id);
    }
    

    public Mp3Bean getMp3ByArtist(int mp3ArtistId) {
        return em.find(Mp3Bean.class, mp3ArtistId);
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
    


  

    @Override
    public void addMp3(Mp3Bean mp3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}