package com.example.onlinemarket.network;

import com.example.onlinemarket.model.categories.CategoryBody;
import com.example.onlinemarket.model.product.ProductBody;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ShopService {


    @GET("products")
    Call<List<ProductBody>> getProducts(@QueryMap Map<String, String> queries);

    @GET("products/categories")
    Call<List<CategoryBody>> getCategory(@QueryMap Map<String, String> queries);

}
