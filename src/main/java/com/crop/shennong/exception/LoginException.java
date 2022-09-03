package com.crop.shennong.exception;

public class LoginException extends CropRuntimeException {
    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, String errorMsg) {
        super(message, errorMsg);
    }
}
