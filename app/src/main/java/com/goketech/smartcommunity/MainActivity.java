package com.goketech.smartcommunity;


import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;

import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.Commonality_bean;
import com.goketech.smartcommunity.fragment.Activity_Fragment;
import com.goketech.smartcommunity.fragment.Home_Fragment;
import com.goketech.smartcommunity.fragment.My_Fragment;
import com.goketech.smartcommunity.interfaces.contract.Commonality_Contract;
import com.goketech.smartcommunity.presenter.Commonality_presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import okhttp3.FormBody;
import okhttp3.RequestBody;


public class MainActivity extends BaseActivity<Commonality_Contract.View,Commonality_Contract.Presenter> implements Commonality_Contract.View {


    @BindView(R.id.tl)
    TabLayout mTl;
    @BindView(R.id.fl)
    FrameLayout mFl;
    private FragmentManager manager;
    private String house_id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initFragments() {
        manager = getSupportFragmentManager();
        mTl.addTab(mTl.newTab().setText("首页").setIcon(R.mipmap.shouye));
        mTl.addTab(mTl.newTab().setText("邻里").setIcon(R.mipmap.linli));
        mTl.addTab(mTl.newTab().setText("活动").setIcon(R.mipmap.huodong));
        mTl.addTab(mTl.newTab().setText("我的").setIcon(R.mipmap.wode));
    }

    @Override
    protected Commonality_Contract.Presenter getPresenter() {
        return new Commonality_presenter();
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        house_id = intent.getStringExtra("house_id");

        addFragment(getSupportFragmentManager(), Home_Fragment.class, R.id.fl, null);


    }


    @Override
    protected void initData() {


    }

    @Override
    protected void initListener() {

        mTl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                int position = tab.getPosition();
                if (position == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("house_id",house_id);
                    addFragment(manager, Home_Fragment.class, R.id.fl, bundle);
                } else if (position == 1) {
                    addFragment(manager, Neighborhood_Fragment.class, R.id.fl, null);
                } else if (position == 2) {
                    addFragment(manager, Activity_Fragment.class, R.id.fl, null);
                } else if (position == 3) {
                    addFragment(manager, My_Fragment.class, R.id.fl, null);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        Map<String, String> maps = new HashMap<>();
        maps.put("1","1");
        String signs = ASCIIUtils.getSign(maps);

        RequestBody requestBodys = new FormBody.Builder()
                .add("sign", signs)
                .build();
        mPresenter.getData_Commonality(requestBodys);
    }

    @Override
    public void showError(String errorMsg) {

    }
    public String getSignMd5Str() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            android.content.pm.Signature[] signs = packageInfo.signatures;
            Signature sign = signs[0];
            String signStr = encryptionMD5(sign.toByteArray());
            return signStr;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * MD5加密
     * @param byteStr 需要加密的内容
     * @return 返回 byteStr的md5值
     */
    public static String encryptionMD5(byte[] byteStr) {
        MessageDigest messageDigest = null;
        StringBuffer md5StrBuff = new StringBuffer();
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(byteStr);
            byte[] byteArray = messageDigest.digest();
            for (int i = 0; i < byteArray.length; i++) {
                if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                    md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
                } else {
                    md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5StrBuff.toString();
    }

    @Override
    public void getdata_Commonality(Commonality_bean commonality_bean) {
        if (commonality_bean!=null){
            int status = commonality_bean.getStatus();
            if (status==0){

            }else{

            }
        }

    }
}
