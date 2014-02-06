/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.webserver;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Yannick
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

  private String username;
  private String password;

  public String getUsername() {
    return this.username;
  }

  public void setUserName(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  public String login () {
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request;
      request = (HttpServletRequest) context.getExternalContext().getRequest();
    try {
      request.login(this.username, this.password);
    } catch (ServletException e) {
   
      context.addMessage(null, new FacesMessage("Login failed."));
      return "error";
    }
    return "admin/index";
  }

  public void logout() {
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest)
        context.getExternalContext().getRequest();
    try {
      request.logout();
    } catch (ServletException e) {
  
      context.addMessage(null, new FacesMessage("Logout failed."));
    }
  }
}
