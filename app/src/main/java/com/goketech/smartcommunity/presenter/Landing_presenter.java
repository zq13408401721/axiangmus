package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Landing_bean;
import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.interfaces.contract.Landing_Contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Landing_presenter extends BasePresenter<Landing_Contracy.View> implements Landing_Contracy.Presenter {
    @Override
    public void getData_landing(String id,RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_landing(id,body)
                .compose(RxUtils.<Landing_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Landing_bean>(mView) {

                    @Override
                    public void onNext(Landing_bean landing_bean) {
                        if (landing_bean != null) {
                            if (mView != null) {
                                mView.getdata_landing(landing_bean);
                            }
                        }
                    }
                }));
    }


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
