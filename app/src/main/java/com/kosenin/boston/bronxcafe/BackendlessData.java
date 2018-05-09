package com.kosenin.boston.bronxcafe;

import android.app.Application;
import android.content.Context;

import com.backendless.Backendless;

import java.util.List;

import static com.kosenin.boston.bronxcafe.BackendlessSettings.ANDROIDAPIKEY;
import static com.kosenin.boston.bronxcafe.BackendlessSettings.APPLICATIONID;

public class BackendlessData {

    public static void BackendlessInit(Context context)
    {
        Backendless.initApp(context, APPLICATIONID, ANDROIDAPIKEY);
    }

    public static List getBackendlessData(String queryClause, List list)
    {
        if (queryClause==null)
        {

        }
        return list;
    }
}
