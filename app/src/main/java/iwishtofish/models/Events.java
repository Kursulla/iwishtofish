package iwishtofish.models;

import java.util.List;

/**
 * Created by Kursulla on 16/08/15.
 */
public class Events extends APIResponseData {
    private int page;
    private int offset;
    private List<Event> items;
}
