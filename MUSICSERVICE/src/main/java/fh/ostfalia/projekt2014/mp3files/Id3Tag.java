/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.mp3files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;

/**
 *
 * @author Mettbrötchen
 */
public class Id3Tag {
    private MP3File mp3file;
    private final File uploadDir;


    
    public Id3Tag() {
        uploadDir = new File(".\\Upload");
    }
    
    public Id3Tag(String customUploadPath) {
        uploadDir = new File(customUploadPath);
    }

    private String readArtist(File file) throws TagException, IOException {
        mp3file = new MP3File(file);
        return mp3file.getID3v1Tag().getArtist();
    }

    private String readTitle(File file) throws TagException, IOException {
        mp3file = new MP3File(file);
        return mp3file.getID3v1Tag().getSongTitle();
    }

    public ArrayList<Mp3> initFiles(int readFiles) {
        
        ArrayList<Mp3> list = new ArrayList();
        File[] fileList = uploadDir.listFiles();
        
        for (int i = 0; i <= readFiles-1; i++) {
            File file = fileList[i].getAbsoluteFile();
            if (file.isFile()) {
                try {
                    Mp3 mp3 = new Mp3();
                    mp3.setFile(file);
                    mp3.setArtist(this.readArtist(file));
                    mp3.setTitle(this.readTitle(file));
                    list.add(mp3);
                } catch (TagException ex) {
                    Logger.getLogger(Id3Tag.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Id3Tag.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }
}
