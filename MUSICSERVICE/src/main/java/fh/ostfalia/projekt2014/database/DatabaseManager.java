/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Mettbrötchen
 */
public class DatabaseManager {
    private static Connection con = null;
    private PreparedStatement pstmt = null;
    private static Properties prop = new Properties();
    private FileInputStream fis = null;
    
    private static DatabaseManager instance = null;
    
    private DatabaseManager(){
        
    }
    
    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }
    
    public void createConnection() {
        try {
            // MySQL Treiber laden
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // OO! Treiber konnte nicht geladen werden.
            System.out.println("Treiber konnte nicht geladen werden!");
            e.printStackTrace();
        }

        try {
            // config.ini Datei laden
            prop.load(new FileInputStream("config.ini"));
        } catch (IOException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //Verbindung herstellen
            con = DriverManager.getConnection("jdbc:"+prop.getProperty("mysqlServer")+"/?user=" +prop.getProperty("user")+"&password="+prop.getProperty("password")+"&allowMultiQueries=true");                          
            
            //Datenbankstruktur erstellen, falls noch nicht vorhanden
            createTableIfNotExists();

        } catch (SQLException ex) {
            System.out.println("Es konnte keine Verbindung zur Datenbank hergestellt werden!");
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    private void createTableIfNotExists(){
        try {   
            pstmt = con.prepareStatement("CREATE DATABASE IF NOT EXISTS "+prop.getProperty("dbName"));
            pstmt.execute();
            con.setCatalog(prop.getProperty("dbName"));
            
            pstmt = con.prepareStatement("CREATE TABLE IF NOT EXISTS mp3_files ("
                                        + "mp3_id int(11) NOT NULL AUTO_INCREMENT,"
                                        + "mp3_file longblob NOT NULL,"
                                        + "mp3_title varchar(255), "
                                        + "mp3_artist varchar(255),"
                                        + "PRIMARY KEY (mp3_id))");
            pstmt.execute();
            pstmt.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Datenbankverbindung schließen
     */
    public static void closeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertMp3File(File file, String title, String artist) {
        try {
            fis = new FileInputStream(file);
            String sql = "INSERT INTO mp3_files (mp3_file, mp3_title, mp3_artist) VALUES (?, ?, ?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setBinaryStream(1, fis, (int) file.length());
            pstmt.setString(2, title);
            pstmt.setString(3, artist);
            pstmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
