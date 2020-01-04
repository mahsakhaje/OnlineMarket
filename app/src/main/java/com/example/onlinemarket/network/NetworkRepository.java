package com.example.onlinemarket.network;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.onlinemarket.model.categories.CategoryBody;
import com.example.onlinemarket.model.product.CategoriesItem;
import com.example.onlinemarket.model.product.ProductBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkRepository {
    private static final String TAG = "NetworkRepository";
    public static final String BaseUrl = "https://woocommerce.maktabsharif.ir/wp-json/wc/v3/";
    public static final String PRODUCT_KEY = "ck_255dd18ba1125827389f07a4e0f3982a14bc926f";
    public static final String CUNSUMER_SECRET = "cs_02e595bb738b6ff45646c6ed8ae6a1cf1b5f1fd6";
    private static NetworkRepository instance;
    private Map<String, String> mQueries;
    private Retrofit mRetrofit;
    ShopService mService;
    private MutableLiveData<List<ProductBody>> mProductList=new MutableLiveData<>();
    private MutableLiveData<List<CategoryBody>> mCategoryList=new MutableLiveData<>();

    public MutableLiveData<List<ProductBody>> getmProductList() {
        return mProductList;
    }

    public MutableLiveData<List<CategoryBody>> getmCategoryList() {
        return mCategoryList;
    }

    public static NetworkRepository getInstance() {
        if (instance == null)
            instance = new NetworkRepository();
        return instance;
    }

    private NetworkRepository() {
        mQueries = new HashMap<>();
        mQueries.put("consumer_key", PRODUCT_KEY);
        mQueries.put("consumer_secret", CUNSUMER_SECRET);
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService = mRetrofit.create(ShopService.class);

    }
    public void getProducts(){
        mService.getProducts(mQueries).enqueue(new Callback<List<ProductBody>>() {
            @Override
            public void onResponse(Call<List<ProductBody>> call, Response<List<ProductBody>> response) {
                mProductList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ProductBody>> call, Throwable t) {
                Log.e(TAG, "onFailure: ",t );
            }
        });

    }
    public void getCategories(){
        mService.getCategory(mQueries).enqueue(new Callback<List<CategoryBody>>() {
            @Override
            public void onResponse(Call<List<CategoryBody>> call, Response<List<CategoryBody>> response) {
                mCategoryList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CategoryBody>> call, Throwable t) {
                Log.e(TAG, "onFailure: ",t );
            }
        });
    }
    public void getPopularProducts(){
        Map<String,String> queryPopular=new HashMap();
        queryPopular=mQueries;
    }
}
