/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014;

import javax.annotation.ManagedBean;

/**
 *
 * @author KingDCB
 */
@ManagedBean

public class User {
    
    public String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
