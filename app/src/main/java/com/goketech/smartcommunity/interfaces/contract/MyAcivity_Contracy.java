package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.MyAcivity_bean;
import com.goketech.smartcommunity.bean.MyHoure_bean;
import com.goketech.smartcommunity.bean.My_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface MyAcivity_Contracy {
    interface View extends IBaseView {
        void getdata_MyAcivity(MyAcivity_bean myAcivity_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_MyAcivity(RequestBody body);
    }
}
