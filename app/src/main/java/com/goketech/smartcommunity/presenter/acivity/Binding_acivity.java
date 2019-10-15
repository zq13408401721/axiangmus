package com.goketech.smartcommunity.presenter.acivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.goketech.smartcommunity.R;

public class Binding_acivity extends AppCompatActivity {

    private ImageView mFan;
    /**
     * 请输入手机号码
     */
    private EditText mEtPhone;
    /**
     * 请输入密码
     */
    private EditText mEtPassage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binding_acivity);
        initView();

    }

    private void initView() {
        mFan = (ImageView) findViewById(R.id.fan);
        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mEtPassage = (EditText) findViewById(R.id.et_passage);
        mFan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
