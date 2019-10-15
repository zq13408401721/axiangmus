package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.WeiCode_bean;
import com.goketech.smartcommunity.interfaces.contract.WeiCode_Conreacy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Weicaode_Presenter extends BasePresenter<WeiCode_Conreacy.View> implements WeiCode_Conreacy.Presenter {

    @Override
    public void getData_Weicaode(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_Weicode(body)
                .compose(RxUtils.<WeiCode_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<WeiCode_bean>(mView) {
                    @Override
                    public void onNext(WeiCode_bean weiCode_bean) {

                    }
                }));
    }
}
