package com.goketech.smartcommunity.fragment.repair_fragment;


import android.support.v4.app.Fragment;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseFragment;
import com.goketech.smartcommunity.interfaces.contract.All_Contracy;
import com.goketech.smartcommunity.presenter.All_presenter;

import okhttp3.RequestBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class All_Fragment extends BaseFragment<All_Contracy.View,All_Contracy.Presenter> implements All_Contracy.Presenter {

    @Override
    protected All_Contracy.Presenter getPresenter() {
        return new All_presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_all_;
    }

    @Override
    public void getData_All(RequestBody body) {

    }

    @Override
    public void attchView(All_Contracy.View view) {

    }

    @Override
    public void detachView() {

    }
}
