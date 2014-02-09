/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.dao;

import javax.ejb.Local;
import fh.ostfalia.projekt2014.mp3files.Mp3ArtistBean;
import java.util.List;
/**
 *
 * @author David
 */
@Local
public interface Mp3ArtistDaoLocal {
    void addMp3Artist(Mp3ArtistBean mp3Artist);
    
    void deleteMp3Artist(int mp3ArtistId);
    
    Mp3ArtistBean getMp3Artist(int mp3ArtistId);

    List<Mp3ArtistBean> getAllMp3Artist();
}