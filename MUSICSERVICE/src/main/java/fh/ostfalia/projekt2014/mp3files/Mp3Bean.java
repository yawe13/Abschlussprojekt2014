/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.mp3files;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Mettbrötchen
 */
@Entity
@Table (name="Mp3")
@NamedQueries({@NamedQuery(name="Mp3.getAll", query="SELECT e FROM Mp3 e")})

public class Mp3Bean implements Serializable {
    @Id
    @Column (name="mp3_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int mp3_id;
    @Column (name="mp3_file")
    @Lob
    private byte[] mp3_file;
    @Column (name="mp3_title")
    private String mp3_title;
    @ManyToOne
    @JoinColumn(name="mp3_artist_id")
    private Mp3ArtistBean mp3_artist_id;
   
    
    public Mp3Bean() {
    }

    public int getMp3_id() {
        return mp3_id;
    }

    public void setMp3_id(int mp3_id) {
        this.mp3_id = mp3_id;
    }

    public byte[] getMp3_file() {
        return mp3_file;
    }

    public void setMp3_file(byte[] mp3_file) {
        this.mp3_file = mp3_file;
    }
 
    public String getMp3_title() {
        return mp3_title;
    }

    public void setMp3_title(String mp3_title) {
        this.mp3_title = mp3_title;
    }

    public Mp3ArtistBean getMp3_artist_id() {
        return mp3_artist_id;
    }

    public void setMp3_artist_id(Mp3ArtistBean mp3_artist_id) {
        this.mp3_artist_id = mp3_artist_id;
    }
}
