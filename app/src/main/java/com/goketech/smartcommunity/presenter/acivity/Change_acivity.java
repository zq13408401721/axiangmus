package com.goketech.smartcommunity.presenter.acivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.goketech.smartcommunity.MainActivity;
import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Change_acivity extends BaseActivity {

    @BindView(R.id.bt_landing)
    Button mBtLanding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_acivity);
        ButterKnife.bind(this);
    }

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_acivity;
    }

    @Override
    protected void initListener() {
        mBtLanding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Change_acivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showError(String errorMsg) {

    }
}
