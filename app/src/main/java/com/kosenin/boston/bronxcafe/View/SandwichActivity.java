package com.kosenin.boston.bronxcafe.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import com.kosenin.boston.bronxcafe.Model.BackendlessData;
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

        Intent intent = getIntent();
        String FOODTYPE = intent.getStringExtra("TypeSandwich");
         orderedItems = new ArrayList<>();

        FoodAdapter foodAdapterSandwich = new FoodAdapter(FOODTYPE, orderedItems);




        RecyclerView foodRecyclerView = findViewById(R.id.sandwich_recycler_view);
        foodRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //TODO Do here implementation of OnClick. Look to GitHub

        foodRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        foodRecyclerView.setAdapter(foodAdapterSandwich);
        foodAdapterSandwich.notifyDataSetChanged();
    }
}
