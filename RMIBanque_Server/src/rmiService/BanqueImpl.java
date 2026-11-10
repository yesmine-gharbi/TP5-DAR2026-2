package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import metier.Compte;

public class BanqueImpl extends UnicastRemoteObject implements IBanque {

    private Map<Integer, Compte> comptes;

    public BanqueImpl() throws RemoteException {
        comptes = new HashMap<Integer, Compte>();
    }

    @Override
    public String creerCompte(Compte c) throws RemoteException {

        if (comptes.containsKey(c.getCode())) {
            return "Erreur : ce compte existe déjà !";
        }

        comptes.put(c.getCode(), c);

        return "Compte créé avec succès !";
    }

    @Override
    public String getInfoCompte(int code) throws RemoteException {

        if (comptes.containsKey(code)) {
            return comptes.get(code).toString();
        }

        return "Erreur : compte introuvable !";
    }
}
