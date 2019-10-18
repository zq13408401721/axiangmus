package com.goketech.smartcommunity.presenter.acivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.adaper.Announce_adaper;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.Announcement_bean;
import com.goketech.smartcommunity.interfaces.contract.Announcement_Contracy;
import com.goketech.smartcommunity.presenter.Announcement_Presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class Announcement_acivity extends BaseActivity<Announcement_Contracy.View, Announcement_Contracy.Presenter> implements Announcement_Contracy.View {

    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.tl)
    Toolbar tl;
    @BindView(R.id.rl)
    RecyclerView rl;
    private ArrayList<Announcement_bean.DataBean> dataBeans;
    private Announce_adaper announce_adaper;
    private List<Announcement_bean.DataBean> data;
    private String tv;
    @Override
    protected Announcement_Contracy.Presenter getPresenter() {
        return new Announcement_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_announcement_acivity;
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        String sign = ASCIIUtils.getSign(map);
        RequestBody requestBody = new FormBody.Builder()
                .add("sign", sign)
                .build();
        mPresenter.getData_Announcement(requestBody);
    }

    @Override
    protected void initView() {
        dataBeans = new ArrayList<>();
        announce_adaper = new Announce_adaper(dataBeans, Announcement_acivity.this);
        rl.setAdapter(announce_adaper);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Announcement_acivity.this);
        rl.setLayoutManager(linearLayoutManager);
        announce_adaper.notifyDataSetChanged();
    }

    @Override
    protected void initListener() {
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        announce_adaper.setSetfei(new Announce_adaper.Setfei() {
            @Override
            public void Setfei(RecyclerView RL_dianji, final int p, final TextView tv_ji) {
                RL_dianji.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (tv_ji.equals("未支付")){
                            Intent intent = new Intent(Announcement_acivity.this,Payment_acivity.class);
                            startActivity(intent);
                        }else if (tv_ji.equals("")){

                        }
                    }
                });
            }
        });
    }

    @Override
    public void getdata_Announcement(Announcement_bean announcement_bean) {
        if(announcement_bean!=null){
            int status = announcement_bean.getStatus();
            if (status==0){
                data = announcement_bean.getData();
                dataBeans.addAll(data);
                Toast.makeText(Announcement_acivity.this, "查看账单", Toast.LENGTH_SHORT).show();
                announce_adaper.notifyDataSetChanged();
            }else{
                Toast.makeText(Announcement_acivity.this, status+"", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
