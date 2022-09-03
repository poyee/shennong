package com.crop.shennong.exception;

import com.crop.shennong.response.Acknowledgement;
import com.crop.shennong.response.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Acknowledgement notFound(NotFoundException ex) {
        return ResponseUtils.notFound(ex);
    }

    @ResponseBody
    @ExceptionHandler(ResourceConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Acknowledgement conflict(ResourceConflictException ex) {
        return ResponseUtils.conflict(ex);
    }

    @ResponseBody
    @ExceptionHandler(LoginException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Acknowledgement loginError(LoginException ex) {
        return ResponseUtils.forbidden(ex);
    }
}
