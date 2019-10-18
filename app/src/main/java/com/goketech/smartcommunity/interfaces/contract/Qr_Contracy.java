package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.QR_bean;
import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface Qr_Contracy {
    interface View extends IBaseView {
        void getdata_QR(QR_bean qr_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_QR(RequestBody body);
    }
}
