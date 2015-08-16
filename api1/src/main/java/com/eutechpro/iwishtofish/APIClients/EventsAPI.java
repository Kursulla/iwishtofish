package com.eutechpro.iwishtofish.APIClients;

import com.eutechpro.iwishtofish.URLConstants;
import com.eutechpro.iwishtofish.api.APICallback;
import com.eutechpro.iwishtofish.api.APIEvents;
import com.eutechpro.iwishtofish.models.Event;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.RestAdapter;
import retrofit.http.Body;
import retrofit.http.Path;

/**
 * Created by Kursulla on 16/08/15.
 */
public class EventsAPI  implements APIEvents{
    private static EventsAPI singleton;
    private static APIEvents api;
    private EventsAPI() {
    }

    /* We can benefit from this separation later. */
    public static void init() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(URLConstants.API_URL   )
                .build();
        api = restAdapter.create(APIEvents.class);
        singleton = new EventsAPI();
    }

    public static EventsAPI get() {
        if (singleton == null)
            throw new ApiNotInstantiatedException("You forgot to instantiate EventsAPI");
        else
            return singleton;
    }

    @Override
    public void allEventsInRegion(@Path("lat") String lat, @Path("lng") String lng, APICallback callback) {
        callback.beforeStart();
        /* Just forward callback, because no need for any data repacking. */
        api.allEventsInRegion(lat, lng, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

            }
        });
    }

    @Override
    public void addNewEvent(@Body Event event, APICallback callback) {
        callback.beforeStart();
        /* Just forward callback, because no need for any data repacking. */
        api.addNewEvent(event, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

            }
        });
    }

    @Override
    public void deleteEvent(@Path("event_id") long eventId, APICallback callback) {
        callback.beforeStart();
        /* Just forward callback, because no need for any data repacking. */
        api.deleteEvent(eventId, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

            }
        });
    }
}
