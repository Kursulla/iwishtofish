package com.iwishtofish.utils;

import android.os.Build.VERSION_CODES;

/**
 * Created by Kursulla on 23/08/15.
 */
public class OSUtil {
    public static boolean isAfterLollipop(){
        return android.os.Build.VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP;
    }
}
