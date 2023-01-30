package com.example.cvecaraprojekat.project.Activity.Domain;

public class CategoryDomain {
    private String naslov;
    private String slika;

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public CategoryDomain(String naslov, String slika){
        this.naslov=naslov;
        this.slika=slika;

    }
}
