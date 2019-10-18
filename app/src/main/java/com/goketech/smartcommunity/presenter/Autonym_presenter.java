package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Autonym_bean;
import com.goketech.smartcommunity.bean.Binding_bean;
import com.goketech.smartcommunity.interfaces.contract.Autonym_Contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Autonym_presenter extends BasePresenter<Autonym_Contracy.View> implements Autonym_Contracy.Presenter {

    @Override
    public void getData_Autonym(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_Autonym(body)
                .compose(RxUtils.<Autonym_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Autonym_bean>(mView) {
                    @Override
                    public void onNext(Autonym_bean autonym_bean) {
                        if (autonym_bean != null) {
                            if (mView != null) {
                                mView.getdata_Autonym(autonym_bean);
                            }

                        }
                    }

                }));
    }
}
