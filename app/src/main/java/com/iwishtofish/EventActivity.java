package com.iwishtofish;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.iwishtofish.api.models.Event;
import com.iwishtofish.data.EventsManager;
import com.iwishtofish.data.Technics;
import com.iwishtofish.databinding.ActivityEventBinding;
import com.iwishtofish.utils.AppUtil;
import com.iwishtofish.utils.PaletteUtil;
import com.iwishtofish.utils.SnackBarControl;

/**
 * Created by Kursulla on 21/08/15.
 */
public class EventActivity extends BaseActivity {
    private static final String TAG         = EventActivity.class.getSimpleName();
    public static final  String EVENT_INDEX = "EVENT_INDEX";
    public static final  String EVENT_TYPE  = "TYPE";
    //Deprecated because of use of DataBinding
    //    private ImageView type;
    //    private TextView  title;
    //    private TextView  date;
    //    private TextView  location;
    //    private TextView  description;
    private int    eventIndex;
    private String eventType;
    Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _getBundledData();
        _loadData();

        ActivityEventBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_event);
        binding.setEvent(event);

        _initViews();
    }

    @Override
    protected void _getViewReferences() {
        //Deprecated because of use of DataBinding
        //        type = (ImageView) findViewById(R.id.type_icon_iv);
        //        title = (TextView) findViewById(R.id.title_tv);
        //        date = (TextView) findViewById(R.id.date_tv);
        //        location = (TextView) findViewById(R.id.location_tv);
        //        description = (TextView) findViewById(R.id.description_tv);
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
        event = EventsManager.getEvent(eventIndex);
    }

    @Override
    protected void _initViews() {
        super._initViews();
        if (AppUtil.isAfterLollipop()) {
            initMaterialColors();
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initMaterialColors() {
        if (eventType != null) {
            switch (eventType) {
                case Technics.FEEDER:
                    toolbar.setBackgroundColor(PaletteUtil.getVibrantColor(R.drawable.ic_technic_feeder, this));
                    setMajorColor(PaletteUtil.getDarkVibrantColor(R.drawable.ic_technic_feeder, this));
                    break;
                case Technics.DEEPING:
                    toolbar.setBackgroundColor(PaletteUtil.getVibrantColor(R.drawable.ic_technic_deeping, this));
                    setMajorColor(PaletteUtil.getDarkVibrantColor(R.drawable.ic_technic_deeping, this));
                    break;
                case Technics.BOLOGNESE:
                    toolbar.setBackgroundColor(PaletteUtil.getVibrantColor(R.drawable.ic_technic_bolognese, this));
                    setMajorColor(PaletteUtil.getDarkVibrantColor(R.drawable.ic_technic_bolognese, this));
                    break;
                case Technics.FLOATING:
                    toolbar.setBackgroundColor(PaletteUtil.getVibrantColor(R.drawable.ic_technic_floating, this));
                    setMajorColor(PaletteUtil.getDarkVibrantColor(R.drawable.ic_technic_floating, this));
                    break;
            }
        }
    }

}
