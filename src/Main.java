import impl.Forum;
import impl.ForumImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Main {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        // port 1245 is used by the server
        int port= 1245;
        // create the registry
        LocateRegistry.createRegistry(port);
        System.out.println("RMI registry ready.");
        Forum forum = new ForumImpl();
        // bind the forum to the registry
        Naming.rebind(String.format("rmi://localhost:%s/forum",port), forum);
        System.out.println("forum has been rebinded!");
    }
}