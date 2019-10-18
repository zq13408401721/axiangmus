package com.goketech.smartcommunity.presenter.acivity;

import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.interfaces.IBasePresenter;

import butterknife.BindView;

public class Start_acivity extends BaseActivity {


    @BindView(R.id.iv_start)
    ImageView mIvStart;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_start_acivity;
    }

    @Override
    protected void initView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Start_acivity.this, Guide_acivity.class);
                startActivity(intent);
            }
        },2000);
    }

    @Override
    public void showError(String errorMsg) {

    }

}
