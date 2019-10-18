package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.MyAcivity_bean;
import com.goketech.smartcommunity.bean.Neighbourhood_bean;
import com.goketech.smartcommunity.bean.QR_bean;
import com.goketech.smartcommunity.interfaces.contract.MyAcivity_Contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class MyAcivitys_Presenter extends BasePresenter<MyAcivity_Contracy.View> implements MyAcivity_Contracy.Presenter {
    @Override
    public void getData_MyAcivity(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_MyAcivity_(body)
                .compose(RxUtils.<MyAcivity_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<MyAcivity_bean>(mView) {
                    @Override
                    public void onNext(MyAcivity_bean myAcivity_bean) {
                        if (myAcivity_bean != null) {
                            if (mView != null) {
                                mView.getdata_MyAcivity(myAcivity_bean);
                            }
                        }
                    }
                }));
    }
}
