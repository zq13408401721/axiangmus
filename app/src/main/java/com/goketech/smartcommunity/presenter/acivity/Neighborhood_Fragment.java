package com.goketech.smartcommunity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.adaper.Neighbourhood_adaper;
import com.goketech.smartcommunity.base.BaseFragment;
import com.goketech.smartcommunity.bean.Neighbourhood_bean;
import com.goketech.smartcommunity.interfaces.contract.Neighbourhood_Contract;
import com.goketech.smartcommunity.presenter.Neighbourhood_Presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class Neighborhood_Fragment extends BaseFragment<Neighbourhood_Contract.View,Neighbourhood_Contract.Presenter> implements Neighbourhood_Contract.View {

    @BindView(R.id.message)
    TextView message;
    @BindView(R.id.fl)
    RecyclerView fl;
    Unbinder unbinder;
    private String android_code = "a01973b3-38a2-4260-8caa-00c4b53e6d86";
    private Neighbourhood_adaper neighbourhood_adaper;
    private ArrayList<Neighbourhood_bean.DataBean> dataBeans;

    @Override
    protected Neighbourhood_Contract.Presenter getPresenter() {
        return new Neighbourhood_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_neighborhood_;
    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("community_id", "1");
        String sign = ASCIIUtils.getSign(map);
        RequestBody requestBody = new FormBody.Builder()

                .add("community_id", "1")
                .add("sign", sign)
                .build();
        mPresenter.getData_neighbourhood(requestBody);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        dataBeans = new ArrayList<>();
        neighbourhood_adaper = new Neighbourhood_adaper(dataBeans, getActivity());
        fl.setAdapter(neighbourhood_adaper);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        fl.setLayoutManager(linearLayoutManager);
        neighbourhood_adaper.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getdata_neighbourhood(Neighbourhood_bean neighbourhood_bean) {
        if (neighbourhood_bean!=null){
            int status = neighbourhood_bean.getStatus();
            if (status==1){
                List<Neighbourhood_bean.DataBean> data = neighbourhood_bean.getData();
                dataBeans.addAll(data);
                neighbourhood_adaper.notifyDataSetChanged();
            }else{
                Toast.makeText(getActivity(), neighbourhood_bean.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
