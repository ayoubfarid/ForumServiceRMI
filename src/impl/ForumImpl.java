package impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

public class ForumImpl extends UnicastRemoteObject implements Forum {
    // users is a hashtable that contains all the users in the forum
    Hashtable<Integer, proxy> users ;
    // id is the id of the user
    public static int id = 0;
    // constructor
    public ForumImpl() throws RemoteException {
        users = new Hashtable<Integer, proxy>();
    }
    // entrer method is used to add a user to the forum
    @Override
    public int entrer(proxy pr) throws RemoteException {
        id++;
        users.put(id, pr);
        return id;
    }
    // dire method is used to send a message to all the users in the forum
    @Override
    public void dire(int id, String msg) throws RemoteException {
        for (Integer i : users.keySet()   ) {
            if (i != id){
                System.out.println("id: " + i);
                users.get(i).ecouter(msg);
            }
        }
    }
    // qui method is used to get all the users in the forum
    @Override
    public String qui() throws RemoteException {
        String s = "";
        for (Integer i : users.keySet()) {
            s += i.toString() + " ";
        }
        return s;
    }
    // quiter method is used to remove a user from the forum
    @Override
    public void quiter(int id) throws RemoteException {
        users.remove(id);
    }

}
