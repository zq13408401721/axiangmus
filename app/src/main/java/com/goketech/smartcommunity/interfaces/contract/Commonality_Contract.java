package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Acivity_Web_bean;
import com.goketech.smartcommunity.bean.Commonality_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface Commonality_Contract {
    interface View extends IBaseView {
        void getdata_Commonality(Commonality_bean commonality_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_Commonality(RequestBody body);
    }
}
