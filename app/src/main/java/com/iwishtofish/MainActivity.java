package com.iwishtofish;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iwishtofish.api.models.APIError;
import com.iwishtofish.api.models.Events;

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
                System.out.println("beforeStart");
            }

            @Override
            public void onSuccess(Events events) {
                System.out.println("onSuccess");
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(events);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(APIError apiError) {
                System.out.println("onError");
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







    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PersonViewHolder> {

        Events events;

        RecyclerViewAdapter(Events events) {
            this.events = events;
        }

        @Override
        public PersonViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_event_card, parent, false);
            PersonViewHolder pvh = new PersonViewHolder(v);
            return pvh;
        }

        @Override
        public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
            personViewHolder.title_tv.setText(events.getItems().get(i).getTitle());
            personViewHolder.title_tv.setText("Desno od zute pumpe");
            if(i==3)
                personViewHolder.title_tv.setText("Desno od zute pumpe pa jos malo desnije");
        }

        @Override
        public int getItemCount() {
            return events.getItems().size();
        }

        public class PersonViewHolder extends RecyclerView.ViewHolder {
            CardView  cv;
            TextView  title_tv;
            TextView  personAge;
            ImageView personPhoto;

            PersonViewHolder(View itemView) {
                super(itemView);
                cv = (CardView) itemView.findViewById(R.id.card_view);
                title_tv = (TextView) itemView.findViewById(R.id.title_tv);
            }
        }

    }
}
