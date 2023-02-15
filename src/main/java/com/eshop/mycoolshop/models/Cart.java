package com.eshop.mycoolshop.models;

import jakarta.persistence.*;


import java.util.Objects;
@Table(name="cart")
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private Double price;
    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    public Cart() {
    }

    public Cart(String id, String title, Double price, String description, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "shoppingcart.html{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) && Objects.equals(title, cart.title) && Objects.equals(price, cart.price) && Objects.equals(description, cart.description) && Objects.equals(image, cart.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, description, image);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}