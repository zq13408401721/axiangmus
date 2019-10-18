package com.goketech.smartcommunity.presenter.acivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.adaper.My_Houre_adaper;
import com.goketech.smartcommunity.app.Constant;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.Delete_bean;
import com.goketech.smartcommunity.bean.MyHoure_bean;
import com.goketech.smartcommunity.interfaces.contract.MyHour_Contracy;
import com.goketech.smartcommunity.presenter.MyAcivity_Presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class My_house extends BaseActivity<MyHour_Contracy.View, MyHour_Contracy.Presenter> implements MyHour_Contracy.View {


    @BindView(R.id.fang)
    TextView fang;
    @BindView(R.id.add_hours)
    TextView addHours;
    @BindView(R.id.tl)
    Toolbar tl;
    @BindView(R.id.rl)
    RecyclerView rl;
    @BindView(R.id.fan)
    ImageView fan;
    private My_Houre_adaper my_houre_adaper;
    private ArrayList<MyHoure_bean.DataBean> dataBeans;

    @Override
    protected MyHour_Contracy.Presenter getPresenter() {
        return new MyAcivity_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_house;
    }

    @Override
    protected void initView() {
        dataBeans = new ArrayList<>();
        my_houre_adaper = new My_Houre_adaper(dataBeans, My_house.this);
        rl.setAdapter(my_houre_adaper);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(My_house.this);
        rl.setLayoutManager(linearLayoutManager);
        my_houre_adaper.notifyDataSetChanged();
        my_houre_adaper.setMy_setfei(new My_Houre_adaper.My_Setfei() {
            @Override
            public void my_setfei(int p) {
                Intent intent = new Intent(My_house.this,Administrator_acivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();

        String sign = ASCIIUtils.getSign(map);
        RequestBody requestBody = new FormBody.Builder()
                .add("sign", sign)
                .build();
        mPresenter.getData_My(requestBody);
    }

    @Override
    protected void initListener() {
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        addHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(My_house.this, Hour_Binding_acivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getdata_My(MyHoure_bean myAcivity_bean) {
        if (myAcivity_bean != null) {
            int status = myAcivity_bean.getStatus();
            if (status == 0) {
                List<MyHoure_bean.DataBean> data = myAcivity_bean.getData();
                for (int i = 0; i < data.size(); i++) {
                  Constant.community_id= data.get(i).getCommunity_id();
                    List<MyHoure_bean.DataBean.UsersBean> users = data.get(i).getUsers();
                    for (int j = 0; j < users.size(); j++) {
                        Constant.idb=users.get(j).getId();

                    }
                }
                dataBeans.addAll(data);
                Toast.makeText(My_house.this, data + "", Toast.LENGTH_SHORT).show();
                my_houre_adaper.notifyDataSetChanged();
                Toast.makeText(My_house.this, "您的房屋列表", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(My_house.this, myAcivity_bean.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void getdata_delete(Delete_bean delete_bean) {

    }

    @Override
    public void showError(String errorMsg) {

    }
}
