/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.mp3files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.security.Identity;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.stream.FileImageInputStream;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.servlet.http.Part;
import sun.misc.IOUtils;

/**
 *
 * @author Mettbrötchen
 */
@Entity(name = "Mp3")
@NamedQueries({
    @NamedQuery(name = "Mp3.getAll", query = "SELECT e FROM Mp3 e")})

public class Mp3Bean implements Serializable {

    private Mp3ArtistBean mp3Artist;
    private int mp3_id;
    private byte[] mp3_file;
    private String mp3_title;

    public Mp3Bean() {
    }

    public Mp3Bean(Mp3ArtistBean mp3Artist, byte[] mp3_file, String mp3_title) {
        this.mp3Artist = mp3Artist;
        this.mp3_file = mp3_file;
        this.mp3_title = mp3_title;
    }

    @Id
    @Column(name = "mp3_id")
    @GeneratedValue(strategy = IDENTITY)
    public int getMp3_id() {
        return mp3_id;
    }

    public void setMp3_id(int mp3_id) {
        this.mp3_id = mp3_id;
    }

    @Column(name = "mp3_file")
    @Lob
    public byte[] getMp3_file() {
        return mp3_file;
    }

    public void setMp3_file(byte[] mp3_file) {
        this.mp3_file = mp3_file;
    }

    @Column(name = "mp3_title")
    public String getMp3_title() {
        return mp3_title;
    }

    public void setMp3_title(String mp3_title) {
        this.mp3_title = mp3_title;

    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    public Mp3ArtistBean getMp3ArtistBean() {
        return this.mp3Artist;
    }

    public void setMp3ArtistBean(Mp3ArtistBean mp3Artist) {
        this.mp3Artist = mp3Artist;
    }
    
    public int getArtistId(){
        return mp3Artist.getArtist_id();
    }
    
  
    

    public void setMp3ByteCodeFromFile(File file) {

        try {

            mp3_file = new byte[(int) file.length()];

            FileInputStream inputStream = new FileInputStream(file);
            try {
                inputStream.read(mp3_file);
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Mp3Bean.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Mp3Bean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
