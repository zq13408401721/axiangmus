package com.goketech.smartcommunity.presenter.acivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.app.Constant;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.Feedback_bean;
import com.goketech.smartcommunity.interfaces.contract.Feedback_Contracy;
import com.goketech.smartcommunity.presenter.Feedback_presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class Feedback_Acivity extends BaseActivity<Feedback_Contracy.View, Feedback_Contracy.Presenter> implements Feedback_Contracy.View {

    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.fang)
    TextView fang;
    @BindView(R.id.tl)
    Toolbar tl;
    @BindView(R.id.wen)
    TextView wen;
    @BindView(R.id.et_fan)
    EditText etFan;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.xain)
    TextView xain;
    @BindView(R.id.relation)
    TextView relation;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.bt_landings)
    Button btLandings;
    private int num = 200;
    private CharSequence recording;
    @Override
    protected Feedback_Contracy.Presenter getPresenter() {
        return new Feedback_presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feedback__acivity;
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
        etFan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                recording = s;
                int length = recording.length();
                tvNum.setText(length + "/" + num);
            }
        });
        btLandings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fan = etFan.getText().toString();
                String Phone = etPhone.getText().toString();
                int a= Constant.ids;
                int b=Constant.idb;
                Log.e("can",fan+Phone+" "+a+"das"+b);
                Map<String, String> map = new HashMap<>();
                map.put("community_id", "1");
                map.put("member_id", b+"");
                map.put("dict_id", a+"");
                map.put("description", fan);
                map.put("phone", Phone);
                map.put("images", "1");

                String sign = ASCIIUtils.getSign(map);

                RequestBody requestBody = new FormBody.Builder()
                        .add("community_id", "1")
                        .add("member_id", b+"")
                        .add("dict_id",  a+"")
                        .add("description", fan)
                        .add("phone", Phone)
                        .add("images", "1")
                        .add("sign", sign)
                        .build();

                mPresenter.getData_Feedback(requestBody);
            }
        });
    }

    @Override
    public void getdata_Feedback(Feedback_bean feedback_bean) {
        if (feedback_bean!=null){
            int status = feedback_bean.getStatus();
            if (status==0){
                Toast.makeText(Feedback_Acivity.this, "反馈成功", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(Feedback_Acivity.this, status+"", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void showError(String errorMsg) {

    }

}
