package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Acivity_bean;
import com.goketech.smartcommunity.bean.All_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface All_Contracy {
    interface View extends IBaseView {
        void getdata_All(All_bean all_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_All(RequestBody body);
    }
}
