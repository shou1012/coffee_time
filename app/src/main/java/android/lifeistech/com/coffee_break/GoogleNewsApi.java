package android.lifeistech.com.coffee_break;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GoogleNewsApi {
    @GET("/v2/everything")
    Call<Response> getNews(@Query("q") String keyword, @Query("apiKey") String apiKey);
}
