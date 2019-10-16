package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Acivity_Web_bean;
import com.goketech.smartcommunity.bean.All_bean;
import com.goketech.smartcommunity.interfaces.contract.All_Contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class All_presenter extends BasePresenter<All_Contracy.View> implements All_Contracy.Presenter {
    @Override
    public void getData_All(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_All(body)
                .compose(RxUtils.<All_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<All_bean>(mView) {

                    @Override
                    public void onNext(All_bean all_bean) {
                        if (all_bean != null) {
                            if (mView != null) {
                                mView.getdata_All(all_bean);
                            }
                        }
                    }
                }));
    }
}
