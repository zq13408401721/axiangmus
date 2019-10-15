package com.goketech.smartcommunity.presenter.acivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class Find_acivity extends BaseActivity<Setpassword_Contracy.View, Setpassword_Contracy.Presenter> implements Setpassword_Contracy.View {

    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.et_new)
    EditText mEtNew;
    @BindView(R.id.et_retype)
    EditText mEtRetype;
    @BindView(R.id.modification)
    Button mModification;
    @BindView(R.id.verification)
    TextView mVerification;
    @BindView(R.id.et_verifi)
    EditText mEtVerifi;
    @BindView(R.id.fan)
    ImageView mFan;
    private String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
    private String android_code = "a01973b3-38a2-4260-8caa-00c4b53e6d86";

    @Override
    protected Setpassword_Contracy.Presenter getPresenter() {
        return new Setpassword_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_find_acivity;
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    protected void initListener() {
        mFan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mVerification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = mEtPhone.getText().toString();
                int length = phone.length();
                Map<String, String> map = new HashMap<>();
                map.put("phone", phone);
                String sign = ASCIIUtils.getSign(map);
                RequestBody requestBody = new FormBody.Builder()
                        .add("phone", phone)
                        .add("sign", sign)
                        .build();

                if (phone.equals("")) {
                    Toast.makeText(Find_acivity.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                } else if (phone.equals(telRegex)) {
                    Toast.makeText(Find_acivity.this, "请使用正确手机号", Toast.LENGTH_SHORT).show();
                } else if (length != 11) {
                    Toast.makeText(Find_acivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                } else {
                    mPresenter.getData_Verification(requestBody);
                }

            }
        });
        mModification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verifi = mEtVerifi.getText().toString();
                String newpassage = mEtNew.getText().toString();
                String rety = mEtRetype.getText().toString();
                String phone = mEtPhone.getText().toString();
                Map<String, String> map = new HashMap<>();
                map.put("phone", phone);
                map.put("password", newpassage);
                map.put("c_password", rety);
                map.put("code", verifi);

                String sign = ASCIIUtils.getSign(map);
                if (newpassage.equals(rety)) {
                    Toast.makeText(Find_acivity.this, "密码不一致", Toast.LENGTH_SHORT).show();
                } else if (newpassage.equals("") && rety.equals("")) {
                    Toast.makeText(Find_acivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                } else if (phone.equals(telRegex)) {
                    Toast.makeText(Find_acivity.this, "手机号不符合规范", Toast.LENGTH_SHORT).show();
                } else {
                    RequestBody requestBody = new FormBody.Builder()
                            .add("phone", phone)
                            .add("password", newpassage)
                            .add("c_password", rety)
                            .add("code", verifi)
                            .add("sign", sign)
                            .build();
                    mPresenter.getData_Setpassword(requestBody);
                }
            }
        });
        mFan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void initView() {

    }

    @Override
    public void getdata_Setpassword(SetPassword_bean setPassword_bean) {
        if (setPassword_bean != null) {
            int status = setPassword_bean.getStatus();
            if (status == 0) {
                Intent intent = new Intent(Find_acivity.this, Change_acivity.class);
                startActivity(intent);
                Toast.makeText(Find_acivity.this, "修改成功", Toast.LENGTH_SHORT).show();

            } else {
                Log.i("Tab", String.valueOf(status));
                Toast.makeText(Find_acivity.this, "修改失败", Toast.LENGTH_SHORT).show();

            }
        }

    }

    @Override
    public void getdata_Verification(Verification_bean verification_bean) {
        if (verification_bean != null) {
            int status = verification_bean.getStatus();
            if (status == 0) {
                Toast.makeText(Find_acivity.this, "验证码发送中请稍等", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(Find_acivity.this, "验证码发送失败", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
