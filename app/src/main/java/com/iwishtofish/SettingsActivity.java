package com.iwishtofish;

import android.os.Bundle;
import android.view.Menu;

/**
 * Created by Kursulla on 23/08/15.
 */
public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        _getViewReferences();
        _initViews();
        _loadData();
    }

    @Override
    protected void _getViewReferences() {

    }

    @Override
    protected void _getBundledData() {
        //No bundled data here
    }

    @Override
    protected void _initViews() {
        super._initViews();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void _loadData() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Empty because there is no ContextMenu on AboutActivity
        return true;
    }
}
