package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.My_bean;
import com.goketech.smartcommunity.bean.Neighbourhood_bean;
import com.goketech.smartcommunity.interfaces.contract.My_Contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class My_Preserter extends BasePresenter<My_Contracy.View> implements My_Contracy.Presenter {

    @Override
    public void getData_My(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_My(body).compose(RxUtils.<My_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<My_bean>(mView) {
                    @Override
                    public void onNext(My_bean my_bean) {
                        if (my_bean != null) {
                            if (mView != null) {
                                mView.getdata_My(my_bean);
                            }
                        }
                    }

                }));
    }
}
