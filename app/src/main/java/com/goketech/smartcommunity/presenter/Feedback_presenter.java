package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Commonality_bean;
import com.goketech.smartcommunity.bean.Feedback_bean;
import com.goketech.smartcommunity.interfaces.contract.Feedback_Contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Feedback_presenter extends BasePresenter<Feedback_Contracy.View> implements Feedback_Contracy.Presenter {
    @Override
    public void getData_Feedback(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_Feedback(body)
                .compose(RxUtils.<Feedback_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Feedback_bean>(mView) {

                    @Override
                    public void onNext(Feedback_bean feedback_bean) {
                        if (feedback_bean != null) {
                            if (mView != null) {
                                mView.getdata_Feedback(feedback_bean);
                            }
                        }
                    }
                }));
    }
}
