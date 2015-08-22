package com.iwishtofish;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iwishtofish.EventsGridAdapter.EventsViewHolder;
import com.iwishtofish.api.models.Events;
import com.iwishtofish.data.EventsManager;

/**
 *
 * Created by Kursulla on 18/08/15.
 */
public class EventsGridAdapter extends RecyclerView.Adapter<EventsViewHolder> {
    private Context context;
    private Events  events;

    EventsGridAdapter(Events events, Context context) {
        this.events = events;
        this.context = context;
    }

    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, final int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_event_card, parent, false);
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EventActivity.class);
                intent.putExtra(EventActivity.EVENT_ID,events.getItems().get(position).getId());
                intent.putExtra(EventActivity.EVENT_TYPE,events.getItems().get(position).getType());
                context.startActivity(intent);
            }
        });
        return new EventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventsViewHolder eventsViewHolder, int position) {
        eventsViewHolder.setType(events.getItems().get(position).getType());
        eventsViewHolder.setTitle(events.getItems().get(position).getTitle());
        eventsViewHolder.setDate(events.getItems().get(position).getWhen());
        eventsViewHolder.setMaxPersons(events.getItems().get(position).getMaxPersons());
    }

    @Override
    public int getItemCount() {
        return events.getItems().size();
    }

    public class EventsViewHolder extends RecyclerView.ViewHolder {
        CardView  cv;
        ImageView type_icon_iv;
        TextView  title_tv;
        TextView  date_tv;
        TextView  max_persons_tv;

        EventsViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            type_icon_iv = (ImageView) itemView.findViewById(R.id.type_icon_iv);
            title_tv = (TextView) itemView.findViewById(R.id.title_tv);
            date_tv = (TextView) itemView.findViewById(R.id.date_tv);
            max_persons_tv = (TextView) itemView.findViewById(R.id.max_persons_tv);
        }

        void setType(String type) {
            type_icon_iv.setImageResource(EventsManager.getTypeResource(type));
        }

        void setTitle(String title) {
            this.title_tv.setText(title);
        }

        public void setDate(String date) {
            this.date_tv.setText(date);
        }

        public void setMaxPersons(int maxPersons) {
            this.max_persons_tv.setText(context.getResources().getQuantityString(R.plurals.event_max_persons, maxPersons, maxPersons));
        }
    }

}