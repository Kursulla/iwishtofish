package com.iwishtofish.api.models;

/**
 * Created by Kursulla on 16/08/15.
 */
public class APIResponseStatus {
    private int httpStatus;

    public APIResponseStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
