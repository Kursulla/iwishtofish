package com.iwishtofish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.eutechpro.iwishtofish.APIClients.EventsAPI;
import com.eutechpro.iwishtofish.api.APICallback;
import com.eutechpro.iwishtofish.models.APIError;
import com.eutechpro.iwishtofish.models.APIResponseData;
import com.eutechpro.iwishtofish.models.APIResponseStatus;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventsAPI.init();
        EventsAPI.get().allEventsInRegion("124124", "23452345", new APICallback() {
            @Override
            public void beforeStart() {
                Log.d(TAG, "beforeStart");
            }

            @Override
            public void onSuccess(APIResponseData responseData, APIResponseStatus responseStatus) {
                Log.d(TAG, "onSuccess");
            }

            @Override
            public void onError(APIError apiError) {
                Log.d(TAG, "onError");
            }
        });

//        EventsAPI.get().addNewEvent(new Event(), new APICallback() {
//            @Override
//            public void beforeStart() {
//                Log.d(TAG, "beforeStart");
//            }
//
//            @Override
//            public void onSuccess(APIResponseData responseData, APIResponseStatus responseStatus) {
//                Log.d(TAG, "onSuccess");
//            }
//
//            @Override
//            public void onError(APIError apiError) {
//                Log.d(TAG, "onError");
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
