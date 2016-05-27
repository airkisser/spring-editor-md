package com.airkisser.utils.converter;

import org.springframework.core.convert.converter.Converter;

import java.sql.Date;

public class StringToDateConverter implements Converter<String, Date> {
    public Date convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        } else {
            return Date.valueOf(source);
        }
    }
}
