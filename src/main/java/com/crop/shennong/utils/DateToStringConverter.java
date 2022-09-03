package com.crop.shennong.utils;

import org.modelmapper.AbstractConverter;

import java.time.LocalDateTime;

public class DateToStringConverter extends AbstractConverter<LocalDateTime, String> {
    @Override
    protected String convert(LocalDateTime source) {
        return source == null ? null : source.toString();
    }
}
