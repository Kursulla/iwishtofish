package com.iwishtofish;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.Palette.Swatch;
import android.view.Menu;
import android.widget.TextView;

import com.iwishtofish.utils.AppUtil;

/**
 * Created by Kursulla on 23/08/15.
 */
public class AboutActivity extends BaseActivity {

    private TextView version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        _getViewReferences();
        _initViews();
        _loadData();
    }

    @Override
    protected void _getViewReferences() {
        version = (TextView) findViewById(R.id.app_version);
    }

    @Override
    protected void _getBundledData() {
        //No bundled data here
    }

    @Override
    protected void _initViews() {
        super._initViews();

        if (AppUtil.isAfterLollipop()) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.about_image);
            Palette palette = Palette.from(bitmap).generate();

            Swatch vibrant = palette.getVibrantSwatch();
            Swatch vibrantDark = palette.getDarkVibrantSwatch();

            if (vibrant != null) {
                toolbar.setBackgroundColor(vibrant.getRgb());
            }
            if (vibrantDark != null) {
                setMajorColor(vibrantDark.getRgb());
            }
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void _loadData() {
        version.setText("Application version: " + AppUtil.appVersion(this) + " (" + AppUtil.appCode(this) + ")");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
