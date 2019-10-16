package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Announce_bean;
import com.goketech.smartcommunity.bean.Commonality_bean;
import com.goketech.smartcommunity.bean.Home_bean;
import com.goketech.smartcommunity.interfaces.contract.Home_Contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Home_Presenter extends BasePresenter<Home_Contracy.View> implements Home_Contracy.Presenter {

    @Override
    public void getData_Home( RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_Home(body)
                .compose(RxUtils.<Home_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Home_bean>(mView) {

                    @Override
                    public void onNext(Home_bean home_bean) {
                        if (home_bean!=null){
                            if (mView != null) {
                                mView.getdata_Home(home_bean);
                            }
                        }
                    }
                }));
    }

    @Override
    public void getData_Announce(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_Announce(body)
                .compose(RxUtils.<Announce_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Announce_bean>(mView) {

                    @Override
                    public void onNext(Announce_bean announce_bean) {
                        if (announce_bean!=null){
                            if (mView != null) {
                                mView.getdata_Announce(announce_bean);
                            }
                        }
                    }
                }));
    }

    @Override
    public void getData_Commonality(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_common(body)
                .compose(RxUtils.<Commonality_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Commonality_bean>(mView) {

                    @Override
                    public void onNext(Commonality_bean commonality_bean) {
                        if (commonality_bean != null) {
                            if (mView != null) {
                                mView.getdata_Commonality(commonality_bean);
                            }
                        }
                    }

                }));
    }
}
