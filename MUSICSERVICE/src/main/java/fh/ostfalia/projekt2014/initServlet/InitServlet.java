/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.initServlet;

import fh.ostfalia.projekt2014.dao.Mp3Dao;
import fh.ostfalia.projekt2014.mp3files.Id3Tag;
import fh.ostfalia.projekt2014.mp3files.Mp3Bean;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Mettbrötchen
 */
public class InitServlet implements ServletContextListener {

    private ServletContext context;
    private Id3Tag id3 = new Id3Tag();
    //private Mp3Bean mp3 = new Mp3Bean();
    private ArrayList<Mp3Bean> mp3List = new ArrayList();
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
        /*
        mp3List = id3.initFiles(3);
        
        Mp3Dao mp3Dao = new Mp3Dao();
        for(int i=0; i <= mp3List.size(); i++){
            Mp3Bean tempMp3Bean = mp3List.get(i);
            mp3Dao.addMp3(tempMp3Bean);
        }*/
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ENDE!!!!!!!!!!!!!!!!!!!!!");
    }

}
