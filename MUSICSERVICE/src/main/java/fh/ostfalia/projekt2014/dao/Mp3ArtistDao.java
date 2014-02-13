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
import java.util.List;
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
        File file = new File("C:\\Users\\Yannick\\Documents\\NetBeansProjects\\MalteDavid\\Abschlussprojekt2014\\MUSICSERVICE\\Upload\\" + part.getSubmittedFileName());

        Mp3ArtistBean mp3ArtistBean;

        Mp3Bean mp3Bean = new Mp3Bean();
        mp3Bean = id3.readMp3File(file);
        System.out.println(mp3Bean.getMp3_title());

        Mp3ArtistDao mp3ArtistDao = new Mp3ArtistDao();
        mp3ArtistBean = mp3Bean.getMp3ArtistBean();

        mp3ArtistBean.addMp3Bean(mp3Bean);//Zuordnung Artist->Titel(Liste von Titeln)

        this.persistMp3ArtistBean(mp3ArtistBean);

    }

    @Override
    public void deleteMp3Artist(int mp3ArtistId) {
        em.remove(getMp3ArtistBean(mp3ArtistId));
    }

    @Override
    public Mp3ArtistBean getMp3ArtistBean(int artistId) {
        return em.find(Mp3ArtistBean.class, artistId);
    }

    public String getMp3ArtistNameByMp3Id(int mp3Id) {
        
         return em.find(Mp3Bean.class, mp3Id).getMp3ArtistBean().getArtistName();
    }
    
     public String getMp3ArtistNameByArtistBean(Mp3ArtistBean mp3ArtistBean) {
         
         return mp3ArtistBean.getArtistName();
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
