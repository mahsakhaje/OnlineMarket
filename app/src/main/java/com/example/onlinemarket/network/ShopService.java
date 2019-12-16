package com.example.onlinemarket.network;

import com.example.onlinemarket.model.Body;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ShopService {
    @GET(".")
    Call<Body>  getBody(@QueryMap Map<String,String> queries);

}
