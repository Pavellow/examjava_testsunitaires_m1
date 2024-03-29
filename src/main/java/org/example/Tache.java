package org.example;

public class Tache {
    private String titre;
    private String description;
    private boolean completee;

    public Tache(String titreParam, String description, boolean completeeParam) {
        this.titre = titreParam;
        this.description = description;
        this.completee = completeeParam;
    }

    public String toString() {
        return "Tache " + this.titre + " : " + this.description;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTitre() {
        return this.titre;
    }

    public boolean getStatus() {
        return this.completee;
    }

    public void setCompletee() {
        this.completee = true;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void switchStatus() {
        this.completee = !this.completee;
    }
}
