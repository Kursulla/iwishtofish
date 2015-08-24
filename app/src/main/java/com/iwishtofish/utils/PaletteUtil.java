package com.iwishtofish.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.Palette.Swatch;

import com.iwishtofish.R;

/**
 * Created by Kursulla on 24/08/15.
 */
public class PaletteUtil {
    public static int getVibrantColor(int imageResource, Activity activity){
        Bitmap bitmap = BitmapFactory.decodeResource(activity.getResources(), imageResource);
        Palette palette = Palette.from(bitmap).generate();

        Swatch vibrant = palette.getVibrantSwatch();
        if (vibrant != null) {
            return vibrant.getRgb();
        }else{
            return activity.getResources().getColor(R.color.primary);
        }
    }

    public static int getDarkVibrantColor(int imageResource, Activity activity) {
        Bitmap bitmap = BitmapFactory.decodeResource(activity.getResources(), imageResource);
        Palette palette = Palette.from(bitmap).generate();

        Swatch vibrant = palette.getDarkVibrantSwatch();
        if (vibrant != null) {
            return vibrant.getRgb();
        } else {
            return activity.getResources().getColor(R.color.primary_dark);
        }
    }
}
