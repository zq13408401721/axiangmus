package com.goketech.smartcommunity.fragment.repair_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.adaper.Receiving_adaper;
import com.goketech.smartcommunity.base.BaseFragment;
import com.goketech.smartcommunity.bean.All_bean;
import com.goketech.smartcommunity.interfaces.contract.All_Contracy;
import com.goketech.smartcommunity.presenter.All_presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.FormBody;
import okhttp3.RequestBody;


public class Evaluation_frahment extends BaseFragment<All_Contracy.View, All_Contracy.Presenter> implements All_Contracy.View {

    @BindView(R.id.fl)
    RecyclerView fl;
    Unbinder unbinder;
    private String community_id;
    private ArrayList<All_bean.DataBean> dataBeans1;
    private Receiving_adaper receiving_adaper;

    @Override
    protected All_Contracy.Presenter getPresenter() {
        return new All_presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_evaluation_frahment;
    }

    @Override
    protected void initFragments() {
        Intent intent = getActivity().getIntent();
        community_id = intent.getStringExtra("community_id");
    }

    @Override
    protected void initView() {
        dataBeans1 = new ArrayList<>();
        receiving_adaper = new Receiving_adaper(dataBeans1, getActivity());
        fl.setAdapter(receiving_adaper);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        fl.setLayoutManager(linearLayoutManager);
        receiving_adaper.notifyDataSetChanged();

    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("community_id", community_id);
        map.put("status", "0");

        String sign = ASCIIUtils.getSign(map);
        RequestBody requestBody = new FormBody.Builder()
                .add("status", "0")
                .add("community_id", community_id)
                .add("sign", sign)
                .build();
        mPresenter.getData_All(requestBody);
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void getdata_All(All_bean all_bean) {
        if (all_bean != null) {
            int status = all_bean.getStatus();
            if (status == 0) {
                List<All_bean.DataBean> data = all_bean.getData();
                dataBeans1.addAll(data);
                receiving_adaper.notifyDataSetChanged();
                Toast.makeText(getActivity(), "待接单", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
