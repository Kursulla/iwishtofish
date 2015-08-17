package com.iwishtofish.api.api_interfaces;

import com.iwishtofish.api.models.APIError;
import com.iwishtofish.api.models.APIResponseStatus;

/**
 * Created by Kursulla on 16/08/15.
 */
public interface APICallback<T> {
    void beforeStart();
    void onSuccess(T responseData, APIResponseStatus responseStatus);
    void onError(APIError apiError);
}
