package com.kosenin.boston.bronxcafe.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kosenin.boston.bronxcafe.Model.Food;
import com.kosenin.boston.bronxcafe.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private List<Food> orderedFood = OrderHelper.getOrders();
    private Context mContext;

    public OrderAdapter(Context context) {

        this.mContext = context;
    }


    public class OrderViewHolder extends RecyclerView.ViewHolder {

        private ImageView food_image;
        private TextView name;
        private TextView description;
        private TextView price;


        public OrderViewHolder(View itemView) {
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
    public void onBindViewHolder(OrderAdapter.OrderViewHolder holder, int position, List payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public OrderAdapter.OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderAdapter.OrderViewHolder holder, int position) {
        holder.bind(orderedFood.get(position));
    }



    @Override
    public int getItemCount() {
        return orderedFood.size();
    }


}
