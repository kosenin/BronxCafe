package com.kosenin.boston.bronxcafe;

import android.content.Context;

import com.backendless.Backendless;

public class BackendlessSettings {

    public static final String ANDROIDAPIKEY = "92AFA655-0BAC-D40E-FFA5-1E919AEBA700";
    public static final String APPLICATIONID = "A185213B-6F54-68F3-FFF1-177E5EA99D00";

    public static void BackendlessInit(Context context) {
        Backendless.initApp(context, APPLICATIONID, ANDROIDAPIKEY);
    }

}
