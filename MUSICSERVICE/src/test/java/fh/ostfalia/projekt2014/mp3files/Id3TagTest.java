/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.mp3files;

import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mettbrötchen
 */
public class Id3TagTest {
    
    private static Mp3 file1;
    private static Mp3 file2;
    private static Mp3 file3;
    
    public Id3TagTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        
        file1 = new Mp3();
        file1.setFile(new File(".test\\testfiles\\Auquid_-_In_The_Rain.mp3"));
        file1.setTitle("In The Rain");
        file1.setArtist("Auquid");
        
        file2 = new Mp3();
        file2.setFile(new File(".test\\testfiles\\Defnael_-_Conquest_Of_The_West_-_Conquete_de_l_Ouest.mp3"));
        file2.setTitle("Defnael");
        file2.setArtist("Conquest Of The West Conquete");
        
        file3 = new Mp3();
        file3.setFile(new File(".test\\testfiles\\Doxent_Zsigmond_-_Journey.mp3"));
        file3.setTitle("Doxent Zsigmond");
        file3.setArtist("Journey");
        
 
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of initFiles method, of class Id3Tag.
     */
    @Test
    public void testInitFiles() {
        System.out.println("initFiles");
        int readFiles = 3;
        Id3Tag instance = new Id3Tag(".\\src\\test\\testfiles");

        ArrayList<Mp3> expResult = new ArrayList();
        expResult.add(file1);
        expResult.add(file2);
        expResult.add(file3);
        
        ArrayList<Mp3> result = instance.initFiles(readFiles);
        for(int i = 0; i >= expResult.size(); i++){
            assertEquals(expResult.get(i).getFile(), result.get(i).getFile());
            assertEquals(expResult.get(i).getTitle(), result.get(i).getTitle());
            assertEquals(expResult.get(i).getArtist(), result.get(i).getArtist());
        }
    }

}
