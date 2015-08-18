package com.iwishtofish.data;

import com.iwishtofish.api.models.APIError;

/**
 *
 * Created by Kursulla on 12/08/15.
 */
public interface ApiCallback<T> {
    void beforeStart();
    void onSuccess(T resultData);
    void onError(APIError apiError);
}
