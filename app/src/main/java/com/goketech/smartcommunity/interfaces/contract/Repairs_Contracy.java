package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Addresident_bean;
import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface Repairs_Contracy {
    interface View extends IBaseView {
        void getdata_resident(Addresident_bean addresident_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getdata_resident(RequestBody body);
    }
}
