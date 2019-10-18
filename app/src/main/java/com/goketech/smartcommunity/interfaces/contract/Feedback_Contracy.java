package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Commonality_bean;
import com.goketech.smartcommunity.bean.Feedback_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface Feedback_Contracy {
    interface View extends IBaseView {
        void getdata_Feedback(Feedback_bean feedback_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_Feedback(RequestBody body);
    }
}
