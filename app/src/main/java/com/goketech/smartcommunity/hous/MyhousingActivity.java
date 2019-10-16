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

public class MyhousingActivity extends BaseActivity {
    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.tv_myhousing)
    TextView tvMyhousing;
    @BindView(R.id.tv_addhousing)
    TextView tvAddhousing;
    @BindView(R.id.rv_myhousing)
    RecyclerView rvMyhousing;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_myhousing;
    }

    @Override
    public void showError(String errorMsg) {

    }


    @OnClick({R.id.im_back, R.id.tv_addhousing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_back:

                break;
            case R.id.tv_addhousing:
                Intent intent = new Intent(MyhousingActivity.this, HouseholdManagementActivity.class);
                startActivity(intent);
                break;
        }
    }

}
