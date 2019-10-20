package com.goketech.smartcommunity.presenter.acivity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.app.Constant;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.fragment.repair_fragment.All_Fragment;
import com.goketech.smartcommunity.fragment.repair_fragment.Evaluation_frahment;
import com.goketech.smartcommunity.fragment.repair_fragment.Orders_fragment;
import com.goketech.smartcommunity.fragment.repair_fragment.Processing_fragment;
import com.goketech.smartcommunity.interfaces.IBasePresenter;

import butterknife.BindView;

public class Repair_list_acivity extends BaseActivity {


    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.fang)
    TextView fang;
    @BindView(R.id.tl)
    Toolbar tl;
    @BindView(R.id.tb)
    TabLayout tb;
    @BindView(R.id.fl)
    FrameLayout fl;
    private FragmentManager manager;
    private String community_id;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_repair_list_acivity;
    }

    @Override
    protected void initFragments() {

        manager = getSupportFragmentManager();
        tb.addTab(tb.newTab().setText("全部"));
        tb.addTab(tb.newTab().setText("待结单"));
        tb.addTab(tb.newTab().setText("处理中"));
        tb.addTab(tb.newTab().setText("已完成"));
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        community_id = intent.getStringExtra("community_id");
        Log.e("idsa",community_id+id);
        addFragment(manager, All_Fragment.class, R.id.fl, null);

        String a= Constant.id;
        if (a.equals("1")){
            addFragment(manager, Evaluation_frahment.class, R.id.fl, null);
        }else if (a.equals("2")){
            addFragment(manager, Orders_fragment.class, R.id.fl, null);
        }else if (a.equals("3")) {
            addFragment(manager, Processing_fragment.class, R.id.fl, null);
        }
}

    @Override
    protected void initListener() {
        tb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    addFragment(manager, All_Fragment.class, R.id.fl, null);
                } else if (position == 1) {
                    addFragment(manager, Evaluation_frahment.class, R.id.fl, null);
                } else if (position == 2) {
                    addFragment(manager, Orders_fragment.class, R.id.fl, null);
                } else if (position == 3) {
                    addFragment(manager, Processing_fragment.class, R.id.fl, null);
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
    protected void initData() {

    }

    @Override
    protected void initView() {

    }



    @Override
    public void showError(String errorMsg) {

    }
}
