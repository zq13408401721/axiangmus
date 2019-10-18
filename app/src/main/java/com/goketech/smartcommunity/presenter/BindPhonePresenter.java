package com.goketech.smartcommunity.presenter;


import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Landing_bean;
import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.interfaces.contract.BindPhone_Conreacy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class BindPhonePresenter extends BasePresenter<BindPhone_Conreacy.View> implements BindPhone_Conreacy.Presenter {

    @Override
    public void getData_Verification(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_Verification(body)
                .compose(RxUtils.<Verification_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Verification_bean>(mView) {

                    @Override
                    public void onNext(Verification_bean verification_bean) {
                        if (verification_bean!=null){
                            if (mView != null) {
                                mView.getdata_Code(verification_bean);
                            }
                        }
                    }
                }));
    }

    @Override
    public void login(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_landing("3",body).compose(RxUtils.<Landing_bean>rxScheduler()).subscribeWith(new CommonSubscriber<Landing_bean>(mView) {
            @Override
            public void onNext(Landing_bean landing_bean) {
                if (landing_bean!=null){
                    if (mView != null) {
                        mView.loginReturn(landing_bean);
                    }
                }
            }
        }));
    }
}
