package in.testpress.retrofit_from_scratch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class CustomAdapter extends ArrayAdapter<Post> {
    CustomAdapter(Context context, List<Post> listOfPosts) {
        super(context, 0, listOfPosts);
    }

    @NonNull
    @Override
    public View getView(int position, View view, @NonNull ViewGroup parent) {

        String timeAgo;
        final int SECOND_MILLIS = 1000;
        final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
        final long HOUR_MILLIS = 60 * MINUTE_MILLIS;
        final long DAY_MILLIS = 24 * HOUR_MILLIS;
        final long WEEK_MILLIS = 7 * DAY_MILLIS;
        final long MONTHS_MILLIS = 4 * WEEK_MILLIS;
        final long YEARS_MILLIS = 12 * MONTHS_MILLIS;
        Post post = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_layout, parent, false);
        }
        TextView titleView = view.findViewById(R.id.title);
        titleView.setText(post.getTitle());

        TextView summaryView = view.findViewById(R.id.summary);
        summaryView.setText(post.getSummary());

        String publishedDateString = post.getPublishedDate();
        Date publishedDateInMillis= null;
        try {
            publishedDateInMillis = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                    .parse(publishedDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long dateNowInMillis = System.currentTimeMillis();
        long millis = publishedDateInMillis.getTime();
        final long diff = dateNowInMillis - millis;

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
        else if (diff < 2 * YEARS_MILLIS) timeAgo =  diff / YEARS_MILLIS + " Year ago";
        else timeAgo = diff/YEARS_MILLIS + " years ago";

        TextView dateView = view.findViewById(R.id.date_created);
        dateView.setText(timeAgo);
        return view;

    }

}