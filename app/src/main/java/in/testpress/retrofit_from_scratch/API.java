package in.testpress.retrofit_from_scratch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {
    String BASE_URL = "https://sandbox.testpress.in/";

    @GET("api/v2.2/posts")
    Call<TestpressAPI> getPosts();

    @GET("api/v2.2/posts/{slug}")
    Call<Post> getPost(@Path("slug") String slug);
}
