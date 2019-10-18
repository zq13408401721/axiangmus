package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Acivity_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface Acivity_Cintracy {
    interface View extends IBaseView {
        void getdata_Acivity(Acivity_bean acivity_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_Acivity(RequestBody body);
    }
}
