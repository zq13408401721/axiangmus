package com.goketech.smartcommunity.interfaces;


import com.goketech.smartcommunity.bean.Acivity_Web_bean;
import com.goketech.smartcommunity.bean.Acivity_bean;
import com.goketech.smartcommunity.bean.Announce_bean;
import com.goketech.smartcommunity.bean.Announcement_bean;
import com.goketech.smartcommunity.bean.Apply_bean;
import com.goketech.smartcommunity.bean.Binding_bean;
import com.goketech.smartcommunity.bean.Commonality_bean;
import com.goketech.smartcommunity.bean.Home_bean;
import com.goketech.smartcommunity.bean.Landing_bean;
import com.goketech.smartcommunity.bean.MyHoure_bean;
import com.goketech.smartcommunity.bean.My_bean;
import com.goketech.smartcommunity.bean.Neighbourhood_bean;
import com.goketech.smartcommunity.bean.QR_bean;
import com.goketech.smartcommunity.bean.Repairs_bean;
import com.goketech.smartcommunity.bean.SetPassword_bean;
import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.bean.WeiCode_bean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {


    @POST("smsCode")
    Flowable<Verification_bean> getdata_Verification(@Body RequestBody body);

    @POST("login")
    Flowable<Landing_bean> getdata_landing(@Header("device-id") String id,@Body RequestBody body);

    @POST("setPassword")
    Flowable<SetPassword_bean> getdata_setpassword(@Body RequestBody body);

    @POST("wxLogin")
    Flowable<WeiCode_bean> getdata_Weicode(@Body RequestBody body);

    @POST("appInxde")
    Flowable<Home_bean> getdata_Home(@Body RequestBody body);

    @POST("getActivity")
    Flowable<Acivity_bean> getdata_Acivity(@Body RequestBody body);

    @POST("activity/detail")
    Flowable<Acivity_Web_bean> getdata_Acivity_Web(@Body RequestBody body);

    @POST("im/community")
    Flowable<Neighbourhood_bean> getdata_Neighbourhood(@Body RequestBody body);

    @POST("my")
    Flowable<My_bean> getdata_My(@Body RequestBody body);

    @POST("getNoticeMessage")
    Flowable<Announce_bean> getdata_Announce(@Body RequestBody body);

    @POST("dict")
    Flowable<Commonality_bean> getdata_common(@Body RequestBody body);

    @POST("activity/apply")
    Flowable<Apply_bean> getdata_apply(@Body RequestBody body);

    //二维码
    @POST("index/qrcode")
    Flowable<QR_bean> getdata_Qr(@Body RequestBody body);

    //添加保修
    @POST("repair/create")
    Flowable<Repairs_bean> getdata_repair(@Body RequestBody body);

    //物业费列表
    @POST("property")
    Flowable<Announcement_bean> getdata_Announcement(@Body RequestBody body);

    //我的活动
    @POST("my/activity")
    Flowable<MyHoure_bean> getdata_MyAcivity(@Body RequestBody body);

    //绑定房屋
    @POST("bindHouse")
    Flowable<Binding_bean> getdata_banding(@Body RequestBody body);
}


