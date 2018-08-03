package in.testpress.retrofit_from_scratch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomAdapter mAdapter;
    public static final String EXTRA_POST = "EXTRA_POST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                intent.putExtra(EXTRA_POST, mAdapter.getItem(position));
                startActivity(intent);
            }
        });
        getPosts();
    }

    void getPosts() {

        Call<TestpressAPI> call = NetworkUtil.retrofitBuilder().getPosts();
        call.enqueue(new Callback<TestpressAPI>() {
            @Override
            public void onResponse(@NonNull Call<TestpressAPI> call, @NonNull Response<TestpressAPI> response) {
                List<Post> postList = response.body().getResults();
                mAdapter = new CustomAdapter(MainActivity.this, postList);
                listView.setAdapter(mAdapter);
            }
            @Override
            public void onFailure(@NonNull Call<TestpressAPI> call, @NonNull Throwable t) {
            }
        });
    }
}
