package com.iwishtofish.data;

import com.iwishtofish.R;
import com.iwishtofish.api.APIClients.APIEventsClient;
import com.iwishtofish.api.api_interfaces.ServerResponseCallback;
import com.iwishtofish.api.models.APIError;
import com.iwishtofish.api.models.APIResponseStatus;
import com.iwishtofish.api.models.Event;
import com.iwishtofish.api.models.Events;

/**
 *
 * Created by Kursulla on 12/08/15.
 */
public class EventsManager {
    private static Events events;

    public static void init() {
        APIEventsClient.init();
    }

    public static Events getEvents() {
        return events;
    }

    public static Event getEvent(int index) {
        return events.getItems().get(index);
    }

    public static void fetchAllEventsInRegion(String lat, String lng, final ApiCallback<Events> callback) {
        callback.beforeStart();
        APIEventsClient.get().eventsInRegion(lat, lng, new ServerResponseCallback<Events>() {
            @Override
            public void onSuccess(Events ev, APIResponseStatus responseStatus) {
                events = ev;
                callback.onSuccess(events);
            }

            @Override
            public void onError(APIError apiError) {
                callback.onError(apiError);
            }
        });
    }

    public static void fetchEventDetails(long eventId, final ApiCallback<Event> callback) {
        callback.beforeStart();
        APIEventsClient.get().eventDetails(eventId, new ServerResponseCallback<Event>() {
            @Override
            public void onSuccess(Event event, APIResponseStatus responseStatus) {
                callback.onSuccess(event);
            }

            @Override
            public void onError(APIError apiError) {
                callback.onError(apiError);
            }
        });
    }

    public static int getTypeResource(String type) {
        if (Technics.FEEDER.equals(type)) {
            return R.drawable.ic_proposition_varalica;
        } else if (Technics.FLOATING.equals(type)) {
            return R.drawable.ic_proposition_plovak;
        } else if (Technics.BOLOGNESE.equals(type)) {
            return R.drawable.ic_proposition_saran;
        } else if (Technics.DEEPING.equals(type)) {
            return R.drawable.ic_proposition_musicarenje;
        }else{
            return R.drawable.ic_launcher;
        }
    }
}
