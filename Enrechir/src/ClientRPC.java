public class ClientRPC {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java ClientEnchere <nom_client> <montant_enchere>");
            System.exit(1);
        }

        String serverAddress = args[0];
        String nomClient = args[1];
        double montantEnchere = Double.parseDouble(args[2]);

        try {
            Registry registry = LocateRegistry.getRegistry(serverAddress, 1099);
            InterfaceRPC serveur = (InterfaceRPC) registry.lookup("ServeurRPC");

            System.out.println(serveur.afficherProduit());

            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez l'ID du produit : ");
            int idProduit = scanner.nextInt();

            System.out.print("Entrez votre ID utilisateur : ");
            int idUtilisateur = scanner.nextInt();

            System.out.print("Entrez le montant de votre enchère : ");
            double montant = scanner.nextDouble();

            serveur.demanderEnchere(idProduit, idUtilisateur, montant);

            boolean produitAccepte = serveur.accepterProduit(idProduit);
            if (produitAccepte) {
                serveur.confirmerVente(idProduit);
            } else {
                System.out.println("Le produit n'a pas été accepté.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}