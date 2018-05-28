package com.kosenin.boston.bronxcafe;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.DataQueryBuilder;
import com.backendless.persistence.QueryOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.kosenin.boston.bronxcafe.BackendlessSettings.ANDROIDAPIKEY;
import static com.kosenin.boston.bronxcafe.BackendlessSettings.APPLICATIONID;


public class BackendlessData extends AsyncTask<List, Void, List> {

    List<Food> foodList;


    private static String TYPE;

    public static void setType(String type) {
        TYPE = type;
    }


    public static void BackendlessInit(Context context) {
        Backendless.initApp(context, APPLICATIONID, ANDROIDAPIKEY);
    }


    @Override
    protected List doInBackground(List... lists) {

        DataQueryBuilder queryBuilder = DataQueryBuilder.create();


        queryBuilder.setWhereClause(TYPE).setPageSize(22);

        foodList = Backendless.Data.of(Food.class).find(queryBuilder);

        return foodList;
    }
}


