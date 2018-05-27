package com.kosenin.boston.bronxcafe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FoodHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "food.db";
    public static final String DB_PATH = "/data/data/com.kosenin.boston.bronxcafe/databases/food.db";
    public static final int DB_VERSION = 1;

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + Food.TABLE + " (_id integer primary key autoincrement,"
            + " name text," + " price text," + " description text," + " type text," + "picture text," + "udpated text)";

    public FoodHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
}
