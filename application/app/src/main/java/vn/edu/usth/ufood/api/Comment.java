package vn.edu.usth.ufood.api;

import com.google.gson.annotations.SerializedName;

public class Comment {
    @SerializedName("description")
    private Float description;
    @SerializedName("rating")
    private Float rating;
}
