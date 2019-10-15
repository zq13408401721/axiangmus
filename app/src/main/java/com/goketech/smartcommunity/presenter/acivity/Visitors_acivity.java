package com.goketech.smartcommunity.presenter.acivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.interfaces.IBasePresenter;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Visitors_acivity extends BaseActivity {

    @BindView(R.id.toob_fangke)
    Toolbar mToobFangke;
    @BindView(R.id.fangke)
    TextView mFangke;
    @BindView(R.id.dianhua)
    TextView mDianhua;
    @BindView(R.id.shuliang)
    TextView mShuliang;
    @BindView(R.id.tv_fangshi)
    TextView mTvFangshi;
    @BindView(R.id.dpPicker)
    DatePicker mDpPicker;
    @BindView(R.id.ll_date)
    LinearLayout mLlDate;
    @BindView(R.id.yuanyin)
    TextView mYuanyin;
    @BindView(R.id.et_cause)
    EditText mEtCause;
    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.shiduan)
    TextView shiduan;
    @BindView(R.id.dao)
    TextView dao;
    @BindView(R.id.dpPicker1)
    DatePicker dpPicker1;
    @BindView(R.id.ll_date1)
    LinearLayout llDate1;
    @BindView(R.id.v_xian)
    View vXian;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_visitors_acivity;
    }

    @Override
    protected void initView() {
        mDpPicker.init(2013, 8, 20, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                // 获取一个日历对象，并初始化为当前选中的时间
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth);
            }
        });
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
    public void showError(String errorMsg) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}