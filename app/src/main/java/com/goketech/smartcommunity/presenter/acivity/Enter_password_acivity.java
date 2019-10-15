package com.goketech.smartcommunity.presenter.acivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.goketech.smartcommunity.MainActivity;
import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.SetPassword_bean;
import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.interfaces.contract.Setpassword_Contracy;
import com.goketech.smartcommunity.presenter.Setpassword_Presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class Enter_password_acivity extends BaseActivity<Setpassword_Contracy.View, Setpassword_Contracy.Presenter> implements Setpassword_Contracy.View {

    @BindView(R.id.tv_passage)
    TextView mTvPassage;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.iv_new_passage)
    ImageView mIvNewPassage;

    @BindView(R.id.iv_anew_passmg)
    ImageView mIvAnewPassmg;
    @BindView(R.id.et_passage)
    EditText mEtPassage;
    @BindView(R.id.bt_OK)
    Button mBtOK;
    @BindView(R.id.et_new_password)
    EditText mEtNewPassword;
    @BindView(R.id.fan)
    ImageView fan;
    private String android_code = "a01973b3-38a2-4260-8caa-00c4b53e6d86";
    private String token;

    @Override
    protected Setpassword_Contracy.Presenter getPresenter() {
        return new Setpassword_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_enter_password_acivity;
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String phone = intent.getStringExtra("phone");
        mTvPhone.setText("为+" + phone + "设置密码");
    }

    @Override
    protected void initData() {
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBtOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String phone = intent.getStringExtra("phone");
                String code = intent.getStringExtra("code");
                Intent intent1 = new Intent();

                String passage = mEtPassage.getText().toString();
                String newpassword = mEtNewPassword.getText().toString();


                Map<String, String> map = new HashMap<>();
                map.put("phone", phone);
                map.put("password", passage);
                map.put("c_password", newpassword);
                map.put("code", code);

                String sign = ASCIIUtils.getSign(map);

                RequestBody requestBody = new FormBody.Builder()
                        .add("phone", phone)
                        .add("password", passage)
                        .add("c_password", newpassword)
                        .add("code", code)
                        .add("sign", sign)
                        .build();
                mPresenter.getData_Setpassword(requestBody);
            }
        });


    }

    @Override
    public void getdata_Setpassword(SetPassword_bean setPassword_bean) {
        if (setPassword_bean != null) {
            int status = setPassword_bean.getStatus();
            if (status == 0) {
                Toast.makeText(Enter_password_acivity.this, "设置成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Enter_password_acivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(Enter_password_acivity.this, "设置失败", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void getdata_Verification(Verification_bean verification_bean) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
