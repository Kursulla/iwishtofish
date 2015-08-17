package com.iwishtofish.api.models;

/**
 * Created by Kursulla on 16/08/15.
 */
public class Comment extends APIResponseData {
    private long userId;
    private long eventId;
    private String text;
    private String timestamp;

    public Comment(long id) {
        super(id);
    }
}
