package com.goketech.smartcommunity.presenter.acivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.adaper.SetHour_adaper;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.Binding_bean;
import com.goketech.smartcommunity.bean.SetHour_bean;
import com.goketech.smartcommunity.interfaces.contract.Binding_Contracy;
import com.goketech.smartcommunity.presenter.Banding_Presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class Danyuan_Acivity extends BaseActivity<Binding_Contracy.View, Binding_Contracy.Presenter> implements Binding_Contracy.View {

    @BindView(R.id.rl_list)
    RecyclerView rlList;
    private ArrayList<SetHour_bean.DataBean> dataBeans;
    private SetHour_adaper setHour_adaper;
    private RecyclerView rl_list;
    private LinearLayoutManager linearLayoutManager;
    @Override
    protected Binding_Contracy.Presenter getPresenter() {
        return new Banding_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_danyuan__acivity;
    }

    @Override
    protected void initView() {
        dataBeans = new ArrayList<>();
        setHour_adaper = new SetHour_adaper(dataBeans, Danyuan_Acivity.this);
        rl_list.setAdapter(setHour_adaper);
        linearLayoutManager = new LinearLayoutManager(Danyuan_Acivity.this);
        rl_list.setLayoutManager(linearLayoutManager);
        setHour_adaper.notifyDataSetChanged();
    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("community_id", "1");


        String sign = ASCIIUtils.getSign(map);

        RequestBody requestBody = new FormBody.Builder()
                .add("community_id", "1")
                .add("sign", sign)
                .build();
        mPresenter.getData_SetHour(requestBody);
    }

    @Override
    public void getdata_Binding(Binding_bean binding_bean) {

    }

    @Override
    public void getdata_SetHour(SetHour_bean setHour) {
        if (setHour != null) {
            int status = setHour.getStatus();
            if (status == 0) {
                List<SetHour_bean.DataBean> data = setHour.getData();
                dataBeans.addAll(data);
            }
        }
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
