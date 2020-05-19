package com.example.mizatawsil;

public class magasin {
    private String nom;

    private magasin() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public magasin(String nom) {
        this.nom = nom;
    }
}
