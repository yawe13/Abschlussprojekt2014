/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.mp3files;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author David
 */
@Entity(name = "Mp3Artist")
@NamedQueries({
    @NamedQuery(name = "Mp3Artist.getAll", query = "SELECT e FROM Mp3Artist e")})

public class Mp3ArtistBean implements Serializable {

    private int artist_id;
    private String artist_name;
    private Set<Mp3Bean> mp3Beans = new HashSet<Mp3Bean>(0);
    
    public Mp3ArtistBean(){
    }

    public Mp3ArtistBean(String artist_name) {
        this.artist_name = artist_name;
    }
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "artist_id", unique = true, nullable = false)
    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }
    
    public void addMp3Bean(Mp3Bean mp3Bean){
        mp3Beans.add(mp3Bean);
    }

    @Column(name = "artist_name")
    public String getArtistName() {
        return artist_name;
    }

    public void setArtistName(String artist_name) {
        this.artist_name = artist_name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Mp3ArtistBean")
    public Set<Mp3Bean> getMp3Beans() {
        return this.mp3Beans;
    }

    public void setMp3Beans(Set<Mp3Bean> mp3Beans) {
        this.mp3Beans = mp3Beans;
    }

}
