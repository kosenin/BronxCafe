package com.kosenin.boston.bronxcafe;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

    DateRepo dataRepository;

    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();



        BackendlessData.BackendlessInit(getApplicationContext());

        dataRepository = new  DateRepo();
        dataRepository.setContext(mContext);
        dataRepository.getDataToRepresent();

        Log.e("DB ex", String.valueOf(DateRepo.databaseExist()));

        Button sandwichesButton = findViewById(R.id.sandwiches_button);
        Button rollButton = findViewById(R.id.roll_button);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Roll.class);
                intent.putExtra("TypeRoll", "type = 'roll'");
                startActivity(intent);

            }
        });

        sandwichesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SandwichActivity.class);
                intent.putExtra("TypeSandwich", "type = 'sandwich'");
                startActivity(intent);

            }
        });


    }

}
