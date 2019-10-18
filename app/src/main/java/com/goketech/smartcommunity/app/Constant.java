package com.goketech.smartcommunity.app;

import com.goketech.smartcommunity.bean.Landing_bean;

import java.io.File;

public class Constant {

    public static final String URl = "http://sc.minxj.com/api/";

    //网络缓存的地址
    public static final String PATH_DATA = MyApp.mApp.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/ShiXun";

    public static String token = "";



}
