package iwishtofish.APIClients;

import iwishtofish.URLConstants;
import iwishtofish.api.APICallback;
import iwishtofish.api.APIEvents;
import iwishtofish.models.APIError;
import iwishtofish.models.APIResponseStatus;
import iwishtofish.models.Event;
import iwishtofish.models.Events;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
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
                .setEndpoint(URLConstants.API_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        api = restAdapter.create(APIEvents.class);
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
            public void success(Events events, retrofit.client.Response response) {
                callback.onSuccess(events, new APIResponseStatus());
            }

            @Override
            public void failure(RetrofitError error) {
                callback.onError(new APIError());
            }
        });
    }


    public void addNewEvent(@Body Event event, APICallback callback) {
        callback.beforeStart();
        /* Just forward callback, because no need for any data repacking. */
        api.addNewEvent(event, new Callback<Event>() {
            @Override
            public void success(Event event, retrofit.client.Response response) {

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
            public void success(Object o, retrofit.client.Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
