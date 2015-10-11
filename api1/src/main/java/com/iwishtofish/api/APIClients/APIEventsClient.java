package com.iwishtofish.api.APIClients;

import com.iwishtofish.api.URLConstants;
import com.iwishtofish.api.api_interfaces.APIEvents;
import com.iwishtofish.api.api_interfaces.ServerResponseCallback;
import com.iwishtofish.api.models.APIError;
import com.iwishtofish.api.models.APIResponseStatus;
import com.iwishtofish.api.models.Event;
import com.iwishtofish.api.models.Events;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;
import retrofit.RetrofitError;
import retrofit.client.Client;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Path;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Kursulla on 16/08/15.
 */
public class APIEventsClient {
    public static final Client DEFAULT_CLIENT = null;
    private static APIEventsClient singleton;
    private static APIEvents       api;

    private APIEventsClient() {
    }

    /* We could benefit from separation init() from get later. */
    public static void init(Client client) {
        singleton = new APIEventsClient();
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(URLConstants.DEV_API_URL)
                .setLogLevel(LogLevel.NONE);
        if(client != null){
            builder.setClient(client);
        }

        RestAdapter restAdapter = builder.build();
        api = restAdapter.create(APIEvents.class);
    }

    public static APIEventsClient get() {
        if (singleton == null) {
            throw new ApiNotInstantiatedException("You forgot to instantiate EventsAPI");
        } else {
            return singleton;
        }
    }

    public void eventsInRegion(@Path("lat") String lat, @Path("lng") String lng, final ServerResponseCallback callback) {
        /* Just forward callback, because no need for any data repacking. */
        api.allEventsInRegion(lat, lng, new Callback<Events>() {
            @Override
            public void success(Events events, Response response) {
                callback.onSuccess(events, new APIResponseStatus(response.getStatus()));
            }

            @Override
            public void failure(RetrofitError error) {
                callback.onError(new APIError(error.getResponse().getStatus(), error.getResponse().getReason()));
            }
        });
    }

    public void eventDetails(@Path("eventId") long eventId, final ServerResponseCallback callback) {
        /* Just forward callback, because no need for any data repacking. */
        api.getEventDetails(eventId, new Callback<Event>() {
            @Override
            public void success(Event event, Response response) {
                callback.onSuccess(event, new APIResponseStatus(response.getStatus()));
            }

            @Override
            public void failure(RetrofitError error) {
                callback.onError(new APIError(error.getResponse().getStatus(), error.getResponse().getReason()));
            }
        });
    }

    public void addNewEvent(@Body Event event, final ServerResponseCallback callback) {
        /* Just forward callback, because no need for any data repacking. */
        api.addNewEvent(event, new Callback<Event>() {
            @Override
            public void success(Event event, Response response) {
                callback.onSuccess(event, new APIResponseStatus(response.getStatus()));
            }

            @Override
            public void failure(RetrofitError error) {
                callback.onError(new APIError(error.getResponse().getStatus(), error.getResponse().getReason()));
            }
        });
    }

    public void deleteEvent(@Path("event_id") long eventId, final ServerResponseCallback callback) {
        /* Just forward callback, because no need for any data repacking. */
        api.deleteEvent(eventId, new Callback<Void>() {
            @Override
            public void success(Void aVoid, Response response) {
                callback.onSuccess(null, new APIResponseStatus(response.getStatus()));
            }

            @Override
            public void failure(RetrofitError error) {
                callback.onError(new APIError(error.getResponse().getStatus(), error.getResponse().getReason()));
            }
        });
    }

}
