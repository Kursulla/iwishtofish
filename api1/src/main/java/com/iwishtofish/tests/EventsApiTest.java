package com.iwishtofish.tests;

import com.iwishtofish.api.APIClients.APIEventsClient;
import com.iwishtofish.api.api_interfaces.APICallback;
import com.iwishtofish.api.models.APIError;
import com.iwishtofish.api.models.APIResponseStatus;
import com.iwishtofish.api.models.Event;
import com.iwishtofish.api.models.Events;

import junit.framework.TestCase;

/**
 * Created by Kursulla on 16/08/15.
 */
public class EventsApiTest extends TestCase {
    private Events events;
    private Event event;
    private int statusCode;

    public void setUp() throws Exception {
        super.setUp();
        APIEventsClient.init();
    }

    public void testGetAllEvents() throws Exception {
        events = null;
        APIEventsClient.get().allEventsInRegion("124124", "23452345", new APICallback<Events>() {
            @Override
            public void beforeStart() {
                System.out.println("beforeStart");
            }

            @Override
            public void onSuccess(Events ev, APIResponseStatus responseStatus) {
                System.out.println("onSuccess");
                events = ev;
            }

            @Override
            public void onError(APIError apiError) {
                System.out.println("onError");
                assertFalse(apiError.getErrorMessage(), true);
            }
        });
        Thread.sleep(500);
        assertNotNull("API call for GetAllEvents failed. Returned Events object is null ", events);
        assertNotNull("API call for GetAllEvents failed. Returned Events.items is null ", events.getItems());
        assertFalse("API call for GetAllEvents failed. Returned Events.items size is 0 ", events.getItems().size() == 0);
    }

    public void testAddNewEvent() throws Exception {
        final Event mockEvent = new Event();
        APIEventsClient.get().addNewEvent(mockEvent, new APICallback<Event>() {
            @Override
            public void beforeStart() {
                System.out.println("beforeStart");
            }

            @Override
            public void onSuccess(Event ev, APIResponseStatus responseStatus) {
                System.out.println("onSuccess");
                event = ev;
            }

            @Override
            public void onError(APIError apiError) {
                System.out.println("onError");
                assertFalse(apiError.getErrorMessage(), true);
            }
        });
        Thread.sleep(500);
        assertNotNull("API call for AddNewEvent failed. Returned Event object is null ", event);
        assertNotNull("API call for AddNewEvent failed. Returned Event.getId() is 0 ", event.getId());
    }

    public void testDeleteEvent() throws Exception {
        final Event event = new Event();
        APIEventsClient.get().deleteEvent(event.getId(), new APICallback<Object>() {
            @Override
            public void beforeStart() {
                System.out.println("beforeStart");
            }

            @Override
            public void onSuccess(Object responseData, APIResponseStatus responseStatus) {
                System.out.println("onSuccess "+ responseStatus.getHttpStatus());
                statusCode = responseStatus.getHttpStatus();
            }

            @Override
            public void onError(APIError apiError) {
                System.out.println("onError");
                assertFalse(apiError.getErrorMessage(), true);
            }
        });
        Thread.sleep(500);
        assertEquals("API call for deleteEvent failed. Returned HTTP status is not 204 ", 204, statusCode);
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }
}
