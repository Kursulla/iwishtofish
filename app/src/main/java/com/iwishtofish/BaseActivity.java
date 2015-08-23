package com.iwishtofish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.iwishtofish.navigation_drawer.LeftDrawerFragment;

/**
 * Created by Kursulla on 14/08/15.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar            toolbar;
    protected LeftDrawerFragment leftDrawerFragment;

    protected abstract void _getViewReferences();

    protected abstract void _getBundledData();

    protected abstract void _loadData();

    protected void _initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (leftDrawerFragment != null && leftDrawerFragment.isOpen()) {
            leftDrawerFragment.closeDrawer();
            return;
        }

        super.onBackPressed();
    }
}
