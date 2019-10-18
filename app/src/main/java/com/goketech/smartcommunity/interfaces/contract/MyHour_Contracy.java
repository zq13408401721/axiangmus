package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Delete_bean;
import com.goketech.smartcommunity.bean.MyHoure_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface MyHour_Contracy {
    interface View extends IBaseView {
        void getdata_My(MyHoure_bean myAcivity_bean);
        void getdata_delete(Delete_bean delete_bean);

    }
    interface Presenter extends IBasePresenter<View> {
        void getData_My(RequestBody body);
        void getData_delete(RequestBody body);
    }
}
