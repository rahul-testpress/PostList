package in.testpress.retrofit_from_scratch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PostListAdapter extends ArrayAdapter<Post> {

    PostListAdapter(Context context, List<Post> listOfPosts) {
        super(context, 0, listOfPosts);
    }

    @NonNull
    @Override
    public View getView(int position, View view, @NonNull ViewGroup parent) {

        String timeAgo;
        Post post = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_layout, parent, false);
        }
        TextView titleView = view.findViewById(R.id.title);
        titleView.setText(post.getTitle());

        TextView summaryView = view.findViewById(R.id.summary);
        summaryView.setText(post.getSummary());

        timeAgo = DateUtil.getDateAbbreviatedInAgo(post.getPublishedDate());
        TextView dateView = view.findViewById(R.id.date_created);
        dateView.setText(timeAgo);
        return view;
    }
}
