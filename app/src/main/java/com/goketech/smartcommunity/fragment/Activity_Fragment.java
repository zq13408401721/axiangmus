package com.goketech.smartcommunity.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.adaper.Acivity_adaper;
import com.goketech.smartcommunity.base.BaseFragment;
import com.goketech.smartcommunity.bean.Acivity_bean;
import com.goketech.smartcommunity.interfaces.contract.Acivity_Cintracy;
import com.goketech.smartcommunity.presenter.Acivity_Presenter;
import com.goketech.smartcommunity.presenter.acivity.Acivity_WebView_acivity;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;
import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class Activity_Fragment extends BaseFragment<Acivity_Cintracy.View, Acivity_Cintracy.Presenter> implements Acivity_Cintracy.View {

    @BindView(R.id.toob_acivity)
    Toolbar mToobAcivity;
    @BindView(R.id.rl)
    RecyclerView mRl;
    private Unbinder unbinder;
    private List<Acivity_bean.DataBean> acivity_beans;
    private Acivity_adaper acivity_adaper;


    @Override
    protected Acivity_Cintracy.Presenter getPresenter() {
        return new Acivity_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_activity_;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getdata_Acivity(final Acivity_bean acivity_bean) {
        if (acivity_bean != null) {
            int status = acivity_bean.getStatus();
            if (status == 0) {
                List<Acivity_bean.DataBean> data = acivity_bean.getData();
                acivity_beans.addAll(data);
                acivity_adaper.notifyDataSetChanged();
            }
        }
        acivity_adaper.setSetRenqi(new Acivity_adaper.SetRenqi() {
            @Override
            public void SetRenqi(ImageView iv, final int p, final int id) {
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), Acivity_WebView_acivity.class);
                        intent.putExtra("Aid", id+"");
                        startActivity(intent);
                    }
                });
            }
        });
    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("company_id", "1");
        map.put("community_id", "1");
        map.put("p", "1");
        map.put("limit", "20");

        String sign = ASCIIUtils.getSign(map);
        RequestBody requestBody = new FormBody.Builder()
                .add("company_id", "1")
                .add("community_id", "1")
                .add("p", "1")
                .add("limit", "20")
                .add("sign", sign)
                .build();
        mPresenter.getData_Acivity(requestBody);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        acivity_beans = new ArrayList<>();
        acivity_adaper = new Acivity_adaper(acivity_beans, getActivity());
        mRl.setAdapter(acivity_adaper);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRl.setLayoutManager(linearLayoutManager);
        acivity_adaper.notifyDataSetChanged();
    }
}
