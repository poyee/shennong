package com.crop.shennong.exception;

public abstract class CropRuntimeException extends RuntimeException {
    protected String errorMsg;

    public CropRuntimeException(String message) {
        this(message, message);
    }

    public CropRuntimeException(String message, String errorMsg) {
        super(message);
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
