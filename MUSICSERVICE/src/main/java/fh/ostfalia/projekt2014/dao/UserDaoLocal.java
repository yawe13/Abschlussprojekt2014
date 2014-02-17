/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.dao;
;
import java.rmi.RemoteException;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author anton
 */

public interface UserDaoLocal extends Remote {

    void testRMI()throws RemoteException;
    
}
