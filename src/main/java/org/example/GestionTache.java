package org.example;

import java.util.ArrayList;

public class GestionTache {
    ArrayList<Tache> taches = new ArrayList<Tache>();

    public GestionTache(ArrayList<Tache> tachesParam) {
        this.taches = tachesParam;
    }

    public boolean ajouterTache(String titreTache, String descriptionTache) {
        return taches.add(new Tache(titreTache, descriptionTache, false));
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
