/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.navigator;



/**
 *
 * @author KingDCB
 */

public class TestBean {
    private int length = 1000;
    private int area;
    
    
    public int getArea(){
        return length*length;
    }
    
     public int getLength(){
        return length;
    }
     
  
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void setLength(int i) {
        i = length;
    }

    public void setArea(int i) {
        i = area;
    }

    public void test(){
        System.out.println("trololol");
    }
    
}
