package com.iwishtofish;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.iwishtofish.api.models.Event;
import com.iwishtofish.data.EventsManager;
import com.iwishtofish.data.Technics;

/**
 * Created by Kursulla on 21/08/15.
 */
public class EventActivity extends BaseActivity {
    private static final String TAG        = "EventActivity";
    public static final  String EVENT_INDEX = "EVENT_INDEX";
    public static final  String EVENT_TYPE  = "TYPE";
    private ImageView type;
    private TextView  title;
    private TextView  date;
    private TextView  location;
    private TextView  description;
    private int       eventIndex;
    private String    eventType;
    private Event     event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        EventsManager.init();
        _getViewReferences();
        _getBundledData();
        _initViews();

        event = EventsManager.getEvent(eventIndex);
        _loadData();

    }

    @Override
    protected void _getViewReferences() {
        type = (ImageView) findViewById(R.id.type_icon_iv);
        title = (TextView) findViewById(R.id.title_tv);
        date = (TextView) findViewById(R.id.date_tv);
        location = (TextView) findViewById(R.id.location_tv);
        description = (TextView) findViewById(R.id.description_tv);
    }

    @Override
    protected void _getBundledData() {
        eventIndex = getIntent().getIntExtra(EVENT_INDEX, -1);
        eventType = getIntent().getStringExtra(EVENT_TYPE);

        if (eventIndex == -1) {
            SnackBarControl.showSimpleSnackBar("Error occurred. Please try again", this);
        }
    }

    @Override
    protected void _loadData() {
        type.setImageResource(EventsManager.getTypeResource(event.getType()));
        title.setText(event.getTitle());
        location.setText(event.getLocation() + ", " + event.getSubLocation());
        date.setText(event.getWhen());
        description.setText(event.getDescription());
    }

    @Override
    protected void _initViews() {
        super._initViews();
        if (eventType != null) {
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
