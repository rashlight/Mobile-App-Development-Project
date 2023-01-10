package vn.edu.usth.ufood.api;

import com.google.gson.annotations.SerializedName;

public class CommentPayload {
    @SerializedName("token")
    private String token;
    @SerializedName("itemId")
    private int itemId;
    @SerializedName("description")
    private String description;
    @SerializedName("rating")
    private float rating;

    public CommentPayload(String token, int itemId, String description, float rating) {
        this.token = token;
        this.itemId = itemId;
        this.description = description;
        this.rating = rating;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
