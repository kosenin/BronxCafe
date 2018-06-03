package com.kosenin.boston.bronxcafe.Presenter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.local.UserTokenStorageFactory;
import com.kosenin.boston.bronxcafe.Model.Food;
import com.kosenin.boston.bronxcafe.Model.Order;
import com.kosenin.boston.bronxcafe.Model.OrderNumberGenerator;
import com.kosenin.boston.bronxcafe.Model.OrderedProducts;
import com.kosenin.boston.bronxcafe.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {


    private List<Food> foodDataList;
    private Order order;
    private String userToken;


    private Context mContext;


    public FoodAdapter() {

    }


    public FoodAdapter(List<Food> orderedItems, String foodtype, Context context) {

     //   this.orderedItems = orderedItems;
        this.foodDataList = Food.findWithQuery(Food.class, "Select * from Food where type = ?", foodtype);
        this.mContext = context;

    }


    public class FoodViewHolder extends RecyclerView.ViewHolder {


        private ImageView food_image;
        private TextView name;
        private TextView description;
        private TextView price;


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
    public void onBindViewHolder(FoodAdapter.FoodViewHolder holder, final int position) {

        holder.bind(foodDataList.get(position));

       holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userToken = UserTokenStorageFactory.instance().getStorage().get();

                Backendless.UserService.findById(userToken, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {

                        Order order = new Order(OrderNumberGenerator.orderNumber(), response.getUserId());

                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {

                    }
                });
                OrderedProducts orderedProducts = new OrderedProducts(order, foodDataList.get(position));
                OrderHelper.setOrders(orderedProducts);

                //OrderHelper.setOrders(foodDataList.get(position));

                Toast toast = Toast.makeText(mContext, "В заказ добавлен: " + foodDataList.get(position).getName(), Toast.LENGTH_SHORT);
                toast.show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return foodDataList.size();
    }
}
