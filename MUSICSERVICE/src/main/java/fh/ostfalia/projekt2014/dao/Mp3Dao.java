/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.dao;

import fh.ostfalia.projekt2014.mp3files.Mp3;
import java.util.List;
import javax.ejb.Stateless;
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
    public void addMp3(Mp3 mp3) {
      em.persist(mp3);
    }

    @Override
    public void deleteMp3(int mp3_id) {
       em.remove(getMp3(mp3_id));
    }

    @Override
    public Mp3 getMp3(int mp3_id) {
        return em.find(Mp3.class, mp3_id);
    }

    @Override
    public List<Mp3> getAllMp3() {
        return em.createNamedQuery("Mp3.getAll").getResultList();
    }
  

    

}