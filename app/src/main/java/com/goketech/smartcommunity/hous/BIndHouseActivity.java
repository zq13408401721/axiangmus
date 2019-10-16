package com.goketech.smartcommunity.hous;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class BIndHouseActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_identity)
    TextView tvIdentity;
    @BindView(R.id.tv_build)
    TextView tvBuild;
    @BindView(R.id.tv_unit)
    TextView tvUnit;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_roomse)
    TextView tvRoomse;
    @BindView(R.id.btn_confirm)
    TextView btnconfirm;


    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_house;
    }

    @Override
    public void showError(String errorMsg) {

    }


    @OnClick({R.id.iv_back, R.id.tv_identity, R.id.tv_build, R.id.tv_unit, R.id.tv_roomse})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back://返回 住户管理
                startActivity(new Intent(BIndHouseActivity.this, HouseholdManagementActivity.class));
                break;
            case R.id.tv_identity:
                break;
            case R.id.tv_build: //楼宇选择
                startActivity(new Intent(BIndHouseActivity.this, BuildingActivity.class));

                break;
            case R.id.tv_unit:
                break;
            case R.id.tv_roomse:
                break;
            case R.id.btn_confirm: //确定

                break;
        }
    }


}
