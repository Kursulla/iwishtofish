package com.iwishtofish;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.iwishtofish.api.models.Event;
import com.iwishtofish.data.EventsManager;
import com.iwishtofish.data.Technics;
import com.iwishtofish.utils.AndroidVersionUtil;
import com.iwishtofish.utils.SnackBarControl;

/**
 * Created by Kursulla on 21/08/15.
 */
public class EventActivity extends BaseActivity {
    private static final String TAG         = EventActivity.class.getSimpleName();
    public static final  String EVENT_INDEX = "EVENT_INDEX";
    public static final  String EVENT_TYPE  = "TYPE";
    private ImageView type;
    private TextView  title;
    private TextView  date;
    private TextView  location;
    private TextView  description;
    private int       eventIndex;
    private String    eventType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        _getViewReferences();
        _getBundledData();
        _initViews();
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
        Event event = EventsManager.getEvent(eventIndex);
        type.setImageResource(EventsManager.getTypeResource(event.getType()));
        title.setText(event.getTitle());
        location.setText(event.getLocation() + ", " + event.getSubLocation());
        date.setText(event.getWhen());
        description.setText(event.getDescription());
    }

    @Override
    protected void _initViews() {
        super._initViews();
        if (AndroidVersionUtil.isAfterLollipop()) {
            initMaterialColors();
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initMaterialColors() {
        if (eventType != null) {
            switch (eventType) {
                case Technics.FEEDER:
                    toolbar.setBackgroundColor(getResources().getColor(R.color.technic_feeder));
                    setStatusBarColor(getResources().getColor(R.color.technic_feeder_dark));
                    break;
                case Technics.DEEPING:
                    toolbar.setBackgroundColor(getResources().getColor(R.color.technic_deeping));
                    setStatusBarColor(getResources().getColor(R.color.technic_deeping_dark));
                    break;
                case Technics.BOLOGNESE:
                    toolbar.setBackgroundColor(getResources().getColor(R.color.technic_bolognese));
                    setStatusBarColor(getResources().getColor(R.color.technic_bolognese_dark));
                    break;
                case Technics.FLOATING:
                    toolbar.setBackgroundColor(getResources().getColor(R.color.technic_floating));
                    setStatusBarColor(getResources().getColor(R.color.technic_floating_dark));
                    break;
            }
        }
    }


}
