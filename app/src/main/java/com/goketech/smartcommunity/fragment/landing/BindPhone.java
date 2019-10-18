package com.goketech.smartcommunity.fragment.landing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.Landing_bean;
import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.interfaces.IBasePresenter;
import com.goketech.smartcommunity.interfaces.contract.BindPhone_Conreacy;
import com.goketech.smartcommunity.interfaces.contract.Verification_Conreacy;
import com.goketech.smartcommunity.presenter.BindPhonePresenter;
import com.goketech.smartcommunity.presenter.Verification_Presenter;
import com.goketech.smartcommunity.presenter.WxLoginPresenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class BindPhone extends BaseActivity implements BindPhone_Conreacy.View {
    @BindView(R.id.bindphone_back)
    ImageView bindphoneBack;
    @BindView(R.id.bindphone_phonenum)
    EditText bindphonePhonenum;
    @BindView(R.id.bindphone_code)
    EditText bindphoneCode;
    @BindView(R.id.bindphone_getcode)
    TextView bindphoneGetcode;
    @BindView(R.id.wx_bind)
    Button wxBind;
    private String access_token;
    private String openid;
    private String phonenum;


    @Override
    protected IBasePresenter getPresenter() {
        return new BindPhonePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_bindphone;
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    protected void initView() {
        super.initView();
        Intent intent = getIntent();
        openid = intent.getStringExtra("openid");
        access_token = intent.getStringExtra("access_token");

    }

    @OnClick({R.id.bindphone_back, R.id.bindphone_getcode,R.id.wx_bind})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bindphone_back:
                finish();
                break;
            case R.id.bindphone_getcode:
                // 发送验证码
                phonenum = bindphonePhonenum.getText().toString();
                Map<String, String> map = new HashMap<>();
                map.put("phone", phonenum);
                String sign = ASCIIUtils.getSign(map);

                RequestBody requestBody = new FormBody.Builder()
                        .add("phone", phonenum)
                        .add("sign", sign)
                        .build();

                ((BindPhonePresenter) mPresenter).getData_Verification(requestBody);

                break;
            case R.id.wx_bind:
                //构建requestBody 向后台发送请求
                phonenum = bindphonePhonenum.getText().toString();
                String code = bindphoneCode.getText().toString();
                Map<String, String> map1 = new HashMap<>();
                map1.put("mode", "3");
                map1.put("code",code );
                map1.put("openid", openid);
                map1.put("phone", phonenum);
                map1.put("access_token", access_token);
                String bindsign = ASCIIUtils.getSign(map1);

                RequestBody requestBody1 = new FormBody.Builder()
                        .add("code", code)
                        .add("mode","3")
                        .add("openid",openid)
                        .add("access_token",access_token)
                        .add("phone",phonenum)
                        .add("sign",bindsign)
                        .build();
                ((BindPhonePresenter)mPresenter).login(requestBody1);
                break;
        }
    }





    @Override
    public void getdata_Code(Verification_bean verification_bean) {

    }

    @Override
    public void loginReturn(Landing_bean landing_bean) {
        Toast.makeText(this, ""+landing_bean.getMsg(), Toast.LENGTH_SHORT).show();
    }
}
