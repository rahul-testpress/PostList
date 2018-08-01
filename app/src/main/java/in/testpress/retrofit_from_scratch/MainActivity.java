package in.testpress.retrofit_from_scratch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    private customAdapter m_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        singleclicklistener();
        getResults();
    }

    private void singleclicklistener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Intent appInfo = new Intent(MainActivity.this, PostActivity.class);
                startActivity(appInfo);
                 }
        });
    }

    void getResults() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);
        Call<TestpressAPI> call = api.getPosts();
        call.enqueue(new Callback<TestpressAPI>() {
            @Override
            public void onResponse(@NonNull Call<TestpressAPI> call, @NonNull Response<TestpressAPI> response) {
                List<Post> postList = response.body().getResults();
                m_adapter = new customAdapter(MainActivity.this,postList);
                listView.setAdapter(m_adapter);
            }
            @Override
            public void onFailure(@NonNull Call<TestpressAPI> call, @NonNull Throwable t) {
            }
        });
    }
}

