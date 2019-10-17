package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

public interface WxContract {

    interface View extends IBaseView{
        void wxLoginReturn();
    }

    interface Presenter extends IBasePresenter<View>{
        void wxLogin(String code,String sign);
    }

}
