package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.WeiCode_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface WeiCode_Conreacy {

    interface View extends IBaseView {
        void getdata_Weicaode(WeiCode_bean weiCode_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_Weicaode(RequestBody body);
    }
}
