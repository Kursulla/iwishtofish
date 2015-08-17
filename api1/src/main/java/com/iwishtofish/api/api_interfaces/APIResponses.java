package com.iwishtofish.api.api_interfaces;

import com.iwishtofish.api.models.Response;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 *
 * Created by Kursulla on 02/08/15.
 */
public interface APIResponses {
    @POST("/responses")
    void respondToEvent(@Body Response response, ServerResponseCallback callback);

    @GET("/responses/{event_id}")
    void getAllResponsesToEvent(@Path("event_id") long eventId, ServerResponseCallback callback);

    @GET("/responses/{user_id}")
    void getAllResponsesOfUser(@Path("user_id") long userId, ServerResponseCallback callback);

    @DELETE("/responds/{response_id}")
    void deleteResponse(@Path("response_id") long response_id, ServerResponseCallback callback);
}
