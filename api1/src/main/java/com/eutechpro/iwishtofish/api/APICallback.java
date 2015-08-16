package com.eutechpro.iwishtofish.api;

import com.eutechpro.iwishtofish.models.APIResponseData;
import com.eutechpro.iwishtofish.models.APIError;
import com.eutechpro.iwishtofish.models.APIResponseStatus;

/**
 * Created by Kursulla on 16/08/15.
 */
public interface APICallback {
    void beforeStart();
    void onSuccess(APIResponseData responseData, APIResponseStatus responseStatus);
    void onError(APIError apiError);
}
