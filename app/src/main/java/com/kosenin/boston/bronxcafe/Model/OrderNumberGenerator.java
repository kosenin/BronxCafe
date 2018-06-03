package com.kosenin.boston.bronxcafe.Model;

import java.util.Date;

public class OrderNumberGenerator {

    static Date date = java.util.Calendar.getInstance().getTime();

    public static long orderNumber()
    {
        return date.getTime();
    }

}
