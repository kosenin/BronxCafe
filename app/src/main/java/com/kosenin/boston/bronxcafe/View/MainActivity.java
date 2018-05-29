package com.kosenin.boston.bronxcafe.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kosenin.boston.bronxcafe.Model.BackendlessData;
import com.kosenin.boston.bronxcafe.Model.DateRepo;
import com.kosenin.boston.bronxcafe.R;

public class MainActivity extends AppCompatActivity {

    DateRepo dataRepository;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();

        BackendlessData.BackendlessInit(getApplicationContext());

        dataRepository = new DateRepo();
        dataRepository.setContext(mContext);
        dataRepository.getDataToRepresent();

        Log.e("DB ex", String.valueOf(DateRepo.doesDatabaseExist(this, "food.db")));

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
