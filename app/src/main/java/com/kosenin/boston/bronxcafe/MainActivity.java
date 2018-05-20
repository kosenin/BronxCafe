package com.kosenin.boston.bronxcafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.DataQueryBuilder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.kosenin.boston.bronxcafe.BackendlessSettings.ANDROIDAPIKEY;
import static com.kosenin.boston.bronxcafe.BackendlessSettings.APPLICATIONID;

public class MainActivity extends AppCompatActivity {

    List<Food> foodDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BackendlessData.BackendlessInit(getApplicationContext());

        try {
            foodDataList = (List) new BackendlessData().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        Log.e("BackendlessActivity", String.valueOf(foodDataList.size()));

    }


}
