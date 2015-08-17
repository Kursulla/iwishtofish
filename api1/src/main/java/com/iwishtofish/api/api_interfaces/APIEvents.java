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
    @GET("/events")
    void allEventsInRegion(@Query("lat") String lat, @Query("lng") String lng, Callback<Events> callback);

    @POST("/events")
    void addNewEvent(@Body Event event, Callback<Event> callback);

    @DELETE("/events/{event_id}")
    void deleteEvent(@Path("event_id")long eventId, Callback<Event> callback);
}
