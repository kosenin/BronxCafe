package com.kosenin.boston.bronxcafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class SandwichActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich);

        Intent intent = getIntent();
        String TYPE = intent.getStringExtra("TypeSandwich");

        BackendlessData.setType(TYPE);

        FoodAdapter foodAdapterSandwich = new FoodAdapter();

        RecyclerView foodRecyclerView = findViewById(R.id.sandwich_recycler_view);
        foodRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        foodRecyclerView.setAdapter(foodAdapterSandwich);
    }
}
