package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Acivity_Web_bean;
import com.goketech.smartcommunity.bean.Commonality_bean;
import com.goketech.smartcommunity.interfaces.contract.Commonality_Contract;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Commonality_presenter extends BasePresenter<Commonality_Contract.View> implements Commonality_Contract.Presenter {
    @Override
    public void getData_Commonality(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_common(body)
                .compose(RxUtils.<Commonality_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Commonality_bean>(mView) {

                    @Override
                    public void onNext(Commonality_bean commonality_bean) {
                        if (commonality_bean != null) {
                            if (mView != null) {
                                mView.getdata_Commonality(commonality_bean);
                            }
                        }
                    }

                }));
    }
}
