package com.kosenin.boston.bronxcafe.Model;

import android.content.Context;
import android.os.AsyncTask;

import com.backendless.Backendless;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

import static com.kosenin.boston.bronxcafe.Model.BackendlessSettings.ANDROIDAPIKEY;
import static com.kosenin.boston.bronxcafe.Model.BackendlessSettings.APPLICATIONID;


public class BackendlessData extends AsyncTask<List, Void, List> {

    List<Food> foodList;


    public static void BackendlessInit(Context context) {
        Backendless.initApp(context, APPLICATIONID, ANDROIDAPIKEY);
    }


    @Override
    protected List doInBackground(List... lists) {

        DataQueryBuilder queryBuilder = DataQueryBuilder.create();

        queryBuilder.setPageSize(22);

        foodList = Backendless.Data.of(Food.class).find(queryBuilder);

        return foodList;
    }
}


