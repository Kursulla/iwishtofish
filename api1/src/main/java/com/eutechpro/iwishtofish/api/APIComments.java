package com.eutechpro.iwishtofish.api;

import com.eutechpro.iwishtofish.models.Comment;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Path;
import retrofit.http.Retrofit.GET;
import retrofit.http.Retrofit.POST;
import retrofit.http.Retrofit.PUT;

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
