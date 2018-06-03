package com.kosenin.boston.bronxcafe.Model;

import com.orm.SugarRecord;

import java.util.Date;
import java.util.List;

public class OrderedProducts{


    private Order order;
    private Food food;
    private int quantity;
    private Date created;
    private String objectId;

    public OrderedProducts() {

    }

    public OrderedProducts(Order orders, Food food) {
        this.order = orders;
        this.food = food;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }


}
