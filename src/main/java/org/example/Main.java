package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        ArrayList<Tache> taches = new ArrayList<Tache>();
        Projet projet = new Projet("projet1", taches);
        GestionTache gt = new GestionTache(projet);

        gt.ajouterTache("tache1", "description1");

        System.out.println(projet.getTaches());

    }
}