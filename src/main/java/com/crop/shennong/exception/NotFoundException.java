package com.crop.shennong.exception;

public class NotFoundException extends CropRuntimeException {
    public NotFoundException(String message, String errorMsg) {
        super(message, errorMsg);
    }

    public NotFoundException(String message) {
        super(message);
    }
}
