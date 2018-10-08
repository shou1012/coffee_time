package android.lifeistech.com.coffee_break;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Response {
    @SerializedName("status")
    String status;
    @SerializedName("totalResults")
    int totalResults;
    @SerializedName("articles")
    List<Article> articles;

    public List<Article> getArticle() {
        return articles;
    }
}