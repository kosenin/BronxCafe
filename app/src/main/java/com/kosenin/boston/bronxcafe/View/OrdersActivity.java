package com.kosenin.boston.bronxcafe.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.kosenin.boston.bronxcafe.Model.Food;
import com.kosenin.boston.bronxcafe.Presenter.FoodAdapter;
import com.kosenin.boston.bronxcafe.Presenter.OrderAdapter;
import com.kosenin.boston.bronxcafe.R;

import java.util.ArrayList;
import java.util.List;

public class OrdersActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);


        RecyclerView ordersRecycler = findViewById(R.id.orders_recycler_view);
        ordersRecycler.setLayoutManager(new LinearLayoutManager(this));

        OrderAdapter orderAdapter = new OrderAdapter(this);


        ordersRecycler.setAdapter(orderAdapter);
        orderAdapter.notifyDataSetChanged();


    }
}
