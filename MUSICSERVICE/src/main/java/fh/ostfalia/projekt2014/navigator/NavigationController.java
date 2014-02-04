/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.navigator;

import java.io.Serializable;


import javax.faces.bean.ManagedProperty;


/**
 *
 * @author KingDCB
 */


public class NavigationController implements Serializable {

   private static final long serialVersionUID = 1L;

   @ManagedProperty(value="#{param.pageId}")
   private String pageId;

   public String moveToPage1(){
      return "show_music"; 
   }

   public String moveToPage2(){
      return "page2"; 
   }

   public String moveToHomePage(){
      return "index"; 
   }

   public String processPage1(){
      return "page"; 
   }

   public String processPage2(){
      return "page"; 
   }

   public void Test(){
       
       System.out.println("Halloooo");
   }
   
   public String showPage(){
      if(pageId == null){
         return "index";
      }
      if(pageId.equals("1")){
         return "page1";
      }else if(pageId.equals("2")){
         return "page2";
      }else{
         return "index";
      }     
   }

   public String getPageId() {
      return pageId;
   }

   public void setPageId(String pageId) {
      this.pageId = pageId;
   }
}
