package com.iwishtofish.api.models;

import java.util.List;

/**
 * Created by Kursulla on 16/08/15.
 */
public class Events extends APIResponseData {
    private int         offset;
    private int         limit;
    private List<Event> items;

    public Events(long id) {
        super(id);
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public List<Event> getItems() {
        return items;
    }
}
