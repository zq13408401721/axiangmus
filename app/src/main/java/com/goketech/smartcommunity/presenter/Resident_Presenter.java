package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Addresident_bean;
import com.goketech.smartcommunity.bean.Repairs_bean;
import com.goketech.smartcommunity.interfaces.contract.Repairs_Contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Resident_Presenter extends BasePresenter<Repairs_Contracy.View> implements Repairs_Contracy.Presenter {

    @Override
    public void getdata_resident(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_getdata_resident(body)
                .compose(RxUtils.<Addresident_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Addresident_bean>(mView) {

                    @Override
                    public void onNext(Addresident_bean addresident_bean) {
                        if (addresident_bean!=null){
                            if (mView != null) {
                                mView.getdata_resident(addresident_bean);
                            }
                        }
                    }
                }));
    }
}
