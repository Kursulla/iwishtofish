package com.iwishtofish.tests;

import com.iwishtofish.api.APIClients.APIEventsClient;
import com.iwishtofish.api.api_interfaces.APICallback;
import com.iwishtofish.api.models.APIError;
import com.iwishtofish.api.models.APIResponseStatus;

/**
 *
 * Created by Kursulla on 17/08/15.
 */
public class TestAPI {
    public static void main(String[] args){
        APIEventsClient.init();
        APIEventsClient.get().deleteEvent(123, new APICallback<Object>() {
            @Override
            public void beforeStart() {
                System.out.println("beforeStart");
            }

            @Override
            public void onSuccess(Object o, APIResponseStatus responseStatus) {
                System.out.println("onSuccess ");
            }

            @Override
            public void onError(APIError apiError) {
                System.out.println("onError");
                //                assertFalse(apiError.getErrorMessage(), true);
            }
        });
    }
}
