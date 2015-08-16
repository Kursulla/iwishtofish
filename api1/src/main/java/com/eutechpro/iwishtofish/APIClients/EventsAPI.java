package com.eutechpro.iwishtofish.APIClients;

import com.eutechpro.iwishtofish.URLConstants;
import com.eutechpro.iwishtofish.api.APICallback;
import com.eutechpro.iwishtofish.api.APIEvents;
import com.eutechpro.iwishtofish.models.APIError;
import com.eutechpro.iwishtofish.models.APIResponseStatus;
import com.eutechpro.iwishtofish.models.Event;
import com.eutechpro.iwishtofish.models.Events;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Path;

/**
 * Created by Kursulla on 16/08/15.
 */
public class EventsAPI {
    private static EventsAPI singleton;
    private static APIEvents api;
    private EventsAPI() {
    }

    /* We could benefit from separation init() from get later. */
    public static void init() {
        singleton = new EventsAPI();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(URLConstants.DEV_API_URL)
                .setLogLevel(LogLevel.NONE)
                .build();
        singleton.api = restAdapter.create(APIEvents.class);
    }

    public static EventsAPI get() {
        if (singleton == null)
            throw new ApiNotInstantiatedException("You forgot to instantiate EventsAPI");
        else
            return singleton;
    }


    public void allEventsInRegion(@Path("lat") String lat, @Path("lng") String lng, final APICallback callback) {
        callback.beforeStart();
        /* Just forward callback, because no need for any data repacking. */
        api.allEventsInRegion(lat, lng, new Callback<Events>() {
            @Override
            public void success(Events events, Response response) {
                callback.onSuccess(events, new APIResponseStatus(response.getStatus()));
            }

            @Override
            public void failure(RetrofitError error) {
                callback.onError(new APIError(error.getResponse().getStatus(),error.getResponse().getReason()));
            }
        });
    }


    public void addNewEvent(@Body Event event, APICallback callback) {
        callback.beforeStart();
        /* Just forward callback, because no need for any data repacking. */
        api.addNewEvent(event, new Callback<Event>() {
            @Override
            public void success(Event event, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


    public void deleteEvent(@Path("event_id") long eventId, APICallback callback) {
        callback.beforeStart();
        /* Just forward callback, because no need for any data repacking. */
        api.deleteEvent(eventId, new Callback() {
            @Override
            public void success(Object o, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
