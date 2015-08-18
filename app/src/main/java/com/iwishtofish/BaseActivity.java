package com.iwishtofish;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 *
 * Created by Kursulla on 18/08/15.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected abstract void _getViewReferences();
    protected abstract void _getBundledData();
    protected abstract void _initViews();

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
}
