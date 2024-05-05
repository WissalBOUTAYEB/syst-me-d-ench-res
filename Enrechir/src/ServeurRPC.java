import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.HashMap;
import java.util.Map;

public class ServeurRPC extends UnicastRemoteObject implements InterfaceRPC {
    private Map<Integer, String> produits;
    private Map<Integer, Double> encheres;

    protected ServeurRPC() throws RemoteException {
        super();
        produits = new HashMap<>();
        encheres = new HashMap<>();

        produits.put(1, "Television");
        produits.put(2, "Smart_phone");
        encheres.put(1, 7000.0);
        encheres.put(2, 3000.0);
    }

    public String afficherListeProduits() throws RemoteException {
    StringBuilder listeProduits = new StringBuilder("Liste des produits :\n");
    produits.forEach((idProduit, nomProduit) -> {
        listeProduits.append("ID : ").append(idProduit).append(", Nom : ").append(nomProduit).append("\n");
    });
    return listeProduits.toString();
}

    public void demanderEnchere(int idProduit, int idUtilisateur, double montant) throws RemoteExcep>
        System.out.println("Enchère reçue pour le produit avec l'ID : " + idProduit + " de l'utilisa>
    }

    public boolean accepterProduit(int idProduit) throws RemoteException {

        return true; 
    }

    public void confirmerVente(int idProduit) throws RemoteException {

        System.out.println("Produit avec l'ID : " + idProduit + " vendu !");
    }
public static void main(String[] args) {
        try {
            ServeurRPC serveur = new ServeurRPC();
            Registry registry=LocateRegistry.createRegistry(1099);
            registry.rebind("ServeurRPC",serveur);
            System.out.println("Serveur démarré.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
