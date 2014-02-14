/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.webserver;

import fh.ostfalia.projekt2014.dao.UserDao;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author KingDCB
 */
public class Jndi {

   
    Hashtable env = new Hashtable();
    String name = new String();
    LoginBean client = new LoginBean();
    
    public void jndi() {
        
       
        name="test";
        try {
            
            env.put(Context.INITIAL_CONTEXT_FACTORY,
                    "com.sun.jndi.fscontext.RefFSContextFactory");

            Context ctx = new InitialContext(env);
            ctx.bind("loginBean", client);

            //Object obj = ctx.lookup(name);

            // Print it
            //System.out.println(name + " is bound to: " + obj);

        } catch (NamingException e) {
            System.err.println("Problem looking up " + name + ": " + e);
        }
    }
}
