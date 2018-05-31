package com.kosenin.boston.bronxcafe.Model;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.DataQueryBuilder;
import com.orm.SugarRecord;

import java.util.Date;
import java.util.List;

public class Food extends SugarRecord<Food> {


    private String type;
    private Integer price;
    private String picture;
    private String name;
    private String description;
    private java.util.Date created;

    public Food() {

    }

    public Food(String type, int price, String picture, String name, String description, Date created) {
        this.created = created;
        this.description = description;
        this.type = type;
        this.price = price;
        this.picture = picture;
        this.name = name;


    }


    /*  public String getObjectId() {
          return objectId;
      }
  */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /* public String getOwnerId() {
        return ownerId;
    } */

    /*  public java.util.Date getUpdated() {
          return updated;
      }
  */
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
