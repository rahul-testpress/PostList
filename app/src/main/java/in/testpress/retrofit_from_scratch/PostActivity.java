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

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_post);
        Post post = getIntent().getParcelableExtra(MainActivity.EXTRA_POST);

        TextView textView = findViewById(R.id.postTitleView);
        textView.setText(post.getTitle());

        textView = findViewById(R.id.postSummaryView);
        textView.setText(post.getSummary());

        String timeAgo = DateUtil.getDateAbbreviatedInAgo(post.getPublishedDate());
        textView = findViewById(R.id.postDateCreatedView);
        textView.setText(timeAgo);

        Call<Post> call = NetworkUtil.retrofitBuilder().getPost(post.getSlug());
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
