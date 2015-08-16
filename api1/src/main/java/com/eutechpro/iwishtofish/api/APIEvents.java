package com.eutechpro.iwishtofish.api;

import com.eutechpro.iwishtofish.models.Event;
import com.eutechpro.iwishtofish.models.Events;

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
    @GET("/55d0d426de9fde330cfe374c")
    void allEventsInRegion(@Query("lat") String lat, @Query("lng") String lng, Callback<Events> callback);

    @POST("/events")
    void addNewEvent(@Body Event event, Callback<Event> callback);

    @DELETE("/events/{event_id}")
    void deleteEvent(@Path("event_id")long eventId, Callback callback);
}
