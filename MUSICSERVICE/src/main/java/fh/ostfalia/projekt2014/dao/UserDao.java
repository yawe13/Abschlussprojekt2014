/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.dao;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mettbrötchen
 */
public class UserDao {

    private static UserDao instance = null;
    private static String adress = "rmi://localhost:1099/rmifi";
    private static UserDaoLocal udl = null;

    public static UserDao getInstance() {
        if (instance == null) {
            try {
                instance = new UserDao();
                System.out.println("LOOKUPP;:"+Naming.lookup(adress));
                udl = (UserDaoLocal) Naming.lookup(adress);
                
            } catch (NotBoundException ex) {
                Logger.getLogger(Mp3ArtistDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Mp3ArtistDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(Mp3ArtistDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public UserDaoLocal getRmiFacade() {

        return udl;
    }
}
