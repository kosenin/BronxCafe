package com.kosenin.boston.bronxcafe;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.persistence.DataQueryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.kosenin.boston.bronxcafe.BackendlessSettings.ANDROIDAPIKEY;
import static com.kosenin.boston.bronxcafe.BackendlessSettings.APPLICATIONID;


public class BackendlessData extends AsyncTask {

    List<Food> foodList = new ArrayList<>();

    public static final String TYPE_ROLL = "type = 'roll'";
    public static final String TYPE_SANDWICH = "type = 'sandwich'";
    public static final String TYPE_DRINK = "type = 'drink'";


    public static void BackendlessInit(Context context) {
        Backendless.initApp(context, APPLICATIONID, ANDROIDAPIKEY);
    }

    @Override
    protected List<Food> doInBackground(Object[] objects) {


        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setWhereClause(TYPE_ROLL);

        foodList = Backendless.Data.of(Food.class).find(queryBuilder);
      //  Log.e("BackendlessAsync", String.valueOf(foodList.size()));

        return foodList;
    }


}


