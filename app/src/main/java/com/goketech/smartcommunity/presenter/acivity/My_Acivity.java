package com.goketech.smartcommunity.presenter.acivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.adaper.MyAcivity_adaper;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.MyAcivity_bean;
import com.goketech.smartcommunity.interfaces.contract.MyAcivity_Contracy;
import com.goketech.smartcommunity.presenter.MyAcivitys_Presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class My_Acivity extends BaseActivity<MyAcivity_Contracy.View, MyAcivity_Contracy.Presenter> implements MyAcivity_Contracy.View {

    @BindView(R.id.fl)
    RecyclerView fl;
    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.fang)
    TextView fang;
    @BindView(R.id.tl)
    Toolbar tl;
    private MyAcivity_adaper myAcivity_adaper;
    private ArrayList<MyAcivity_bean.DataBean> dataBeans;

    @Override
    protected MyAcivity_Contracy.Presenter getPresenter() {
        return new MyAcivitys_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my__acivity;
    }

    @Override
    protected void initFragments() {

    }

    @Override
    protected void initView() {
        dataBeans = new ArrayList<>();
        myAcivity_adaper = new MyAcivity_adaper(dataBeans, My_Acivity.this);
        fl.setAdapter(myAcivity_adaper);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(My_Acivity.this);
        fl.setLayoutManager(linearLayoutManager);
        myAcivity_adaper.notifyDataSetChanged();
    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();

        String sign = ASCIIUtils.getSign(map);
        RequestBody requestBody = new FormBody.Builder()
                .add("sign", sign)
                .build();
        mPresenter.getData_MyAcivity(requestBody);
    }

    @Override
    protected void initListener() {
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void getdata_MyAcivity(MyAcivity_bean myAcivity_bean) {
        if (myAcivity_bean != null) {
            int status = myAcivity_bean.getStatus();
            if (status == 0) {
                List<MyAcivity_bean.DataBean> data = myAcivity_bean.getData();
                dataBeans.addAll(data);
                myAcivity_adaper.notifyDataSetChanged();
                Toast.makeText(My_Acivity.this, "您参加的活动", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void showError(String errorMsg) {

    }
}
