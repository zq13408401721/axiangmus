package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Neighbourhood_bean;
import com.goketech.smartcommunity.interfaces.contract.Neighbourhood_Contract;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Neighbourhood_Presenter extends BasePresenter<Neighbourhood_Contract.View> implements Neighbourhood_Contract.Presenter {
    @Override
    public void getData_neighbourhood(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_Neighbourhood(body).compose(RxUtils.<Neighbourhood_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Neighbourhood_bean>(mView) {
                    @Override
                    public void onNext(Neighbourhood_bean neighbourhood_bean) {
                        if (neighbourhood_bean != null) {
                            if (mView != null) {
                                mView.getdata_neighbourhood(neighbourhood_bean);
                            }
                        }
                    }

        }));
    }
}
