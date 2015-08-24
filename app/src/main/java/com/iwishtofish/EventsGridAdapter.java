package com.iwishtofish;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION_CODES;
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
import com.iwishtofish.utils.AppUtil;

/**
 *
 * Created by Kursulla on 18/08/15.
 */
public class EventsGridAdapter extends RecyclerView.Adapter<EventsViewHolder> {
    private Activity activity;
    private Events   events;

    EventsGridAdapter(Events events, Activity context) {
        this.events = events;
        this.activity = context;
    }

    @Override
    public EventsViewHolder onCreateViewHolder(final ViewGroup parent, final int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_event_card, parent, false);
        final EventsViewHolder eventsViewHolder = new EventsViewHolder(view);


        view.setOnClickListener(new OnClickListener() {
            @TargetApi(VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, EventActivity.class);
                intent.putExtra(EventActivity.EVENT_INDEX, eventsViewHolder.getAdapterPosition());
                intent.putExtra(EventActivity.EVENT_TYPE, events.getItems().get(eventsViewHolder.getAdapterPosition()).getType());

                if (AppUtil.isAfterLollipop()) {
                    ImageView img = (ImageView) view.findViewById(R.id.type_icon_iv);
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(activity, img, "type_icon");
                    activity.startActivity(intent, options.toBundle());
                } else {
                    activity.startActivity(intent);
                }
            }
        });

        return eventsViewHolder;
    }

    @Override
    public void onBindViewHolder(EventsViewHolder eventsViewHolder, int position) {
        eventsViewHolder.setType(events.getItems().get(position).getType());
        eventsViewHolder.setTitle(events.getItems().get(position).getTitle());
        eventsViewHolder.setLocation(events.getItems().get(position).getLocation());
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
        TextView  location_tv;
        TextView  date_tv;
        TextView  max_persons_tv;

        EventsViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            type_icon_iv = (ImageView) itemView.findViewById(R.id.type_icon_iv);
            title_tv = (TextView) itemView.findViewById(R.id.title_tv);
            location_tv = (TextView) itemView.findViewById(R.id.location_tv);
            date_tv = (TextView) itemView.findViewById(R.id.date_tv);
            max_persons_tv = (TextView) itemView.findViewById(R.id.max_persons_tv);
        }

        void setType(String type) {
            type_icon_iv.setImageResource(EventsManager.getTypeResource(type));
        }

        void setTitle(String title) {
            this.title_tv.setText(title);
        }
        void setLocation(String location) {
            this.location_tv.setText(location);
        }

        public void setDate(String date) {
            this.date_tv.setText(date);
        }

        public void setMaxPersons(int maxPersons) {
            this.max_persons_tv.setText(activity.getResources().getQuantityString(R.plurals.event_max_persons, maxPersons, maxPersons));
        }
    }

}