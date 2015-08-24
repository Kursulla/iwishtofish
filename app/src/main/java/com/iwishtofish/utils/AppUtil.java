package com.iwishtofish.utils;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION_CODES;

/**
 * Created by Kursulla on 23/08/15.
 */
public class AppUtil {
    public static boolean isAfterLollipop(){
        return android.os.Build.VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP;
    }
    public static String appVersion(Activity activity){
        try {
            PackageInfo pInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0);
            return pInfo.versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return "unknown";
        }
    }

    public static int appCode(Activity activity) {
        try {
            PackageInfo pInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0);
            return pInfo.versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
