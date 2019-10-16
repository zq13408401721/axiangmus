package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Acivity_bean;
import com.goketech.smartcommunity.interfaces.contract.Acivity_Cintracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Acivity_Presenter extends BasePresenter<Acivity_Cintracy.View> implements Acivity_Cintracy.Presenter {

    @Override
    public void getData_Acivity( RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_Acivity(body)
                .compose(RxUtils.<Acivity_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Acivity_bean>(mView) {

                    @Override
                    public void onNext(Acivity_bean acivity_bean) {
                        if (acivity_bean!=null){
                            if (mView != null) {
                                mView.getdata_Acivity(acivity_bean);
                            }
                        }
                    }
                }));
    }
}
