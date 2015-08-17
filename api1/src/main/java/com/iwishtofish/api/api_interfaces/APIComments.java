package com.iwishtofish.api.api_interfaces;

import com.iwishtofish.api.models.Comment;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 *
 * Created by Kursulla on 02/08/15.
 */
public interface APIComments {
    @POST("/comments")
    void commentEvent(@Body Comment comment, APICallback callback);

    @GET("/comments/{event_id}")
    void getAllCommentsOfEvent(@Path("event_id") long eventId, APICallback callback);

    @PUT("/comments/{user_id}")
    void updateComment(@Path("user_id") long userId, APICallback callback);

    @DELETE("/comments/{comment_id}")
    void deleteComment(@Path("comment_id") long comment_id, APICallback callback);
}
