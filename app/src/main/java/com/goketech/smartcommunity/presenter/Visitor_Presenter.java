package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.bean.Visitor_bean;
import com.goketech.smartcommunity.interfaces.contract.Visitors_Contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Visitor_Presenter extends BasePresenter<Visitors_Contracy.View> implements Visitors_Contracy.Presenter {
    @Override
    public void getData_visitors(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_Visitor(body)
                .compose(RxUtils.<Visitor_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Visitor_bean>(mView) {

                    @Override
                    public void onNext(Visitor_bean visitor_bean) {
                        if (visitor_bean!=null){
                            if (mView != null) {
                                mView.getdata_visitors(visitor_bean);
                            }
                        }
                    }
                }));
    }
}
