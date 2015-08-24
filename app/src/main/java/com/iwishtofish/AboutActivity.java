package com.iwishtofish;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.Palette.Swatch;
import android.widget.TextView;

import com.iwishtofish.utils.AppUtil;

/**
 * Created by Kursulla on 23/08/15.
 */
public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView version = (TextView)findViewById(R.id.app_version);
        version.setText("Application version: "+ AppUtil.appVersion(this)+" ("+AppUtil.appCode(this)+")");

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.about_image);
        Palette palette = Palette.from(bitmap).generate();
        Swatch vibrant = palette.getDarkVibrantSwatch();
        if (vibrant != null) {
            setStatusBarColor(vibrant.getRgb());
        }
    }

    @Override
    protected void _getViewReferences() {

    }

    @Override
    protected void _getBundledData() {
        //No bundled data here
    }

    @Override
    protected void _loadData() {

    }
}
