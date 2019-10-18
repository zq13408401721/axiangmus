package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Adduser_bean;
import com.goketech.smartcommunity.bean.All_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface Adduser_Contracy {
    interface View extends IBaseView {
        void getdata_adduser(Adduser_bean adduser_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_adduser(RequestBody body);
    }
}
