package iwishtofish.api;

import iwishtofish.models.Response;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Path;
import retrofit.http.Retrofit.GET;
import retrofit.http.Retrofit.POST;

/**
 *
 * Created by Kursulla on 02/08/15.
 */
public interface APIResponses {
    @POST("/responses")
    void respondToEvent(@Body Response response, APICallback callback);

    @GET("/responses/{event_id}")
    void getAllResponsesToEvent(@Path("event_id") long eventId, APICallback callback);

    @GET("/responses/{user_id}")
    void getAllResponsesOfUser(@Path("user_id") long userId, APICallback callback);

    @DELETE("/responds/{response_id}")
    void deleteResponse(@Path("response_id") long response_id, APICallback callback);
}
