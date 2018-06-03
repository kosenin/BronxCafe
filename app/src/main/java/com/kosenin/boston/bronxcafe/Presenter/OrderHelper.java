package com.kosenin.boston.bronxcafe.Presenter;

import android.util.Log;

import com.kosenin.boston.bronxcafe.Model.Food;

import java.util.ArrayList;
import java.util.List;

public  class OrderHelper {

    private static List orders = new ArrayList();


    public static List getOrders() {
        return orders;
    }

    public static void setOrders(Food food) {
        orders.add(food);
        Log.e("order orderhelper", "setOrders: " + String.valueOf(orders.size()));
    }


}
