package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.SetPassword_bean;
import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.interfaces.contract.Setpassword_Contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Setpassword_Presenter extends BasePresenter<Setpassword_Contracy.View> implements Setpassword_Contracy.Presenter {
    @Override
    public void getData_Setpassword(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_setpassword(body)
                .compose(RxUtils.<SetPassword_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SetPassword_bean>(mView) {

                    @Override
                    public void onNext(SetPassword_bean setPassword_bean) {
                        if (setPassword_bean!=null){
                            if (mView != null) {
                                mView.getdata_Setpassword(setPassword_bean);
                            }
                        }
                    }

                }));
    }

    @Override
    public void getData_Verification(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_Verification(body)
                .compose(RxUtils.<Verification_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Verification_bean>(mView) {

                    @Override
                    public void onNext(Verification_bean verification_bean) {
                        if (verification_bean!=null){
                            if (mView != null) {
                                mView.getdata_Verification(verification_bean);
                            }
                        }
                    }
                }));
    }
}
