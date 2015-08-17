package com.iwishtofish.tests;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import retrofit.client.Client;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

/**
 *
 * Created by Kursulla on 17/08/15.
 */
public class ApiEventsMock implements Client {
    public static final String EVENTS_GET_FILE_PATH = System.getProperty("user.dir") + "/api1/src/main/java/com/iwishtofish/tests/json_mocks/events_get_mock.json";
    public static final String EVENTS_POST_FILE_PATH = System.getProperty("user.dir") + "/api1/src/main/java/com/iwishtofish/tests/json_mocks/events_post_mock.json";
    public static final String EVENTS_DELETE_FILE_PATH = System.getProperty("user.dir") + "/api1/src/main/java/com/iwishtofish/tests/json_mocks/events_delete_mock.json";

    @Override
    public Response execute(Request request) throws IOException {
        if(request.getMethod().equals("GET")) {
            String content = new Scanner(new File(EVENTS_GET_FILE_PATH)).useDelimiter("\\Z").next();
            return new Response(request.getUrl(), 200, "no reason", Collections.EMPTY_LIST, new TypedByteArray("application/json", content.getBytes()));
        } else if (request.getMethod().equals("POST")) {
            String content = new Scanner(new File(EVENTS_POST_FILE_PATH)).useDelimiter("\\Z").next();
            return new Response(request.getUrl(), 201, "no reason", Collections.EMPTY_LIST, new TypedByteArray("application/json", content.getBytes()));
        } else if (request.getMethod().equals("DELETE")) {
            String content = new Scanner(new File(EVENTS_DELETE_FILE_PATH)).useDelimiter("\\Z").next();
            return new Response(request.getUrl(), 204, "no reason", Collections.EMPTY_LIST, new TypedByteArray("application/json", content.getBytes()));
        }
        return null;
    }
}
