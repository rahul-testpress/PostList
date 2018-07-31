package in.testpress.retrofit_from_scratch;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = "https://sandbox.testpress.in/";

    @GET("api/v2.2/posts")
    Call<TestpressAPI> getResults();

}
