package com.iwishtofish.api.models;

/**
 * Created by Kursulla on 16/08/15.
 */
public abstract class APIResponseData {
    private long id;

    public APIResponseData(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
