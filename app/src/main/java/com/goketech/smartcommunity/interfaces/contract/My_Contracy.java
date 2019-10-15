package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.base.BasePresenter;
import com.goketech.smartcommunity.bean.My_bean;
import com.goketech.smartcommunity.bean.Neighbourhood_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface My_Contracy {
    interface View extends IBaseView {
        void getdata_My(My_bean my_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_My(RequestBody body);
    }
}
