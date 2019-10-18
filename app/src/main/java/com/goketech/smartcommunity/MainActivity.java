package com.goketech.smartcommunity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.goketech.smartcommunity.app.Constant;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.Commonality_bean;
import com.goketech.smartcommunity.fragment.Activity_Fragment;
import com.goketech.smartcommunity.fragment.Home_Fragment;
import com.goketech.smartcommunity.fragment.My_Fragment;
import com.goketech.smartcommunity.fragment.Neighborhood_Fragment;
import com.goketech.smartcommunity.interfaces.contract.Dect_Contract;
import com.goketech.smartcommunity.presenter.Dect_presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import okhttp3.FormBody;
import okhttp3.RequestBody;


public class MainActivity extends BaseActivity<Dect_Contract.View,Dect_Contract.Presenter> implements Dect_Contract.View{


    @BindView(R.id.tl)
    TabLayout mTl;
    @BindView(R.id.fl)
    FrameLayout mFl;
    private FragmentManager manager;
    private String house_id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initFragments() {
        manager = getSupportFragmentManager();
        mTl.addTab(mTl.newTab().setText("首页").setIcon(R.mipmap.shouye));
        mTl.addTab(mTl.newTab().setText("邻里").setIcon(R.mipmap.linli));
        mTl.addTab(mTl.newTab().setText("活动").setIcon(R.mipmap.huodong));
        mTl.addTab(mTl.newTab().setText("我的").setIcon(R.mipmap.wode));
    }

    @Override
    protected Dect_Contract.Presenter getPresenter() {
        return new Dect_presenter();
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        house_id = intent.getStringExtra("house_id");
        addFragment(getSupportFragmentManager(), Home_Fragment.class, R.id.fl, null);


    }

    @Override
    protected void initData() {

        Map<String, String> map = new HashMap<>();

        String sign = ASCIIUtils.getSign(map);
        RequestBody requestBody = new FormBody.Builder()
                .add("sign", sign)
                .build();
        mPresenter.getData_Commonality(requestBody);
    }

    @Override
    protected void initListener() {

        mTl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {

                    addFragment(manager, Home_Fragment.class, R.id.fl, null);
                } else if (position == 1) {
                    addFragment(manager, Neighborhood_Fragment.class, R.id.fl, null);
                } else if (position == 2) {
                    addFragment(manager, Activity_Fragment.class, R.id.fl, null);
                } else if (position == 3) {
                    addFragment(manager, My_Fragment.class, R.id.fl, null);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void getdata_Commonality(Commonality_bean commonality_bean) {
        if (commonality_bean!=null){
            int status = commonality_bean.getStatus();
            if (status==0){
                List<Commonality_bean.DataBean.FeedbackBean> feedback = commonality_bean.getData().getFeedback();
                for (int i = 0; i < feedback.size(); i++) {
                    Constant.ids= feedback.get(i).getId();
                }
                List<Commonality_bean.DataBean.RepairBean> repair = commonality_bean.getData().getRepair();
                Constant.list=repair;
                Toast.makeText(MainActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
            }else{
                Log.e("status",status+"");
            }

        }
    }
}
