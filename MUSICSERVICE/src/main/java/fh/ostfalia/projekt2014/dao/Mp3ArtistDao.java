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
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.servlet.http.Part;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;


/**
 *
 * @author David
 */
@Stateless
public class Mp3ArtistDao implements IMp3ArtistDao {
    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction ut;
    private Id3Tag id3;
    private Part part;
  
    
    @Override
    public void persistMp3ArtistBean(Mp3ArtistBean mp3ArtistBean) {
        try {     
            System.out.println("Beginne persistMp3ArtistBean....");
            //em =  emf.createEntityManager();
            ut.begin();
            System.out.println(mp3ArtistBean.getArtistName());
            System.out.println(mp3ArtistBean.getArtist_id());
            em.persist(mp3ArtistBean);
            ut.commit();
 
        } catch (RollbackException ex) {
            Logger.getLogger(Mp3ArtistDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(Mp3ArtistDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(Mp3ArtistDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Mp3ArtistDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(Mp3ArtistDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(Mp3ArtistDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSupportedException ex) {
            Logger.getLogger(Mp3ArtistDao.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
          
    }
     
    public void upload() throws IOException {
        id3 = new Id3Tag();
        File file = new File("C:\\Users\\Yannick\\Documents\\NetBeansProjects\\MalteDavid\\Abschlussprojekt2014\\MUSICSERVICE\\Upload\\"+part.getSubmittedFileName());
        System.out.println("HIER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+file.getName());
        
        Mp3ArtistBean mp3ArtistBean;
        
        Mp3Bean mp3Bean = new Mp3Bean();
        mp3Bean = id3.readMp3File(file);
        System.out.println(mp3Bean.getMp3_title());
        
        
        Mp3ArtistDao mp3ArtistDao = new Mp3ArtistDao();
        mp3ArtistBean = mp3Bean.getMp3ArtistBean();
        
        mp3ArtistBean.addMp3Bean(mp3Bean);//Zuordnung Artist->Titel(Liste von Titeln)
        
        System.out.println("DAAAAAAA!!!!!2214qwert"+mp3Bean.getMp3ArtistBean());
        
        this.persistMp3ArtistBean(mp3ArtistBean);
        
        /*
            OutputStream output = new FileOutputStream(file);
            int read = 0;
            byte[] bytes = new byte[1024];
            
            while ((read = input.read(bytes)) != -1) {
                output.write(bytes, 0, read);
            }*/
        /*    
        Mp3Bean mp3 = new Mp3Bean();
            byte[] song=new byte[(int)part.getSize()];
            mp3.setMp3_artist(null);
            //mp3.setMp3_id(5);
            mp3.setMp3_title("ASDASD");
            mp3.setMp3_file(song);
            this.addMp3(mp3);
        */
//InputStream input = part.getInputStream();
            //File file = (File)part;
            //file.length();
            
            //System.out.println(file.length());
           
            
         /*   System.out.println(file.getPath());
            input.close();
            output.close();
            
            //  } catch (IOException e) {
            //  }
     
     
            
                input.close();
           */
        
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
      public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
}