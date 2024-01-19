package org.example;

import java.util.ArrayList;

public class GestionTache {

    private Projet projet;
    private ArrayList<Tache> taches;

    public GestionTache(Projet projetParam) {
        this.projet = projetParam;
        this.taches = projet.getTaches();
    }

    public boolean ajouterTache(String titreTache, String descriptionTache) {
        return taches.add(new Tache(titreTache, descriptionTache, false, 2.0));
    }

    public boolean ajouterClasseTache(Tache tache) {
        return taches.add(tache);
    }

    public boolean delTache(String titre) {
        for(Tache tache : taches) {
            if(tache.getTitre().equals(titre)) {
                this.taches.remove(tache);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Tache> getTaches() {
        return this.taches;
    }

    public void resetTaches() {
        this.taches.clear();
    }

    public int completerTache(String titre) {
        for(Tache tache : taches) {
            if(tache.getTitre().equals(titre)){
                tache.setCompletee();
                return 0;
            }
        }
        return -1;
    }

    public Tache verifierTache(String titre) {
        try {
            for(Tache tache : taches) {
                if (tache.getTitre().equals(titre)) {
                    return tache;
                }
            }
        } catch(Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }

}
