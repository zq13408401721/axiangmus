package com.goketech.smartcommunity.presenter;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.Commonality_bean;
import com.goketech.smartcommunity.bean.QR_bean;
import com.goketech.smartcommunity.bean.Repairs_bean;
import com.goketech.smartcommunity.interfaces.contract.Repair_contracy;
import com.goketech.smartcommunity.utils.CommonSubscriber;
import com.goketech.smartcommunity.utils.HttpUtils;
import com.goketech.smartcommunity.utils.RxUtils;

import okhttp3.RequestBody;

public class Repairs_presenter extends BasePresenter<Repair_contracy.View> implements Repair_contracy.Presenter {
    @Override
    public void getData_Repair(RequestBody body) {
        addSubscribe(HttpUtils.getMyServer().getdata_repair(body)
                .compose(RxUtils.<Repairs_bean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Repairs_bean>(mView) {

                    @Override
                    public void onNext(Repairs_bean repairs_bean) {
                        if (repairs_bean!=null){
                            if (mView != null) {
                                mView.getdata_Repair(repairs_bean);
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
