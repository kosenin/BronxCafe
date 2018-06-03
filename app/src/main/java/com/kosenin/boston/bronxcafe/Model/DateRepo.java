package com.kosenin.boston.bronxcafe.Model;

import android.content.Context;


import com.backendless.Backendless;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.DataQueryBuilder;
import com.orm.QueryBuilder;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class DateRepo {

    Context mContext;

    public Context setContext(Context context) {
        mContext = context;
        return mContext;

    }

    List<Food> foodDataList;


    public void cacheData() {

        BackendlessData.BackendlessInit(mContext);

        try {
            foodDataList = (List) new BackendlessData().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (!doesDatabaseExist(mContext, "food.db")) {
            for (int i = 0; i < foodDataList.size(); i++) {
                saveFoodToDatabase(foodDataList.get(i).getType(), foodDataList.get(i).getPrice(), foodDataList.get(i).getPicture(), foodDataList.get(i).getName(), foodDataList.get(i).getDescription(), foodDataList.get(i).getCreated(), foodDataList.get(i).getObjectId());
            }
        }
    }

    private void saveFoodToDatabase(String type, int price, String picture, String name, String description, Date created, String objectId) {

        Food food = new Food(type, price, picture, name, description, created, objectId);
        food.save();
    }

    public static boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }


}
