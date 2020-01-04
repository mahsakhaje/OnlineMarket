package com.example.onlinemarket.view;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlinemarket.R;
import com.example.onlinemarket.adapters.ProductAdapter;
import com.example.onlinemarket.databinding.FragmentHomePageBinding;
import com.example.onlinemarket.model.product.ProductBody;
import com.example.onlinemarket.viewModel.HomeViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment {
    FragmentHomePageBinding mView;
    HomeViewModel mHomeViewModel;

    public HomePageFragment() {
        // Required empty public constructor
    }

    public static HomePageFragment newInstance() {

        Bundle args = new Bundle();

        HomePageFragment fragment = new HomePageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.fragment_home_page, container, false);
        mView.productList.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        ProductAdapter mAdapter = new ProductAdapter();
        mHomeViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);
      //  mAdapter.setmProducts(mHomeViewModel.getProducts(),getActivity());

        mHomeViewModel.getProducts().observe(getActivity(), new Observer<List<ProductBody>>() {
            @Override
            public void onChanged(List<ProductBody> productBodies) {
                mAdapter.setmProducts(mHomeViewModel.getProducts(),getActivity());
                mAdapter.notifyDataSetChanged();
            }
        });
        mView.productList.setAdapter(mAdapter);
        return mView.getRoot();
    }

}
