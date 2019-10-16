package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Landing_bean;
import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface Landing_Contracy {
    interface View extends IBaseView {
        void getdata_landing(Landing_bean landing_bean);
        void getdata_Verification(Verification_bean verification_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_landing( String id,RequestBody body);
        void getData_Verification(RequestBody body);
    }
}
