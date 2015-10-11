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
import rx.Observable;

/**
 *
 * Created by Kursulla on 02/08/15.
 */
public interface APIEvents {
//    @GET("/events")
    @GET("/55d9a702f1538b6502471d5c")
    void allEventsInRegion(@Query("lat") String lat, @Query("lng") String lng, Callback<Events> callback);

    //    @GET("/events/{eventId}")
    @GET("/55d6f490c97bffe803a685d4/{eventId}")
    void getEventDetails(@Path("eventId") long eventId, Callback<Event> callback);

//    @POST("/events")
    @POST("/55d244465733d70d1621e974")
    void addNewEvent(@Body Event event, Callback<Event> callback);

//    @DELETE("/events/{event_id}")
    @DELETE("/55d2477f5733d7461621e979/{event_id}")
    void deleteEvent(@Path("event_id")long eventId, Callback<Void> callback);

    @GET("/55d6f490c97bffe803a685d4/{eventId}")
    Observable<Event> getEventDetailsR(@Path("eventId") long eventId);
}
