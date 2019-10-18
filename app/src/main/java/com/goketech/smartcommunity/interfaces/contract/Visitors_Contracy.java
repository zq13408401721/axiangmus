package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.bean.Visitor_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface Visitors_Contracy {
    interface View extends IBaseView {
        void getdata_visitors(Visitor_bean visitor_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_visitors(RequestBody body);
    }
}
