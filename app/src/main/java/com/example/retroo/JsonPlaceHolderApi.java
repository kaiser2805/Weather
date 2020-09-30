package com.example.retroo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface    JsonPlaceHolderApi {

    @Headers({"Content-Type:application/json","Authorization:apikey 7huZQ0yhbXOJxCA9eL8x5j:1kFKVJ2LaB8pgJDa5zc5cS"})
    @GET("/weather/getWeather")
    Call<Main> getPosts(@Query("data.lang") String lang , @Query("data.city") String city);
}
