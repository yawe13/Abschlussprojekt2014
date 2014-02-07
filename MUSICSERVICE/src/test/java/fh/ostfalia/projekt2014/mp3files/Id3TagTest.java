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
    
    private static Mp3Bean file1;
    private static Mp3Bean file2;
    private static Mp3Bean file3;
    
    public Id3TagTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        
        file1 = new Mp3Bean();
       // file1.setMp3_file(new File(".test\\testfiles\\Auquid_-_In_The_Rain.mp3"));
        file1.setMp3_title("In The Rain");
        //file1.setMp3_artist("Auquid");
        
        file2 = new Mp3Bean();
       // file2.setMp3_file(new File(".test\\testfiles\\Defnael_-_Conquest_Of_The_West_-_Conquete_de_l_Ouest.mp3"));
        file2.setMp3_title("Defnael");
        //file2.setMp3_artist("Conquest Of The West Conquete");
        
        file3 = new Mp3Bean();
      //  file3.setMp3_file(new File(".test\\testfiles\\Doxent_Zsigmond_-_Journey.mp3"));
        file3.setMp3_title("Doxent Zsigmond");
        //file3.setMp3_artist("Journey");
        
 
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

        ArrayList<Mp3Bean> expResult = new ArrayList();
        expResult.add(file1);
        expResult.add(file2);
        expResult.add(file3);
        
        ArrayList<Mp3Bean> result = instance.initFiles(readFiles);
        for(int i = 0; i >= expResult.size(); i++){
            assertEquals(expResult.get(i).getMp3_file(), result.get(i).getMp3_file());
            assertEquals(expResult.get(i).getMp3_title(), result.get(i).getMp3_title());
          //  assertEquals(expResult.get(i).getMp3_artist(), result.get(i).getMp3_artist());
        }
    }

}
