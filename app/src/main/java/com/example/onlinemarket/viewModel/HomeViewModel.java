package com.example.onlinemarket.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.onlinemarket.model.categories.CategoryBody;
import com.example.onlinemarket.model.product.ProductBody;
import com.example.onlinemarket.network.NetworkRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    NetworkRepository mRepository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        mRepository = NetworkRepository.getInstance();
        mRepository.getProducts();
    }

    public MutableLiveData<List<ProductBody>> getProducts() {
        return mRepository.getmProductList();
    }
    public MutableLiveData<List<CategoryBody>> getCategories() {
        return mRepository.getmCategoryList();
    }
}
