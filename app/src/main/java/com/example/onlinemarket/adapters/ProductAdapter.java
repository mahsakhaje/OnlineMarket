package com.example.onlinemarket.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinemarket.R;
import com.example.onlinemarket.databinding.FragmentHomePageBinding;
import com.example.onlinemarket.databinding.ProductItemBinding;
import com.example.onlinemarket.model.product.ProductBody;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    List<ProductBody> mProducts = new ArrayList<>();
    Context mContext;
    ProductItemBinding mView;

    public void setmProducts(MutableLiveData<List<ProductBody>> products, Context context) {
        mProducts = products.getValue();
        mContext = context;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        mView = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.product_item, parent, false);
        return new ProductHolder(mView.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        holder.bind(mProducts.get(position));
    }


    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder {
        ProductBody mProduct;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);

        }

        public void bind(ProductBody product) {
            mProduct = product;
            Picasso.with(mContext).load(mProduct.getImages().get(0).getSrc()).into(mView.imgProductItem);
            //   mView.imgProductItem.setImageBitmap(product.getImages().get(0).getAlt());
            mView.titleProductItem.setText(product.getName());
            mView.priceProductItem.setText(product.getPrice());

        }
    }
}
