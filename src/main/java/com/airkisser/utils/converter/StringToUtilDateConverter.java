package com.airkisser.utils.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToUtilDateConverter implements Converter<String, Date> {

    public Date convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        } else {
            Date date = null;
            try {
                date = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").parse(source);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }
    }
}
