package com.sudin.Utils;

public class BaseUtils {

    // Returns not null value.
    public static <T> T nullValueAlternative(T receivedValue, T loadedValue) {
        if (receivedValue == null) {
            return loadedValue;
        } else {
            return receivedValue;
        }
    }
}
