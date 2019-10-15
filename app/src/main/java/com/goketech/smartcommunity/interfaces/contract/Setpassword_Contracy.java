package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.SetPassword_bean;
import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface Setpassword_Contracy {
    interface View extends IBaseView {
        void getdata_Setpassword(SetPassword_bean setPassword_bean);
        void getdata_Verification(Verification_bean verification_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_Setpassword(RequestBody body);
        void getData_Verification( RequestBody body);
    }
}
