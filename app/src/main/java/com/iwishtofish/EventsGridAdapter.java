package com.iwishtofish;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iwishtofish.EventsGridAdapter.EventsViewHolder;
import com.iwishtofish.api.models.Events;

/**
 * Created by Kursulla on 18/08/15.
 */
public class EventsGridAdapter extends RecyclerView.Adapter<EventsViewHolder> {
    private Events events;

    EventsGridAdapter(Events events) {
        this.events = events;
    }

    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_event_card, parent, false);
        EventsViewHolder pvh = new EventsViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(EventsViewHolder eventsViewHolder, int i) {
        eventsViewHolder.title_tv.setText(events.getItems().get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return events.getItems().size();
    }

    public class EventsViewHolder extends RecyclerView.ViewHolder {
        CardView  cv;
        TextView  title_tv;
        TextView  personAge;
        ImageView personPhoto;

        EventsViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            title_tv = (TextView) itemView.findViewById(R.id.title_tv);
        }
    }

}