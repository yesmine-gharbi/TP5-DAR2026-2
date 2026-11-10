package rmiServer;

import java.rmi.registry.LocateRegistry;
import javax.naming.Context;
import javax.naming.InitialContext;

import rmiService.BanqueImpl;

public class BanqueServer {

    public static void main(String[] args) {

        try {

            // Création du registre RMI
            LocateRegistry.createRegistry(1099);

            // Création du service bancaire
            BanqueImpl banque = new BanqueImpl();

            // Création du contexte JNDI
            Context context = new InitialContext();

            // Enregistrement de l'objet distant
            context.rebind("Banque", banque);

            System.out.println("Serveur bancaire démarré !");
            System.out.println("Objet enregistré avec JNDI !");
            System.out.println("En attente des clients...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
