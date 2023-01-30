package com.example.cvecaraprojekat.project.Activity.Domain;

import java.io.Serializable;

public class FlowerDomain implements Serializable {
    private String pic;
    private String title;
    private String description;
    private Double fee;
    private  int numberInCart;

    public FlowerDomain(String title,String pic,  String description, Double fee) {
        this.pic = pic;
        this.title = title;
        this.description = description;
        this.fee = fee;
    }

    public FlowerDomain(String title, String pic, String description, Double fee, int numberInCart) {
        this.pic = pic;
        this.title = title;
        this.description = description;
        this.fee = fee;
        this.numberInCart = numberInCart;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
