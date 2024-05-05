import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRPC extends Remote {
    String afficherProduit() throws RemoteException;
    void demanderEnchere(int idProduit, int idUtilisateur, double montantEnchere) throws RemoteExcep>
    boolean accepterProduit(int idProduit) throws RemoteException;
    void confirmerVente(int idProduit) throws RemoteException;
}
