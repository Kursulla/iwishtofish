package com.iwishtofish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.iwishtofish.api.models.APIError;
import com.iwishtofish.api.models.Events;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventsManager.init();

        EventsManager.fetchAllEventsInRegion("234", "234", new ApiCallback<Events>() {
            @Override
            public void beforeStart() {
                System.out.println("beforeStart");
            }

            @Override
            public void onSuccess(Events events) {
                System.out.println("onSuccess");
                System.out.println(events.getItems().size());
            }

            @Override
            public void onError(APIError apiError) {
                System.out.println("onError");
            }
        });
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
}
