package impl;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Forum extends Remote {
public int entrer(proxy pr) throws RemoteException;
public void dire(int id, String msg) throws RemoteException;
public String qui() throws RemoteException;
public void quiter(int id) throws RemoteException;
}
