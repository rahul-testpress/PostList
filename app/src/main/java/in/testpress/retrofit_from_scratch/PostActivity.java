package in.testpress.retrofit_from_scratch;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    public TextView textView;
    public WebView webView;
    String timeAgo;
    String slug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_post);
        Post post = getIntent().getParcelableExtra("Post");

        String title = post.getTitle();
        textView = findViewById(R.id.postTitleView);
        textView.setText(title);

        String summary = post.getSummary();
        textView = findViewById(R.id.postSummaryView);
        textView.setText(summary);

        String publishedDate = post.getPublishedDate();
        timeAgo = DateUtil.dateAbbreviatedInAgo(publishedDate);
        textView = findViewById(R.id.postDateCreatedView);
        textView.setText(timeAgo);

        slug = post.getSlug();
        Call<Post> call = NetworkUtil.retrofitBuilder().getPost(slug);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
            String contentHtml = response.body().getContentHtml();
            webView = findViewById(R.id.webView);
            webView.loadData(contentHtml, "text/html", "UTF-8");
            }
            @Override
            public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
