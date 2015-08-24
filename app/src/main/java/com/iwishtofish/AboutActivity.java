package com.iwishtofish;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.iwishtofish.utils.AppUtil;
import com.iwishtofish.utils.PaletteUtil;

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
            toolbar.setBackgroundColor(PaletteUtil.getVibrantColor(R.drawable.about_image, this));
            setMajorColor(PaletteUtil.getDarkVibrantColor(R.drawable.about_image, this));
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
        //Empty because there is no ContextMenu on AboutActivity
        return true;
    }
}
