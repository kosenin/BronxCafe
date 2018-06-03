package com.kosenin.boston.bronxcafe.Model;


import com.orm.SugarRecord;

import java.util.Date;

public class Order {

    private long orderNumber;
    private String userPhone;
    private String objectID;
    private Date created;

    public Order() {

    }

    public Order(long orderNumber, String userPhone) {
        this.orderNumber = orderNumber;
        this.userPhone = userPhone;

    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


}
