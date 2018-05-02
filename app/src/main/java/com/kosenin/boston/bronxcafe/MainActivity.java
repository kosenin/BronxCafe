package com.kosenin.boston.bronxcafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.DataQueryBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.kosenin.boston.bronxcafe.BackendlessSettings.ANDROIDAPIKEY;
import static com.kosenin.boston.bronxcafe.BackendlessSettings.APPLICATIONID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Backendless.initApp(getApplicationContext(), APPLICATIONID, ANDROIDAPIKEY);

        List<Food> foodList=new ArrayList<>();
        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setWhereClause("type = 'roll'");

        Backendless.Data.of(Food.class).find(queryBuilder, new AsyncCallback<List<Food>>() {
            @Override
            public void handleResponse(List<Food> response) {
                Log.e("Backendless Response..","no of object.."+response.size());
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.e("Backendless Response..","FUCK");
            }
        });

    }
}
