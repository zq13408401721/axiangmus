package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.interfaces.contract.Verification_Conreacy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Verification_Presenter extends BasePresenter<Verification_Conreacy.View> implements Verification_Conreacy.Presenter {
    @Override
    public void getData_Verification(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_Verification(body)
                .compose(RxUtils.<Verification_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Verification_bean>(mView) {

            @Override
            public void onNext(Verification_bean verification_bean) {
                if (verification_bean!=null){
                    if (mView != null) {
                        mView.getdata_Verification(verification_bean);
                    }
                }
            }
        }));
    }
}
