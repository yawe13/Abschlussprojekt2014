/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.mp3files;

import java.io.File;

/**
 *
 * @author Mettbrötchen
 */
public class Mp3 {
    private File file;
    private String artist;
    private String title;

    public Mp3() {
    }

    public File getFile() {
        return file;
    }

    public String getArtist() {
        return artist;
    }
    
    public void setFile(File file) {
        this.file = file;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }    
}
