package com.customshop.back.model.utils;

import java.sql.Timestamp;

public class TimestampUtils {

    public static Timestamp getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }
}
