package com.goketech.smartcommunity.presenter.acivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.adaper.AcivityWeb_adaper;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.Acivity_Web_bean;
import com.goketech.smartcommunity.bean.Apply_bean;
import com.goketech.smartcommunity.interfaces.contract.AcivityWeb_Contracy;
import com.goketech.smartcommunity.presenter.AcivityWeb_Presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

import okhttp3.FormBody;
import okhttp3.RequestBody;

public class Acivity_WebView_acivity extends BaseActivity<AcivityWeb_Contracy.View, AcivityWeb_Contracy.Presenter> implements AcivityWeb_Contracy.View {


    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.tl)
    Toolbar tl;
    @BindView(R.id.rl)
    RecyclerView rl;
    @BindView(R.id.bt_landings)
    Button btLandings;
    private ArrayList<Acivity_Web_bean.DataBean> dataBeans;
    private AcivityWeb_adaper acivityWeb_adaper;
    private String id;

    @Override
    protected AcivityWeb_Contracy.Presenter getPresenter() {
        return new AcivityWeb_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_acivity__web_view2;
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        id = intent.getStringExtra("Aid");
        dataBeans = new ArrayList<>();
        acivityWeb_adaper = new AcivityWeb_adaper(dataBeans, Acivity_WebView_acivity.this);
        rl.setAdapter(acivityWeb_adaper);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Acivity_WebView_acivity.this);
        rl.setLayoutManager(linearLayoutManager);
        acivityWeb_adaper.notifyDataSetChanged();
    }

    @Override
    protected void initListener() {
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btLandings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.new 对象
                //2.指定三要素
                //3.显示
                final PopupWindow popupWindow = new PopupWindow();
                //必须给定三要素: 视图(view),宽,高
                //view
                WindowManager.LayoutParams lp = Acivity_WebView_acivity.this.getWindow().getAttributes();
                lp.alpha = 0.7f;
                Acivity_WebView_acivity.this.getWindow().setAttributes(lp);

                View inflate = LayoutInflater.from(Acivity_WebView_acivity.this).inflate(R.layout.webpopup, null, false);
                popupWindow.setContentView(inflate);
                //宽
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                //高
                popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

                View inflate1 = LayoutInflater.from(Acivity_WebView_acivity.this).inflate(R.layout.activity_acivity__web_view2, null, false);
                popupWindow.showAtLocation(inflate1, Gravity.CENTER, 0, 0);
                ImageView pop_img = inflate.findViewById(R.id.pop_img);
                pop_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        WindowManager.LayoutParams lp = Acivity_WebView_acivity.this.getWindow().getAttributes();
                        lp.alpha = 1f;
                        Acivity_WebView_acivity.this.getWindow().setAttributes(lp);
                    }
                });
                Button viewById = inflate.findViewById(R.id.hujiao);
                viewById.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String, String> map1 = new HashMap<>();
                        map1.put("activity_id", id);
                        String sign1 = ASCIIUtils.getSign(map1);

                        RequestBody requestBody1 = new FormBody.Builder()
                                .add("activity_id", id)
                                .add("sign", sign1)
                                .build();
                        mPresenter.getData_apply(requestBody1);
                    }
                });
            }
        });
    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("activity_id", id+"");

        String sign = ASCIIUtils.getSign(map);

        RequestBody req= new FormBody.Builder()
                .add("activity_id", id+"")
                .add("sign", sign)
                .build();
        Log.e("Tab", id);
        mPresenter.getData_AcivityWeb(req);

    }

    @Override
    public void getdata_AcivityWeb(Acivity_Web_bean acivity_web_bean) {
        if (acivity_web_bean != null) {
            int status = acivity_web_bean.getStatus();
            if (status == 0) {
                Acivity_Web_bean.DataBean data = acivity_web_bean.getData();
                dataBeans.add(data);
                Toast.makeText(Acivity_WebView_acivity.this, "请求成功", Toast.LENGTH_SHORT).show();
                acivityWeb_adaper.notifyDataSetChanged();
              } else {
                Log.e("aa", status+"");
                Toast.makeText(Acivity_WebView_acivity.this, acivity_web_bean.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void getdata_apply(Apply_bean apply_bean) {
        if (apply_bean!=null){
            int status = apply_bean.getStatus();
            if (status==0){
                Toast.makeText(Acivity_WebView_acivity.this ,"报名成功", Toast.LENGTH_SHORT).show();
            }else if (status==1203){
                Toast.makeText(Acivity_WebView_acivity.this ,"您已经报过名了", Toast.LENGTH_SHORT).show();
            }else if (status==1204){
                Toast.makeText(Acivity_WebView_acivity.this ,"活动未开启，敬请期待", Toast.LENGTH_SHORT).show();
            }else if (status==1205){
                Toast.makeText(Acivity_WebView_acivity.this, "活动时间已过，敬请期待下次活动", Toast.LENGTH_SHORT).show();
            }else if (status==1206){
                Toast.makeText(Acivity_WebView_acivity.this, "活动人数已满", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
