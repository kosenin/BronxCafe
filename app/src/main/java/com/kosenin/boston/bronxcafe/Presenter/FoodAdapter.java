package com.kosenin.boston.bronxcafe.Presenter;


import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kosenin.boston.bronxcafe.Model.Food;
import com.kosenin.boston.bronxcafe.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {


    List<Food> foodDataList;

    public FoodAdapter(String foodtype) {
        this.foodDataList = Food.findWithQuery(Food.class, "Select * from Food where type = ?", foodtype);

    }


    public class FoodViewHolder extends RecyclerView.ViewHolder {


        private ImageView food_image;
        private TextView name;
        private TextView description;
        private TextView price;
        private ArrayList<Food> orderedItems;



        public FoodViewHolder(View itemView) {
            super(itemView);
            food_image = itemView.findViewById(R.id.food_image);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);

        }

        public void bind(Food food) {
            name.setText(food.getName());
            description.setText(food.getDescription());
            price.setText("Цена: " + String.valueOf(food.getPrice()));
            Picasso.get().load(String.valueOf(food.getPicture())).into(food_image);

        }

    }


    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);



        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FoodAdapter.FoodViewHolder holder, int position) {

        holder.bind(foodDataList.get(position));



    }

    @Override
    public int getItemCount() {
        return foodDataList.size();
    }
}
