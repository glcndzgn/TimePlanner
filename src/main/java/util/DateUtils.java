package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    public static String getTimeInUTC(){
        Date date = new Date();
        int gmtOffset = TimeZone.getDefault().getRawOffset();
        date = new Date(date.getTime() - gmtOffset);
        SimpleDateFormat dateFormatLocal = new SimpleDateFormat("HH:mm:ss");

        return dateFormatLocal.format(date);

    }
    public static String getToday(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd EEEE ");
        return dateFormat.format(new Date());

    }
}
