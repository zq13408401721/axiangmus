package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Acivity_bean;
import com.goketech.smartcommunity.bean.Binding_bean;
import com.goketech.smartcommunity.bean.SetHour_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface Binding_Contracy {
    interface View extends IBaseView {
        void getdata_Binding(Binding_bean binding_bean);
        void getdata_SetHour(SetHour_bean setHour);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_Binding(RequestBody body);
        void getData_SetHour(RequestBody body);
    }
}
