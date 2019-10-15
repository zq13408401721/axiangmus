package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Announce_bean;
import com.goketech.smartcommunity.bean.Commonality_bean;
import com.goketech.smartcommunity.bean.Home_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface Home_Contracy {
    interface View extends IBaseView {
        void getdata_Home(Home_bean home_bean);
        void getdata_Announce(Announce_bean announce_bean);
        void getdata_Commonality(Commonality_bean commonality_bean);

    }
    interface Presenter extends IBasePresenter<View> {
        void getData_Home(RequestBody body);
        void getData_Announce(RequestBody body);
        void getData_Commonality(RequestBody body);
    }
}
