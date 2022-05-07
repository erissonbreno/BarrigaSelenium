package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static String getDateDiferenceDays(Integer qttDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, qttDays);
        return getFormattedDate(calendar.getTime());
    }

    public static String getFormattedDate(Date date) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(date);
    }
}
