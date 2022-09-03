package com.crop.shennong.response;

public class ResponseUtils {
    public static Acknowledgement ok(Object rtnObj) {
        return Acknowledgement.builder()
                .ok(true)
                .statusCode(200)
                .rtnObj(rtnObj)
                .build();
    }

    public static Acknowledgement ack(String errorMsg, int statusCode) {
        return Acknowledgement.builder()
                .ok(false)
                .statusCode(statusCode)
                .errorMsg(errorMsg)
                .build();
    }
}
