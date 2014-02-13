/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.dao;

import javax.ejb.Local;
import fh.ostfalia.projekt2014.mp3files.Mp3Bean;
import java.util.List;
/**
 *
 * @author David
 */
@Local
public interface IMp3Dao {
    void addMp3(Mp3Bean mp3);
    
    void deleteMp3(int mp3_id);
    
    Mp3Bean getMp3(int mp3_id);
    
    Mp3Bean getMp3ByArtist (int mp3ArtistId);

    List<Mp3Bean> getAllMp3();
}
