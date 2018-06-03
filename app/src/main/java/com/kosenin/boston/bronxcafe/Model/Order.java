package com.kosenin.boston.bronxcafe.Model;


import java.util.Date;

public class Order {

    private String type;
    private Integer price;
    private String picture;
    private String name;
    private String description;
    private java.util.Date created;

    public Order() {

    }

    public Order(String type, Integer price, String picture, String name, String description, Date created) {
        this.type = type;
        this.price = price;
        this.picture = picture;
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
