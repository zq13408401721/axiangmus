package com.goketech.smartcommunity.presenter;

import android.util.Log;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Landing_bean;
import com.goketech.smartcommunity.bean.WeiCode_bean;
import com.goketech.smartcommunity.interfaces.contract.WxContract;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class WxLoginPresenter extends BasePresenter<WxContract.View> implements WxContract.Presenter {


    @Override
    public void wxLogin(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_Weicode(body)
                .compose(RxUtils.<WeiCode_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<WeiCode_bean>(mView) {
                    @Override
                    public void onNext(WeiCode_bean weiCode_bean) {
                        mView.wxLoginReturn(weiCode_bean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        Log.i("tag", "onError: "+t.toString());
                    }
                }));
    }

    @Override
    public void login(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_landing("a01973b3-38a2-4260-8caa-00c4b53e6d86",body)
                .compose(RxUtils.<Landing_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Landing_bean>(mView) {
                    @Override
                    public void onNext(Landing_bean data) {
                        mView.loginReturn(data);
                    }
                }));
    }

}
