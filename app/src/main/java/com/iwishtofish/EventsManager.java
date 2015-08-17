package com.iwishtofish;

import com.iwishtofish.api.APIClients.APIEventsClient;
import com.iwishtofish.api.api_interfaces.ServerResponseCallback;
import com.iwishtofish.api.models.APIError;
import com.iwishtofish.api.models.APIResponseStatus;
import com.iwishtofish.api.models.Events;

/**
 *
 * Created by Kursulla on 12/08/15.
 */
public class EventsManager {
    public static void fetchAllEventsInRegion(String lat, String lng, final ApiCallback callback){
        callback.beforeStart();
        APIEventsClient.get().allEventsInRegion(lat, lng, new ServerResponseCallback<Events>() {
            @Override
            public void onSuccess(Events events, APIResponseStatus responseStatus) {
                callback.onSuccess(events);
            }

            @Override
            public void onError(APIError apiError) {
                callback.onError(apiError);
            }
        });
    }

    public static void init() {
        APIEventsClient.init();
    }
}