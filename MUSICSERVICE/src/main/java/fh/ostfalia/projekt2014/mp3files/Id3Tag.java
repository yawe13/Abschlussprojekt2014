/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.mp3files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
        uploadDir = new File("C:\\Users\\David\\Documents\\NetBeansProjects\\Abschlussprojekt2014\\MUSICSERVICE\\Upload");
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

    public ArrayList<Mp3Bean> initFiles(int readFiles) {

        ArrayList<Mp3Bean> list = new ArrayList();
        File[] fileList = uploadDir.listFiles();

        for (int i = 0; i <= readFiles - 1; i++) {
            File file = fileList[i].getAbsoluteFile();
            if (file.isFile()) {
                try {
                    Mp3Bean mp3 = new Mp3Bean();
                    Mp3ArtistBean mp3artist = new Mp3ArtistBean();

                    mp3artist.setArtistName(this.readArtist(file));
                    
                    FileInputStream input = new FileInputStream(file);
                    //OutputStream output = new FileOutputStream(file);
                    int read = 0;
                    byte[] bytes = new byte[1024];
                   
                    while ((read = input.read(bytes)) != -1) {
                        input.read(bytes, 0, read);
                    }

                    mp3.setMp3_file(bytes);
                            
                    mp3.setMp3_artist(mp3artist);
                    mp3.setMp3_title(this.readTitle(file));
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
