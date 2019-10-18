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
import com.goketech.smartcommunity.adaper.Administrator_adaper;
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

public class Administrator_acivity extends BaseActivity<MyHour_Contracy.View, MyHour_Contracy.Presenter> implements MyHour_Contracy.View {


    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.fang)
    TextView fang;
    @BindView(R.id.tl)
    Toolbar tl;
    @BindView(R.id.rl)
    RecyclerView rl;
    @BindView(R.id.add_user)
    TextView addUser;
    private ArrayList<MyHoure_bean.DataBean> dataBeans;
    private Administrator_adaper administrator_adaper;

    @Override
    protected MyHour_Contracy.Presenter getPresenter() {
        return new MyAcivity_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_administrator_acivity;
    }

    @Override
    protected void initView() {
        dataBeans = new ArrayList<>();
        administrator_adaper = new Administrator_adaper(dataBeans, Administrator_acivity.this);
        rl.setAdapter(administrator_adaper);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Administrator_acivity.this);
        rl.setLayoutManager(linearLayoutManager);
        administrator_adaper.notifyDataSetChanged();
    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();

        String sign = ASCIIUtils.getSign(map);
        RequestBody requestBody = new FormBody.Builder()
                .add("sign", sign)
                .build();
        mPresenter.getData_My(requestBody);
        administrator_adaper.setDelete(new Administrator_adaper.Delete() {
            @Override
            public void delete(int p) {
                Map<String, String> map = new HashMap<>();
                String hour_id= String.valueOf(Constant.house_id);
                String community_ids= String.valueOf(Constant.community_ids);
                String id= String.valueOf(Constant.idb);
                map.put("house_id",hour_id);
                map.put("community_id",community_ids);
                map.put("member_id",id);

                String sign = ASCIIUtils.getSign(map);
                RequestBody requestBody = new FormBody.Builder()
                        .add("house_id",hour_id)
                        .add("community_id",community_ids)
                        .add("member_id",id)
                        .add("sign", sign)
                        .build();
                mPresenter.getData_delete(requestBody);
            }
        });
    }

    @Override
    protected void initListener() {
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Administrator_acivity.this, Addresident_Acivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getdata_My(MyHoure_bean myAcivity_bean) {
        if (myAcivity_bean != null) {
            int status = myAcivity_bean.getStatus();
            List<MyHoure_bean.DataBean> data = myAcivity_bean.getData();
            dataBeans.addAll(data);
            administrator_adaper.notifyDataSetChanged();
            if (status == 0) {
                Toast.makeText(Administrator_acivity.this, "用户列表", Toast.LENGTH_SHORT).show();
                Toast.makeText(Administrator_acivity.this, data + "", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void getdata_delete(Delete_bean delete_bean) {
        if (delete_bean!=null){
            int status = delete_bean.getStatus();
            if (status==0){
                Toast.makeText(Administrator_acivity.this, "删除成功", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(Administrator_acivity.this, status+"", Toast.LENGTH_SHORT).show();
                Toast.makeText(Administrator_acivity.this, delete_bean.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void showError(String errorMsg) {

    }
}
