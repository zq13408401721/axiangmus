package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Adduser_bean;
import com.goketech.smartcommunity.bean.All_bean;
import com.goketech.smartcommunity.interfaces.contract.Adduser_Contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Adduser_Presenter extends BasePresenter<Adduser_Contracy.View> implements Adduser_Contracy.Presenter {
    @Override
    public void getData_adduser(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_user(body)
                .compose(RxUtils.<Adduser_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Adduser_bean>(mView) {

                    @Override
                    public void onNext(Adduser_bean adduser_bean) {
                        if (adduser_bean != null) {
                            if (mView != null) {
                                mView.getdata_adduser(adduser_bean);
                            }
                        }
                    }
                }));
    }
}
