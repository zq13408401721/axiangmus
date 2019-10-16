package com.goketech.smartcommunity.hous;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class HouseholdManagementActivity extends BaseActivity {


    @BindView(R.id.iv_back_household)
    ImageView ivBackHousehold;
    @BindView(R.id.tv_addhousehold)
    TextView tvAddhousehold;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.rv_mananagement)
    RecyclerView rvMananagement;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_household_management;
    }

    @Override
    public void showError(String errorMsg) {

    }


    @OnClick({R.id.iv_back_household, R.id.tv_addhousehold, R.id.tv_name})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back_household: //返回
                startActivity(new Intent(HouseholdManagementActivity.this, MyhousingActivity.class));
                break;
            case R.id.tv_addhousehold:  //添加住户
                startActivity(new Intent(HouseholdManagementActivity.this, BIndHouseActivity.class));

                break;
            case R.id.tv_name:
                break;
        }
    }


}
