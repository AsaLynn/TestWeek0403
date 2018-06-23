package com.hankkin.compustrading.test.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.demonstrate.DemonstrateUtil;
import com.example.demonstrate.utils.LogUtils;
import com.google.gson.Gson;
import com.hankkin.compustrading.R;
import com.hankkin.compustrading.model.Product;
import com.hankkin.compustrading.test.adapter.ProductInfoAdapter;
import com.hankkin.compustrading.test.bean.ImageInfo;
import com.hankkin.compustrading.test.bean.ProductInfo;
import com.hankkin.compustrading.test.http.RetrofitServer;
import com.hankkin.compustrading.test.utils.UC;
import com.hankkin.compustrading.view.RefreshLayout;
import com.hankkin.compustrading.view.floatbutton.FloatingActionsMenu;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
public class Test1Fragment extends Fragment {
    private RefreshLayout swipeRefreshLayout;
    private ListView lvProduct;
    private List<Product> productList = new ArrayList<>();
    private int cid = 0;
    private ProductInfoAdapter adapter;
    private FloatingActionsMenu fab;
    private Gson gson;
    private String url;
    private ImageInfo imageInfo;

    private void request(int cid) {
        url = UC.URL_TAB0;
        if (cid == 0) {
            url = UC.URL_TAB0;
        } else if (cid == 1) {
            url = UC.URL_TAB1;
        } else if (cid == 2) {
            url = UC.URL_TAB2;
        } else if (cid == 3) {
            url = UC.URL_TAB3;
        } else if (cid == 4) {
            url = UC.URL_TAB4;
        }
        new Retrofit
                .Builder()
                .baseUrl(UC.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitServer.class)
                .getProductInfos(url)
                .enqueue(new Callback<List<ProductInfo>>() {
                    @Override
                    public void onResponse(Call<List<ProductInfo>> call, Response<List<ProductInfo>> response) {
                        List<ProductInfo> infos = response.body();
                        LogUtils.i(infos.toString());
//                        toGson(infos);
                        adapter = new ProductInfoAdapter(infos, getActivity());
                        lvProduct.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<ProductInfo>> call, Throwable t) {

                    }
                });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        requestImg();
        request(cid);
    }

    private void requestImg() {
        new Retrofit
                .Builder()
                .baseUrl(UC.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitServer.class)
                .getImageInfo(UC.URL_IMG)
                .enqueue(new Callback<ImageInfo>() {
                    @Override
                    public void onResponse(Call<ImageInfo> call, Response<ImageInfo> response) {
                        imageInfo = response.body();
                        LogUtils.i(imageInfo.toString());
                        request(cid);
                    }

                    @Override
                    public void onFailure(Call<ImageInfo> call, Throwable t) {

                    }
                });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gson = new Gson();
        if (getArguments() != null) {
            cid = getArguments().getInt("cid");
            productList.clear();
        }
    }

    private void toGson(List<ProductInfo> data) {
        ArrayList<ProductInfo> infos = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            ProductInfo product = data.get(i);
            ProductInfo info = new ProductInfo();
            info.setCid(product.getCid());
            info.setDesc(product.getDesc());
            info.setId(product.getId());
            info.setName(product.getName());
            info.setPrice(product.getPrice());
            info.setSchool(product.getSchool());

//            info.setProduct_url(product.getProduct_url());
            info.setUser_icon_url(product.getUser_icon_url());
            if (cid == 0) {
                info.setProduct_url(imageInfo.getData().get(i).getPicture());
            } else if (cid == 1) {
                int index = i + 5;
                if (index > imageInfo.getData().size() - 1) {
                    index = 0;
                }
                info.setProduct_url(imageInfo.getData().get(index).getPicture());
            } else if (cid == 2) {
                int index = i + 10;
                if (index > imageInfo.getData().size() - 1) {
                    index = 0;
                }
                info.setProduct_url(imageInfo.getData().get(index).getPicture());
            } else {
                int index = i + 15;
                if (index > imageInfo.getData().size() - 1) {
                    index = 0;
                }
                info.setProduct_url(imageInfo.getData().get(index).getPicture());
            }
            info.setUsername(product.getUsername());
            info.setUser_tel(product.getUser_tel());
            info.setCreatedAt(product.getCreatedAt());
            infos.add(info);
        }

        String json = gson.toJson(infos);
        LogUtils.i(json);
        DemonstrateUtil.showLogResult(json);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        lvProduct = (ListView) view.findViewById(R.id.lv_product);
    }

    public void setFab(FloatingActionsMenu fab) {
        this.fab = fab;
    }

    public void hideFab() {
        fab.toggle();
    }

}


