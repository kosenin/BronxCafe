package com.kosenin.boston.bronxcafe;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class Food {


    public static final String TABLE = "food";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_PICTURE = "picture";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";

    private String objectId;
    private String type;
    private String ownerId;
    private java.util.Date updated;
    private Integer price;
    private String picture;
    private String name;
    private String description;
    private java.util.Date created;

    public String getObjectId() {
        return objectId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public java.util.Date getUpdated() {
        return updated;
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

    public java.util.Date getCreated() {
        return created;
    }


    public Food save() {
        return Backendless.Data.of(Food.class).save(this);
    }

    public void saveAsync(AsyncCallback<Food> callback) {
        Backendless.Data.of(Food.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(Food.class).remove(this);
    }

    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(Food.class).remove(this, callback);
    }

    public static Food findById(String id) {
        return Backendless.Data.of(Food.class).findById(id);
    }

    public static void findByIdAsync(String id, AsyncCallback<Food> callback) {
        Backendless.Data.of(Food.class).findById(id, callback);
    }

    public static Food findFirst() {
        return Backendless.Data.of(Food.class).findFirst();
    }

    public static void findFirstAsync(AsyncCallback<Food> callback) {
        Backendless.Data.of(Food.class).findFirst(callback);
    }

    public static Food findLast() {
        return Backendless.Data.of(Food.class).findLast();
    }

    public static void findLastAsync(AsyncCallback<Food> callback) {
        Backendless.Data.of(Food.class).findLast(callback);
    }

    public static List<Food> find(DataQueryBuilder queryBuilder) {
        return Backendless.Data.of(Food.class).find(queryBuilder);
    }

    public static void findAsync(DataQueryBuilder queryBuilder, AsyncCallback<List<Food>> callback) {
        Backendless.Data.of(Food.class).find(queryBuilder, callback);
    }
}
