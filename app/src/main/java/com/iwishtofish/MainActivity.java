package com.iwishtofish;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.iwishtofish.api.models.APIError;
import com.iwishtofish.api.models.Events;
import com.iwishtofish.data.ApiCallback;
import com.iwishtofish.data.EventsManager;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    public static final int GRID_COLUMN_COUNT = 3;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventsManager.init();

        _getViewReferences();
        _initViews();

        EventsManager.fetchAllEventsInRegion("234", "234", new ApiCallback<Events>() {
            @Override
            public void beforeStart() {
                //Start progress bar
            }

            @Override
            public void onSuccess(Events events) {
                recyclerView.setAdapter(new EventsGridAdapter(events));
            }

            @Override
            public void onError(APIError apiError) {
                Toast.makeText(MainActivity.this, R.string.events_toast__loading_failed, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void _getViewReferences() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    @Override
    protected void _getBundledData() {
        //No bundled data for now
    }

    @Override
    protected void _initViews() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, GRID_COLUMN_COUNT));
    }








}
