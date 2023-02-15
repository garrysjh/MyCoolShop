package com.eshop.mycoolshop.models;

import jakarta.persistence.*;


import java.util.Objects;
@Table(name="listings")
@Entity
public class Listing {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="title")
    private String title;
    @Column(name="price")
    private Double price;
    @Column(name="description")
    private String description;

    @Column(name="image")
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Listing(){

    }
    public Listing(String id, String title, Double price, String description) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Listing listing = (Listing) o;
        return Objects.equals(id, listing.id) && Objects.equals(title, listing.title) && Objects.equals(price, listing.price) && Objects.equals(description, listing.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, description);
    }

}
