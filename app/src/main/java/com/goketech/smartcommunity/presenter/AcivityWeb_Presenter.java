package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Acivity_Web_bean;
import com.goketech.smartcommunity.bean.Apply_bean;
import com.goketech.smartcommunity.interfaces.contract.AcivityWeb_Contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class AcivityWeb_Presenter extends BasePresenter<AcivityWeb_Contracy.View> implements AcivityWeb_Contracy.Presenter {

    @Override
    public void getData_AcivityWeb(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_Acivity_Web(body)
                .compose(RxUtils.<Acivity_Web_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Acivity_Web_bean>(mView) {

                    @Override
                    public void onNext(Acivity_Web_bean acivity_web_bean) {
                        if (acivity_web_bean != null) {
                            if (mView != null) {
                                mView.getdata_AcivityWeb(acivity_web_bean);
                            }
                        }
                    }
                }));
    }

    @Override
    public void getData_apply(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_apply(body)
                .compose(RxUtils.<Apply_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Apply_bean>(mView) {

                    @Override
                    public void onNext(Apply_bean apply_bean) {
                        if (apply_bean != null) {
                            if (mView != null) {
                                mView.getdata_apply(apply_bean);
                            }
                        }
                    }
                }));
    }
}
