/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.mp3files;

import java.io.File;
import java.io.Serializable;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Mettbrötchen
 */
@Entity
@Table
@NamedQueries({@NamedQuery(name="Mp3.getAll",query="SELECT e FROM Mp3 e")})
public class Mp3 implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int mp3_id;
    @Column
    private File mp3_file;
    @Column
    private String mp3_title;
    @Column
    private String mp3_artist;

    public Mp3() {
    }

    public int getMp3_id() {
        return mp3_id;
    }

    public void setMp3_id(int mp3_id) {
        this.mp3_id = mp3_id;
    }

    public File getMp3_file() {
        return mp3_file;
    }

    public void setMp3_file(File mp3_file) {
        this.mp3_file = mp3_file;
    }


    public String getMp3_title() {
        return mp3_title;
    }

    public void setMp3_title(String mp3_title) {
        this.mp3_title = mp3_title;
    }

    public String getMp3_artist() {
        return mp3_artist;
    }

    public void setMp3_artist(String mp3_artist) {
        this.mp3_artist = mp3_artist;
    }
}
