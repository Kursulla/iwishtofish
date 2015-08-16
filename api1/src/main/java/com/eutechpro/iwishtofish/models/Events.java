package com.eutechpro.iwishtofish.models;

import java.util.List;

/**
 * Created by Kursulla on 16/08/15.
 */
public class Events extends APIResponseData {
    private int         offset;
    private int         limit;
    private List<Event> items;

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
