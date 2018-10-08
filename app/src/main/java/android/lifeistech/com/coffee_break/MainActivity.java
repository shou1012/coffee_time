package android.lifeistech.com.coffee_break;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    //ListView周り
    List<Article> articles;
    ArticleAdapter articleAdapter;
    ListView listView;
    //タイマー
    CountDownTimer countDownTimer;
    long time = 600000;
    //API周り
    String keyword    = "today";
    String apiKey = "a7bea8a54a1b41ccaac039d644451560";

    TextView textView;
    TextView tv;

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);


        countDownTimer = new CountDownTimer(time, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                time = millisUntilFinished;
                int min = (int)millisUntilFinished /60000;
                int t = (int) (millisUntilFinished - min * 60000)/ 1000;
                ((TextView) findViewById(R.id.tv)).setText(min + ":" + t);
            }
            @Override public void onFinish(){
                finish();
            }
        };

        countDownTimer.start();

        GoogleNewsApi service = retrofit.create(GoogleNewsApi.class);

        final Call<Response> repos = service.getNews(keyword, apiKey);

        repos.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Response item = response.body();
                ArticleAdapter articleAdapter = new ArticleAdapter(MainActivity.this, R.layout.post, item.articles);
                listView.setAdapter(articleAdapter);
                Log.d("DEBUGG", response.body().toString());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

    }

}
