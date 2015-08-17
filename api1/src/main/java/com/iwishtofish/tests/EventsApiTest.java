package com.iwishtofish.tests;

import com.iwishtofish.api.APIClients.APIEventsClient;
import com.iwishtofish.api.api_interfaces.ServerResponseCallback;
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
    private Event  event;
    private int    statusCode;

    public void setUp() throws Exception {
        super.setUp();
        APIEventsClient.init();
    }

    public void testGetAllEvents() throws Exception {
        events = null;
        APIEventsClient.get().allEventsInRegion("124124", "23452345", new ServerResponseCallback<Events>() {
            @Override
            public void onSuccess(Events ev, APIResponseStatus responseStatus) {
                System.out.println("onSuccess");
                statusCode = responseStatus.getHttpStatus();
                events = ev;
            }

            @Override
            public void onError(APIError apiError) {
                System.out.println("onError");
                assertFalse(apiError.getErrorMessage(), true);
            }
        });
        Thread.sleep(1000);
        assertEquals("API call for AddNewEvent failed. Returned HTTP status is not 200 ", 200, statusCode);
        assertNotNull("API call for GetAllEvents failed. Returned Events object is null ", events);
        assertNotNull("API call for GetAllEvents failed. Returned Events.items is null ", events.getItems());
        assertFalse("API call for GetAllEvents failed. Returned Events.items size is 0 ", events.getItems().size() == 0);
        event = null;
        statusCode = 0;
    }

    public void testAddNewEvent() throws Exception {
        final Event mockEvent = new Event(1);
        APIEventsClient.get().addNewEvent(mockEvent, new ServerResponseCallback<Event>() {
            @Override
            public void onSuccess(Event ev, APIResponseStatus responseStatus) {
                System.out.println("onSuccess");
                statusCode = responseStatus.getHttpStatus();
                event = ev;
            }

            @Override
            public void onError(APIError apiError) {
                System.out.println("onError");
                assertFalse(apiError.getErrorMessage(), true);
            }
        });
        Thread.sleep(1000);
        assertEquals("API call for AddNewEvent failed. Returned HTTP status is not 201 ", 201, statusCode);
        assertNotNull("API call for AddNewEvent failed. Returned Event object is null ", event);
        assertNotNull("API call for AddNewEvent failed. Returned Event.getId() is 0 ", event.getId());
        event = null;
        statusCode = 0;
    }

    public void testDeleteEvent() throws Exception {
        final Event event = new Event(1);
        APIEventsClient.get().deleteEvent(event.getId(), new ServerResponseCallback() {
            @Override
            public void onSuccess(Object responseData, APIResponseStatus responseStatus) {
                System.out.println("onSuccess " + responseStatus.getHttpStatus());
                statusCode = responseStatus.getHttpStatus();
            }

            @Override
            public void onError(APIError apiError) {
                System.out.println("onError");
                assertFalse(apiError.getErrorMessage(), true);
            }
        });
        Thread.sleep(1000);
        assertEquals("API call for deleteEvent failed. Returned HTTP status is not 204 ", 204, statusCode);
        statusCode = 0;
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }
}
