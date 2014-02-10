/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.dao;

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
    UserTransaction ut; 
    private Part part;
    private byte[] fileContent;
    
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
    public void addMp3(Mp3Bean mp3) {
        
        try {
            ut.begin();
            em.persist(mp3);
            ut.commit();
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
        } catch (NotSupportedException ex) {
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
    
    //////////////
    public void upload() {
        //try {
            Mp3Bean mp3 = new Mp3Bean();
            byte[] song=new byte[(int)part.getSize()];
            mp3.setMp3_artist(null);
            //mp3.setMp3_id(5);
            mp3.setMp3_title("ASDASD");
            mp3.setMp3_file(song);
            this.addMp3(mp3);
//InputStream input = part.getInputStream();
            //File file = (File)part;
            //file.length();
            
            //System.out.println(file.length());
  /*         OutputStream output = new FileOutputStream(file);
            int read = 0;
            byte[] bytes = new byte[1024];
            
            while ((read = input.read(bytes)) != -1) {
			output.write(bytes, 0, read);
		}
            
            System.out.println(file.getPath());
           input.close();
           output.close();
            */
      //  } catch (IOException e) {
      //  }
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
}