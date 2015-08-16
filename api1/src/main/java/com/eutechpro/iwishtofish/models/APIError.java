package com.eutechpro.iwishtofish.models;

/**
 * Created by Kursulla on 16/08/15.
 */
public class APIError {
    private int errorCode;
    private String errorMessage;

    public APIError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
