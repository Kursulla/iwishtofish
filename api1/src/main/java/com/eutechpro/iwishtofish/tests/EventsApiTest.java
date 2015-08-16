package com.eutechpro.iwishtofish.tests;

import com.eutechpro.iwishtofish.APIClients.EventsAPI;
import com.eutechpro.iwishtofish.api.APICallback;
import com.eutechpro.iwishtofish.models.APIError;
import com.eutechpro.iwishtofish.models.APIResponseStatus;
import com.eutechpro.iwishtofish.models.Events;

import junit.framework.TestCase;

/**
 * Created by Kursulla on 16/08/15.
 */
public class EventsApiTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
        EventsAPI.init();
    }

    public void testGetAllEvents() throws Exception {
        EventsAPI.get().allEventsInRegion("124124", "23452345", new APICallback<Events>() {
            @Override
            public void beforeStart() {
                System.out.println("beforeStart");
            }

            @Override
            public void onSuccess(Events events, APIResponseStatus responseStatus) {
                System.out.println("onSuccess");
                assertNotNull("API call for GetAllEvents failed. Returned Events object is null ",events);
                assertNotNull("API call for GetAllEvents failed. Returned Events.items is null ",events.getItems());
                assertFalse("API call for GetAllEvents failed. Returned Events.items size is 0 ", events.getItems().size() != 0);
            }

            @Override
            public void onError(APIError apiError) {
                System.out.println("onError");
                assertFalse(apiError.getErrorMessage(), true);
            }
        });
        Thread.sleep(2000);
//        assertFalse("xxx", true);
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }
}
