package com.iwishtofish.api.models;

/**
 * Created by Kursulla on 16/08/15.
 */
public class Response extends APIResponseData {
    private long eventId;
    private long userId;
    private String timestamp;

    public Response(long id) {
        super(id);
    }
}