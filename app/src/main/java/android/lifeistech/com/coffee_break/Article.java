package android.lifeistech.com.coffee_break;

import com.google.gson.annotations.SerializedName;

public class Article {
    @SerializedName("title")
    String title;
    @SerializedName("author")
    String author;
    @SerializedName("description")
    String description;
    @SerializedName("publishedAt")
    String publishedAt;


}
