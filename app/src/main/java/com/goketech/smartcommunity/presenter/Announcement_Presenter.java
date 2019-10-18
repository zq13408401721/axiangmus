package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Announcement_bean;
import com.goketech.smartcommunity.bean.Commonality_bean;
import com.goketech.smartcommunity.interfaces.contract.Announcement_Contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Announcement_Presenter extends BasePresenter<Announcement_Contracy.View> implements Announcement_Contracy.Presenter {
    @Override
    public void getData_Announcement(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_Announcement(body)
                .compose(RxUtils.<Announcement_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Announcement_bean>(mView) {

                    @Override
                    public void onNext(Announcement_bean announcement_bean) {
                        if (announcement_bean != null) {
                            if (mView != null) {
                                mView.getdata_Announcement(announcement_bean);
                            }
                        }
                    }
                }));
    }
}
