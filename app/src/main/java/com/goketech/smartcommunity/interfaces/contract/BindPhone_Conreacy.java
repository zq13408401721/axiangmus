package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Landing_bean;
import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface BindPhone_Conreacy {
    interface View extends IBaseView {
        void getdata_Code(Verification_bean verification_bean);
        void loginReturn(Landing_bean landing_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_Verification(RequestBody body);
        void login(RequestBody body);
    }
}
