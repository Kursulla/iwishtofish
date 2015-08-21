package com.iwishtofish;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.iwishtofish.api.models.APIError;
import com.iwishtofish.api.models.Events;
import com.iwishtofish.data.ApiCallback;
import com.iwishtofish.data.EventsManager;

/**
 * Represents list of all events in set region.
 *
 * Created by Kursulla on 18/08/15.
 */
public class EventsActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    public static final int GRID_COLUMN_COUNT = 3;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        EventsManager.init();

        _getViewReferences();
        _initViews();

        _loadData();
    }

    @Override
    protected void _getViewReferences() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                _loadData();
            }
        });
    }

    @Override
    protected void _getBundledData() {
        //No bundled data for now
    }

    @Override
    protected void _loadData() {
        EventsManager.fetchAllEventsInRegion("234", "234", new ApiCallback<Events>() {
            @Override
            public void beforeStart() {
                //Init something if needed
                swipeRefreshLayout.setRefreshing(true);
            }

            @Override
            public void onSuccess(Events events) {
                recyclerView.setAdapter(new EventsGridAdapter(events, EventsActivity.this));
                swipeRefreshLayout.setRefreshing(false);
                SnackBarControl.showSimpleSnackBar(R.string.toast__refreshed, EventsActivity.this);
            }

            @Override
            public void onError(APIError apiError) {
                SnackBarControl.showSimpleSnackBar(R.string.events_toast__loading_failed, EventsActivity.this);
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    @Override
    protected void _initViews() {
        super._initViews();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, GRID_COLUMN_COUNT));
    }
}
