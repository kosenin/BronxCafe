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

import static com.kosenin.boston.bronxcafe.BackendlessSettings.ANDROIDAPIKEY;
import static com.kosenin.boston.bronxcafe.BackendlessSettings.APPLICATIONID;

public class MainActivity extends AppCompatActivity {

    List<Food> foodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BackendlessData.BackendlessInit(getApplicationContext());


        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setWhereClause("type = 'roll'");

        Backendless.Data.of(Food.class).find(queryBuilder, new AsyncCallback<List<Food>>() {
            @Override
            public void handleResponse(List<Food> response) {


                //TODO DB cache of response


                TextView textView1 = findViewById(R.id.name);
                TextView textView2 = findViewById(R.id.description);
                ImageView imageView1 = findViewById(R.id.picture);


                textView1.setText(response.get(0).getName());
                textView2.setText(response.get(0).getDescription());
                Picasso.get().load(response.get(0).getPicture()).into(imageView1);

                Log.e("Backendless Response..", "response.." + response.size());
                Log.e("Backendless Response..", "foodlist.." + foodList.size());
            }


            @Override
            public void handleFault(BackendlessFault fault) {
                Log.e("Backendless Response..", "FUCK");
            }
        });

    }


}
