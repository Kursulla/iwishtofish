package com.eutechpro.iwishtofish.APIClients;

/**
 *
 * Created by Kursulla on 10/08/15.
 */
public class ApiNotInstantiatedException extends RuntimeException {
    public ApiNotInstantiatedException(String message) {
        super(message);
    }
}
