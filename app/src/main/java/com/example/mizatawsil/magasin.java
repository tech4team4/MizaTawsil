package com.example.mizatawsil;

public class magasin {
    private String name, imageURL;

    public magasin() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public magasin(String name, String imageURL) {
        this.name = name;
        this.imageURL = imageURL;
    }
}
