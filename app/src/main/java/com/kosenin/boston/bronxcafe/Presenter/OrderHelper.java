package com.kosenin.boston.bronxcafe.Presenter;

import android.util.Log;


import com.kosenin.boston.bronxcafe.Model.Food;
import com.kosenin.boston.bronxcafe.Model.Order;
import com.kosenin.boston.bronxcafe.Model.OrderNumberGenerator;
import com.kosenin.boston.bronxcafe.Model.OrderedProducts;

import java.util.ArrayList;
import java.util.List;

public class OrderHelper {

    static OrderNumberGenerator orderNumberGenerator;
    private static List<OrderedProducts> orders = new ArrayList();


    public static List getOrders() {
        return orders;
    }

    public static void setOrders(OrderedProducts orderedProducts) {
        orders.add(orderedProducts);
        Log.e("order orderhelper", "setOrders: " + String.valueOf(orders.size()));
     //   orderedProducts.save();
    }

    public static void saveOrdersToDB() {


    }

}
