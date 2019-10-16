package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Announcement_bean;
import com.goketech.smartcommunity.bean.Binding_bean;
import com.goketech.smartcommunity.bean.SetHour_bean;
import com.goketech.smartcommunity.interfaces.contract.Binding_Contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Banding_Presenter extends BasePresenter<Binding_Contracy.View> implements Binding_Contracy.Presenter {

    @Override
    public void getData_Binding(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_banding(body)
                .compose(RxUtils.<Binding_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Binding_bean>(mView) {
                    @Override
                    public void onNext(Binding_bean binding_bean) {
                        if (binding_bean != null) {
                            if (mView != null) {
                                mView.getdata_Binding(binding_bean);
                            }
                        }
                    }
                }));
    }

    @Override
    public void getData_SetHour(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_setHour(body)
                .compose(RxUtils.<SetHour_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SetHour_bean>(mView) {

                    @Override
                    public void onNext(SetHour_bean setHour_bean) {
                        if (setHour_bean!=null){
                            if (mView != null) {
                                mView.getdata_SetHour(setHour_bean);
                            }
                        }
                    }

                }));
    }
}
