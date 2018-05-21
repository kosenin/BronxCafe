package com.kosenin.boston.bronxcafe;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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

    List<Food> foodList;


    private static String TYPE;

    public static void setType(String type)
    {
        TYPE = type;
    }




    public static void BackendlessInit(Context context) {
        Backendless.initApp(context, APPLICATIONID, ANDROIDAPIKEY);
    }

    @Override
    protected List<Food> doInBackground(Object[] objects) {


        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setWhereClause(TYPE);

        foodList = Backendless.Data.of(Food.class).find(queryBuilder);


        return foodList;
    }


}


