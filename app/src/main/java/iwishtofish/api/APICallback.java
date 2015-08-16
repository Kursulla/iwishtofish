package iwishtofish.api;

import iwishtofish.models.APIError;
import iwishtofish.models.APIResponseData;
import iwishtofish.models.APIResponseStatus;

/**
 * Created by Kursulla on 16/08/15.
 */
public interface APICallback {
    void beforeStart();
    void onSuccess(APIResponseData responseData, APIResponseStatus responseStatus);
    void onError(APIError apiError);
}
