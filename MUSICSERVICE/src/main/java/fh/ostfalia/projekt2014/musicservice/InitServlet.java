/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.musicservice;

import fh.ostfalia.projekt2014.database.DatabaseManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Mettbrötchen
 */
public class InitServlet implements ServletContextListener {
   
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
  /*      
        ServletContext sc = sce.getServletContext();
        
    	String url = sc.getInitParameter("url");
    	String user_name = sc.getInitParameter("user_name");
    	String password = sc.getInitParameter("password");
    	String database = sc.getInitParameter("database");
        DatabaseManager instance = DatabaseManager.getInstance(url, user_name, password, database);
        instance.createConnection();
*/
        

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ENDE!!!!!!!!!!!!!!!!!!!!!");
    }
    
}
