package com.airkisser.utils.converter;

import org.springframework.core.convert.converter.Converter;


import java.sql.Timestamp;

public class StringToTimestampConverter implements Converter<String,Timestamp>{

    public Timestamp convert(String source){

        if(source==null || source.isEmpty()){
            return null;
        }else {
            try{
                return Timestamp.valueOf(source);
            }
            catch (Exception e){
                throw new RuntimeException("日期转换失败");
            }

        }

    }
}
