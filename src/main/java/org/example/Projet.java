package org.example;

import java.util.ArrayList;

public class Projet {
    private String nomProjet;
    private ArrayList<Tache> taches;

    public Projet(String nomParam, ArrayList<Tache> tachesParam) {
        this.nomProjet = nomParam;
        this.taches = tachesParam;
    }

    public ArrayList<Tache> getTaches() {
        return this.taches;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public void setTaches(ArrayList<Tache> taches) {
        this.taches = taches;
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

    public double calculerDureeTotale(ArrayList<Tache> taches) {
        double dureeTotale = 0.0;
        for(Tache tache : taches) {
            dureeTotale = dureeTotale + tache.getDuree();
        }
        return dureeTotale;
    }

}
