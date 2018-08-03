package in.testpress.retrofit_from_scratch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {

    public static String getDateAbbreviatedInAgo(String inputDateString){

        String timeAgo;
        long dateNowInMillis = System.currentTimeMillis();
        Date date;

        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                    .parse(inputDateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        long givenMillis = date.getTime();
        final long diff = dateNowInMillis - givenMillis;

        int SECOND_MILLIS = 1000;
        int MINUTE_MILLIS = 60 * SECOND_MILLIS;
        long HOUR_MILLIS = 60 * MINUTE_MILLIS;
        long DAY_MILLIS = 24 * HOUR_MILLIS;
        long WEEK_MILLIS = 7 * DAY_MILLIS;
        long MONTHS_MILLIS = 4 * WEEK_MILLIS;
        long YEARS_MILLIS = 12 * MONTHS_MILLIS;

        if (diff < MINUTE_MILLIS) timeAgo = "just now";
        else if (diff < 2 * MINUTE_MILLIS) timeAgo = "a minute ago";
        else if (diff < 50 * MINUTE_MILLIS) timeAgo =  diff / MINUTE_MILLIS + " minutes ago";
        else if (diff < 90 * MINUTE_MILLIS) timeAgo =  "an hour ago";
        else if (diff < 24 * HOUR_MILLIS) timeAgo =  diff / HOUR_MILLIS + " hours ago";
        else if (diff < 48 * HOUR_MILLIS) timeAgo =  "yesterday";
        else if (diff < 7 * DAY_MILLIS) timeAgo =  diff / DAY_MILLIS + " days ago";
        else if (diff < 14 * DAY_MILLIS) timeAgo =  diff / WEEK_MILLIS + " week ago";
        else if (diff < 4 * WEEK_MILLIS) timeAgo =  diff / WEEK_MILLIS + " weeks ago";
        else if (diff < 2 * MONTHS_MILLIS) timeAgo =  diff / MONTHS_MILLIS + " month ago";
        else if (diff < 12 * MONTHS_MILLIS) timeAgo =  diff / MONTHS_MILLIS + " months ago";
        else if (diff < 2 * YEARS_MILLIS) timeAgo =  diff / YEARS_MILLIS + " year ago";
        else timeAgo = diff / YEARS_MILLIS + " years ago";

        return timeAgo;
    }
}
