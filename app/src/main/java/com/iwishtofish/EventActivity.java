package com.iwishtofish;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.iwishtofish.api.models.APIError;
import com.iwishtofish.api.models.Event;
import com.iwishtofish.data.ApiCallback;
import com.iwishtofish.data.EventsManager;
import com.iwishtofish.data.Technics;

/**
 * Created by Kursulla on 21/08/15.
 */
public class EventActivity extends BaseActivity {
    private static final String TAG = "EventActivity";
    public static final String EVENT_ID = "EVENT_ID";
    public static final String EVENT_TYPE = "TYPE";
    private ImageView type;
    private TextView  title;
    private TextView  date;
    private TextView  location;
    private TextView  description;
    private long      eventId;
    private String      eventType;
    private Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        EventsManager.init();
        _getViewReferences();
        _getBundledData();
        _initViews();

        EventsManager.fetchEventDetails(eventId, new ApiCallback<Event>() {
            @Override
            public void beforeStart() {
                //start loader
            }

            @Override
            public void onSuccess(Event ev) {
                event = ev;
                 _loadData();
                //stop loader
            }

            @Override
            public void onError(APIError apiError) {
                //stop loader
                SnackBarControl.showSimpleSnackBar(R.string.event_toast__loading_failed, EventActivity.this);
            }
        });
    }

    @Override
    protected void _getViewReferences() {
        type = (ImageView) findViewById(R.id.type_icon_iv);
        title = (TextView) findViewById(R.id.title_tv);
        date = (TextView)findViewById(R.id.date_tv);
        location = (TextView)findViewById(R.id.location_tv);
        description = (TextView)findViewById(R.id.description_tv);
    }

    @Override
    protected void _getBundledData() {
        eventId = getIntent().getLongExtra(EVENT_ID,-1);
        eventType = getIntent().getStringExtra(EVENT_TYPE);

        if(eventId == -1){
            SnackBarControl.showSimpleSnackBar("Error occurred. Please try again", this);
        }
    }
    @Override
    protected void _loadData(){
        type.setImageResource(EventsManager.getTypeResource(event.getType()));
        title.setText(event.getTitle());
        location.setText(event.getLocation() + ", " + event.getSubLocation());
        date.setText(event.getWhen());
        description.setText(event.getDescription());
    }

    @Override
    protected void _initViews() {
        super._initViews();
        if(eventType != null) {
            if (eventType.equals(Technics.FEEDER)) {
                toolbar.setBackgroundColor(Color.parseColor("#3ec261"));
            } else if (eventType.equals(Technics.DEEPING)) {
                toolbar.setBackgroundColor(Color.parseColor("#3da5c4"));
            } else if (eventType.equals(Technics.BOLOGNESE)) {
                toolbar.setBackgroundColor(Color.parseColor("#c43d6f"));
            } else if (eventType.equals(Technics.FLOATING)) {
                toolbar.setBackgroundColor(Color.parseColor("#e68830"));
            }
        }
    }
}
