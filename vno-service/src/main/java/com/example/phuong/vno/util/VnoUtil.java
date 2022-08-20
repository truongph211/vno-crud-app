package com.example.phuong.vno.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class VnoUtil {

    public static Timestamp convertToTimestamp(String time) {
        if (time.isEmpty()) {
            return null;
        }
        return Timestamp
                .valueOf(time.replace("T"," ")
                        .replace("Z",""));
    }

    public static String timeStampToString(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        Date systemTime = new Date(timestamp.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(systemTime);

    }
}
