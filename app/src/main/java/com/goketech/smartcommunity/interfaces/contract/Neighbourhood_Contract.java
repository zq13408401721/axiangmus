package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Neighbourhood_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface Neighbourhood_Contract {
    interface View extends IBaseView {
        void getdata_neighbourhood(Neighbourhood_bean neighbourhood_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_neighbourhood(RequestBody body);
    }
}
