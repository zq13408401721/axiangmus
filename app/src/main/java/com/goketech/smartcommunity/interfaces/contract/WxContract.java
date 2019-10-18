package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Landing_bean;
import com.goketech.smartcommunity.bean.WeiCode_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface WxContract {

    interface View extends IBaseView{
        void wxLoginReturn(WeiCode_bean data);

        void loginReturn(Landing_bean data);

    }

    interface Presenter extends IBasePresenter<View>{
        void wxLogin(RequestBody body);

        void login(RequestBody body);
    }

}
