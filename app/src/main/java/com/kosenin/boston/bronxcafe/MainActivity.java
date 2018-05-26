package com.kosenin.boston.bronxcafe;

import android.content.ContentValues;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BackendlessData.BackendlessInit(getApplicationContext());

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

        FoodHelper foodHelper = new FoodHelper(this);
        SQLiteDatabase db = foodHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Food.COLUMN_DESCRIPTION, "Охуенный сандвич");
        values.put(Food.COLUMN_NAME, "Cold Fusion");
        values.put(Food.COLUMN_PRICE, "120");
        values.put(Food.COLUMN_PICTURE, "No picture yet");
        values.put(Food.COLUMN_TYPE, "sandwich");

        Log.e("DB", String.valueOf(db.getVersion()));


   /*     db.insert(Food.TABLE, null, values);


     Cursor cursor = db.query(Food.TABLE, null, null, null, null, null, null);


        if (cursor != null) {
            if (cursor.moveToFirst()) {
                String title = cursor.getString(cursor
                        .getColumnIndexOrThrow(Food.COLUMN_NAME));
                Log.i("DB", title);
            }
            cursor.close();
        }

*/


    }


}
