package com.goketech.smartcommunity.fragment.Come;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseFragment;
import com.goketech.smartcommunity.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Time_fragment extends BaseFragment {

    @BindView(R.id.shiduan)
    TextView shiduan;
    @BindView(R.id.dpPicker)
    DatePicker dpPicker;
    @BindView(R.id.dao)
    TextView dao;
    @BindView(R.id.dpPicker1)
    DatePicker dpPicker1;
    Unbinder unbinder;
    private int nian;
    private int yue;
    private int ri;

    @Override
    protected void initView() {

    }

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_time_fragment;
    }

/*    //接口回调
    public void dpPicker1(CallBack callBack) {
        String msg = etNumber.getText().toString();
        callBack.getResult(msg);
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public interface CallBack {
        public void getResult(String dpPicker1);
    }

}
