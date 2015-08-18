package com.iwishtofish.api.api_interfaces;

import com.iwishtofish.api.models.Event;
import com.iwishtofish.api.models.Events;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 *
 * Created by Kursulla on 02/08/15.
 */
public interface APIEvents {
//    @GET("/events")
    @GET("/55d349f0ec91e9fe0f5e8e29")
    void allEventsInRegion(@Query("lat") String lat, @Query("lng") String lng, Callback<Events> callback);

//    @POST("/events")
    @POST("/55d244465733d70d1621e974")
    void addNewEvent(@Body Event event, Callback<Event> callback);

//    @DELETE("/events/{event_id}")
    @DELETE("/55d2477f5733d7461621e979/{event_id}")
    void deleteEvent(@Path("event_id")long eventId, Callback<Void> callback);
}
