package com.kosenin.boston.bronxcafe.Model;

public class OrderNumberGenerator {



    private static long orderNumber;

    public static long getOrderNumber() {
        return orderNumber;
    }

    public static void setOrderNumber(long orderNumber) {
        OrderNumberGenerator.orderNumber = orderNumber;
    }

}
