package com.sudin.Utils;

import com.sudin.Pojo.GlobalResponse;

public class BaseUtils {

    // Returns not null value.
    public static <T> T nullValueAlternative(T receivedValue, T loadedValue) {
        if (receivedValue == null) {
            return loadedValue;
        } else {
            return receivedValue;
        }
    }

    public static GlobalResponse respond(String status, String message, Object data) {
        return new GlobalResponse(status, message, data);
    }
}
