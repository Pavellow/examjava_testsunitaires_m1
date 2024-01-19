package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Tache tache = new Tache("tache 1", "desc1", false);
        ArrayList<Tache> taches = new ArrayList<>();
        GestionTache gt = new GestionTache(taches);
        gt.ajouterTache("aa", "bb");
        gt.ajouterClasseTache(tache);

        gt.verifierTache("tache 1");

    }
}