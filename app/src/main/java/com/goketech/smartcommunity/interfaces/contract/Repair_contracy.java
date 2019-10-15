package com.goketech.smartcommunity.interfaces.contract;

import com.goketech.smartcommunity.bean.Commonality_bean;
import com.goketech.smartcommunity.bean.QR_bean;
import com.goketech.smartcommunity.bean.Repairs_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.IBaseView;

import okhttp3.RequestBody;

public interface Repair_contracy  {
    interface View extends IBaseView {
        void getdata_Repair(Repairs_bean repairs_bean);
        void getdata_Commonality(Commonality_bean commonality_bean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_Repair(RequestBody body);
        void getData_Commonality(RequestBody body);
    }
}
