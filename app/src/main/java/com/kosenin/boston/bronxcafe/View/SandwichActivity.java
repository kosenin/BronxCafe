package com.kosenin.boston.bronxcafe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kosenin.boston.bronxcafe.Model.Food;
import com.kosenin.boston.bronxcafe.Presenter.FoodAdapter;
import com.kosenin.boston.bronxcafe.R;

import java.util.ArrayList;
import java.util.List;

public class SandwichActivity extends AppCompatActivity {

    private List<Food> orderedItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich);
        orderedItems = new ArrayList<>();


        Intent intent = getIntent();
        String FOODTYPE = intent.getStringExtra("TypeSandwich");


        FoodAdapter foodAdapterSandwich = new FoodAdapter( orderedItems, FOODTYPE, this);


        RecyclerView foodRecyclerView = findViewById(R.id.sandwich_recycler_view);
        foodRecyclerView.setLayoutManager(new LinearLayoutManager(this));




        foodRecyclerView.setAdapter(foodAdapterSandwich);
        foodAdapterSandwich.notifyDataSetChanged();
    }


}
