package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Acivity_Web_bean;
import com.goketech.smartcommunity.bean.Apply_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface AcivityWeb_Contracy {
    interface View extends IBaseView {
        void getdata_AcivityWeb(Acivity_Web_bean acivity_web_bean);
        void getdata_apply(Apply_bean apply_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_AcivityWeb(RequestBody body);
        void getData_apply(RequestBody body);
    }
}
