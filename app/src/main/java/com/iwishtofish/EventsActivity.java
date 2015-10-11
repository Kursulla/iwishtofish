package com.iwishtofish;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.EditText;

import com.iwishtofish.api.APIClients.APIEventsClient;
import com.iwishtofish.api.models.APIError;
import com.iwishtofish.api.models.Event;
import com.iwishtofish.api.models.Events;
import com.iwishtofish.data.ApiCallback;
import com.iwishtofish.data.EventsManager;
import com.iwishtofish.navigation_drawer.LeftDrawerFragment;
import com.iwishtofish.utils.SnackBarControl;

import java.util.concurrent.TimeUnit;

import rx.Observer;
import rx.Subscription;
import rx.android.widget.OnTextChangeEvent;
import rx.android.widget.WidgetObservable;

/**
 * Represents list of all events in set region.
 * <p/>
 * Created by Kursulla on 18/08/15.
 */
public class EventsActivity extends BaseActivity {
    private static final String TAG               = EventsActivity.class.getSimpleName();
    public static final  int    GRID_COLUMN_COUNT = 3;
    private RecyclerView       recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private EditText           locationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        EventsManager.init();

        _getViewReferences();
        _initViews();

        _loadData();

        System.out.println("Start");
        Subscription subscription = APIEventsClient.get().getEventDetailsR(111).subscribe(new Observer<Event>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError ");
                e.printStackTrace();

            }

            @Override
            public void onNext(Event event) {
                System.out.println("onNext");

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
        locationName = (EditText) findViewById(R.id.location_name);
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

        leftDrawerFragment = (LeftDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_left_drawer);
        if (leftDrawerFragment != null) {
            leftDrawerFragment.setUp((DrawerLayout) findViewById(R.id.drawer_layout));
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        WidgetObservable
                .text(locationName, false)
                .debounce(400, TimeUnit.MILLISECONDS)
                .subscribe(new Observer<OnTextChangeEvent>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(OnTextChangeEvent onTextChangeEvent) {
                        System.out.println("Change: " + onTextChangeEvent.text().toString());
                    }
                });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (leftDrawerFragment.getDrawerToggle().onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
