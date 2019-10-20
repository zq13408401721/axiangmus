package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Announcement_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface Announcement_Contracy {
    interface View extends IBaseView {
        void getdata_Announcement(Announcement_bean announcement_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_Announcement(RequestBody body);
    }
}
