package com.goketech.smartcommunity.hous;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;


import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class BuildingActivity extends BaseActivity {
    @BindView(R.id.iv_build_back)
    ImageView ivBuildBack;
    @BindView(R.id.rv_huild)
    RecyclerView rvHuild;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_building;
    }

    @Override
    public void showError(String errorMsg) {

    }



    @OnClick(R.id.iv_build_back)
    public void onViewClicked() {
        startActivity(new Intent(BuildingActivity.this,BIndHouseActivity.class));
    }


}
