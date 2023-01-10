package vn.edu.usth.ufood.api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import vn.edu.usth.ufood.Cart;
import vn.edu.usth.ufood.utils.StubData;

public interface APISchema {
    @GET("users")
    Call<UserTokenResult> login(@Query("username") String username, @Query("password") String password);

    @GET("item")
    Call<ArrayList<Item>> getAllItems();

    @GET("cart")
    Call<ArrayList<CartItem>> getCartItems(@Query("token") String token);

    @GET("order")
    Call<ArrayList<Order>> getOrders(@Query("token") String token);

    @GET("comments")
    Call<ArrayList<Comment>> getComments(@Query("token") String token, @Query("itemId") int itemId);

    @POST("comments")
    Call<Comment> addComment(@Body CommentPayload comment);

    @POST("users/create")
    Call<String> addUser(@Body UserInfo user);

    @POST("checkout")
    Call<String> checkout(@Query("token") String token);
}
