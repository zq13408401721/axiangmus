package com.goketech.smartcommunity.utils;

public interface HttpCallBackListener {
    void onFinish(String response);
    void onError(Exception e);
}
