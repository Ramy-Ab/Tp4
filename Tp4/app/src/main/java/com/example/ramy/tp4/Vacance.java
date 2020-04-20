package com.example.ramy.tp4;

/**
 * Created by Ramy on 4/20/2020.
 */

public class Vacance {
    String titre, description;
    int idImage;

    public Vacance(String titre, String description, int idImage) {
        this.titre = titre;
        this.description = description;
        this.idImage=idImage;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }
}
