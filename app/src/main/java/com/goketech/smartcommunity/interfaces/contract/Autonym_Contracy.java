package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Autonym_bean;
import com.goketech.smartcommunity.bean.Commonality_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface Autonym_Contracy {
    interface View extends IBaseView {
        void getdata_Autonym(Autonym_bean autonym_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_Autonym(RequestBody body);
    }
}
