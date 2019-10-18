package com.goketech.smartcommunity.presenter.acivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.Autonym_bean;
import com.goketech.smartcommunity.interfaces.contract.Autonym_Contracy;
import com.goketech.smartcommunity.presenter.Autonym_presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class Autonym_acivity extends BaseActivity<Autonym_Contracy.View, Autonym_Contracy.Presenter> implements Autonym_Contracy.View {

    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.fang)
    TextView fang;
    @BindView(R.id.tl)
    Toolbar tl;
    @BindView(R.id.xin)
    TextView xin;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.xain)
    TextView xain;
    @BindView(R.id.et_identity)
    EditText etIdentity;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.bt_landings)
    Button btLandings;
    private Boolean sd=false;
    @Override
    protected Autonym_Contracy.Presenter getPresenter() {
        return new Autonym_presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_autonym_acivity;
    }

    @Override
    protected void initFragments() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        btLandings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String identity = etIdentity.getText().toString();
                String name = etName.getText().toString();
                Map<String, String> map = new HashMap<>();
                map.put("identity",identity);
                map.put("real_name",name);
                String sign = ASCIIUtils.getSign(map);
                Log.e("Tav",identity+name);
                RequestBody requestBody = new FormBody.Builder()
                        .add("identity",identity)
                        .add("real_name",name)
                        .add("sign", sign)
                        .build();
                mPresenter.getData_Autonym(requestBody);
            }
        });
    }

    @Override
    public void getdata_Autonym(Autonym_bean autonym_bean) {
        if (autonym_bean!=null){
            int status = autonym_bean.getStatus();
            if (status==0){
                sd=true;
                String name = etName.getText().toString();

                Toast.makeText(Autonym_acivity.this, "实名成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Autonym_acivity.this,Setting_acivity.class);
                intent.putExtra("name",name);
                intent.putExtra("sd",sd);
                startActivity(intent);

            }else {
                Log.e("Tab",status+"");
                Toast.makeText(Autonym_acivity.this, autonym_bean.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void showError(String errorMsg) {

    }
}
