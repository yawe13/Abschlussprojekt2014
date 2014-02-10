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
import java.util.List;
import java.util.Scanner;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Part;
import sun.misc.IOUtils;


/**
 *
 * @author David
 */
@Stateless
public class Mp3Dao implements Mp3DaoLocal {
    @PersistenceContext
    private EntityManager em;

    private Part part;
    private byte[] fileContent;
    
    
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
        try {
            
            byte[] song=new byte[(int)part.getSize()];
            InputStream input = part.getInputStream();
            
            File file = new File("/Users/David/Downloads/test4.mp3");
            OutputStream output = new FileOutputStream(file);
            int read = 0;
            byte[] bytes = new byte[1024];
            
            while ((read = input.read(bytes)) != -1) {
			output.write(bytes, 0, read);
		}
            
            System.out.println(part.getSize());
           input.close();
           output.close();
            
        } catch (IOException e) {
        }
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

 
}