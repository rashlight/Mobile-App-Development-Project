package vn.edu.usth.ufood.api;

import com.google.gson.annotations.SerializedName;

public class CartItem {
    @SerializedName("id")
    private int id;
    @SerializedName("itemId")
    private int itemId;
    @SerializedName("userId")
    private String userId;
    @SerializedName("quantity")
    private int quantity;

    public CartItem(int id, int itemId, String userId, int quantity) {
        this.id = id;
        this.itemId = itemId;
        this.userId = userId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
