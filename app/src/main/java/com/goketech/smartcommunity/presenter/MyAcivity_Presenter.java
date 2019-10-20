package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Delete_bean;
import com.goketech.smartcommunity.bean.MyAcivity_bean;
import com.goketech.smartcommunity.bean.MyHoure_bean;
import com.goketech.smartcommunity.interfaces.contract.MyHour_Contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class MyAcivity_Presenter extends BasePresenter<MyHour_Contracy.View> implements MyHour_Contracy.Presenter {
    @Override
    public void getData_My(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_MyHoure(body).compose(RxUtils.<MyHoure_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<MyHoure_bean>(mView) {
                    @Override
                    public void onNext(MyHoure_bean myAcivity_bean) {
                        if (myAcivity_bean != null) {
                            if (mView != null) {
                                mView.getdata_My(myAcivity_bean);
                            }
                        }
                    }
                }));
    }

    @Override
    public void getData_delete(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_delete(body)
                .compose(RxUtils.<Delete_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Delete_bean>(mView) {

                    @Override
                    public void onNext(Delete_bean delete_bean) {
                        if (delete_bean != null) {
                            if (mView != null) {
                                mView.getdata_delete(delete_bean);
                            }
                        }
                    }
                }));
    }
}
