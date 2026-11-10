package rmiClient;

import javax.naming.Context;
import javax.naming.InitialContext;

import metier.Compte;
import rmiService.IBanque;

public class BanqueClient {

    public static void main(String[] args) {

        try {

            // Création du contexte JNDI
            Context context = new InitialContext();

            // Recherche de l'objet distant
            IBanque banque = (IBanque) context.lookup("Banque");

            // Création d'un compte
            Compte c1 = new Compte(100, 5000);

            System.out.println(banque.creerCompte(c1));

            // Consultation du compte
            System.out.println(banque.getInfoCompte(100));

            // Test avec un code déjà existant
            System.out.println(banque.creerCompte(c1));

            // Test avec un compte inexistant
            System.out.println(banque.getInfoCompte(200));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
