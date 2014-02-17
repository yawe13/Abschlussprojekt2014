/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.rmibsp;

import java.rmi.Naming;

/**
 *
 * @author KingDCB
 */
public class DienstBrowser {
    DienstServer server;
    
    public Object[] getDienstListe(){
         Object obj = null; 
         Object [] dienste= null;
         try{
             obj= Naming.lookup("rmi://127.0.0.1/DienstServer");
         }
         catch(Exception ex) {
             ex.printStackTrace();
         }
         server = (DienstServer) obj;
        
         try{
             dienste = server.getDienstListe();
         }
         catch (Exception ex){
             ex.printStackTrace();
         }
         System.out.println("ALLES KLAR");
         return dienste;
        
     }
}
