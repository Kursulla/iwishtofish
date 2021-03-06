package com.eutechpro.iwishtofish.api;

import com.eutechpro.iwishtofish.models.Event;
import com.eutechpro.iwishtofish.models.Events;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Path;
import retrofit.http.Retrofit.GET;
import retrofit.http.Retrofit.POST;

/**
 *
 * Created by Kursulla on 02/08/15.
 */
public interface APIEvents {
    @GET("/events/{lat}/{lng}")
    void allEventsInRegion(@Path("lat") String lat, @Path("lng") String lng, Callback<Events> callback);

    @POST("/events")
    void addNewEvent(@Body Event event, Callback<Event> callback);

    @DELETE("/events/{event_id}")
    void deleteEvent(@Path("event_id")long eventId, Callback callback);
}
