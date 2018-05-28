package com.kosenin.boston.bronxcafe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.ExecutionException;


import javax.security.auth.login.LoginException;

import static com.kosenin.boston.bronxcafe.FoodHelper.DB_PATH;

public class DateRepo {

    private Context mContext;

    public Context setContext(Context context) {
        mContext = context;
        return mContext;

    }

    List<Food> foodDataList;


    public void getDataToRepresent() {

        BackendlessData.BackendlessInit(mContext);

        FoodHelper foodHelper = new FoodHelper(mContext);
        SQLiteDatabase db = foodHelper.getWritableDatabase();

        try {
            foodDataList = (List) new BackendlessData().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < foodDataList.size(); i++) {

            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            String created = formatter.format(foodDataList.get(i).getCreated());
            Log.e("DB_upd", "getDataToRepresent: " + created);


            ContentValues contentValues = convertDataToContentValues(foodDataList.get(i).getName(), foodDataList.get(i).getDescription(), foodDataList.get(i).getType(), foodDataList.get(i).getPicture(), String.valueOf(foodDataList.get(i).getPrice()), created);
            db.insertWithOnConflict(Food.TABLE, null, contentValues, SQLiteDatabase.CONFLICT_REPLACE);


        }


        Cursor cursor = db.query(Food.TABLE, null, null, null, null, null, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                String title = cursor.getString(cursor.getColumnIndexOrThrow(Food.COLUMN_NAME));
                Log.e("DB", title);
            }
            cursor.close();
        }


    }


    public ContentValues convertDataToContentValues(String name, String description, String type, String picture, String price, String created) {

        ContentValues values = new ContentValues();
        values.put(Food.COLUMN_DESCRIPTION, description);
        values.put(Food.COLUMN_NAME, name);
        values.put(Food.COLUMN_PRICE, price);
        values.put(Food.COLUMN_PICTURE, picture);
        values.put(Food.COLUMN_TYPE, type);
        values.put(Food.COLUMN_CREATED, created);

        return values;
    }

    public static boolean databaseExist() {
        SQLiteDatabase checkDB = null;
        try {
            checkDB = SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READONLY);
            checkDB.close();
            return true;
        } catch (SQLiteException e) {
            // Log an info message stating database doesn't exist.
        }

        return false;
    }
}
