package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.QR_bean;
import com.goketech.smartcommunity.bean.SetPassword_bean;
import com.goketech.smartcommunity.interfaces.contract.Qr_Contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Qr_Presenter extends BasePresenter<Qr_Contracy.View> implements Qr_Contracy.Presenter {
    @Override
    public void getData_QR(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_Qr(body)
                .compose(RxUtils.<QR_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<QR_bean>(mView) {

                    @Override
                    public void onNext(QR_bean qr_bean) {
                        if (qr_bean!=null){
                            if (mView != null) {
                                mView.getdata_QR(qr_bean);
                            }
                        }
                    }
                }));
    }
}
