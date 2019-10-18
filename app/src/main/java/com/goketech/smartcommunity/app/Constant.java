package com.goketech.smartcommunity.app;

import com.goketech.smartcommunity.bean.Commonality_bean;

import com.goketech.smartcommunity.bean.Landing_bean;

import java.io.File;
import java.util.List;

public class Constant {

    public static final String URl = "http://sc.minxj.com/api/";

    //网络缓存的地址
    public static final String PATH_DATA = MyApp.mApp.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/ShiXun";

    public static String token = "";

    public  static  int community_id=0;

    public  static  int house_id=0;
    public  static  int is_call=0;
    public  static  int type;
    //保修id
    public  static  String id;

    //反馈类别id
    public  static  int ids;

    //user用户的id
    public  static  int idb;

    //社区id
    public  static  int community_ids;

    //保修类别
    public static List<Commonality_bean.DataBean.RepairBean> list;

    //登陆houre_id
    public  static  int houre_id;


}
