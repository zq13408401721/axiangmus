package com.goketech.smartcommunity.presenter.acivity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.fragment.information.Broadcast_Fragment;
import com.goketech.smartcommunity.fragment.information.Inform_Fragment;
import com.goketech.smartcommunity.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Inform_acivity extends BaseActivity {


    @BindView(R.id.inform)
    TextView mInform;
    @BindView(R.id.broadcast)
    TextView mBroadcast;
    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.fl_Inform)
    FrameLayout flInform;
    private FragmentManager manager;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_inform_acivity;
    }

    @Override
    protected void initView() {
        manager = getSupportFragmentManager();
        addFragment(getSupportFragmentManager(), Inform_Fragment.class, R.id.fl_Inform, null);

    }

    @Override
    protected void initListener() {
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mInform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(getSupportFragmentManager(), Inform_Fragment.class, R.id.fl_Inform, null);
            }
        });
        mBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(getSupportFragmentManager(), Broadcast_Fragment.class, R.id.fl_Inform, null);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
