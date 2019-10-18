package com.goketech.smartcommunity.fragment.landing;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseFragment;
import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.interfaces.contract.Verification_Conreacy;
import com.goketech.smartcommunity.presenter.Verification_Presenter;
import com.goketech.smartcommunity.presenter.acivity.Verification_acivity;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class Verification_Fragment extends BaseFragment<Verification_Conreacy.View,Verification_Conreacy.Presenter> implements Verification_Conreacy.View     {


    @BindView(R.id.et_phones)
    EditText mEtPhones;
    @BindView(R.id.bt_landings)
    Button mBtLandings;
    private String phone;
    //private String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
    @Override
    protected Verification_Conreacy.Presenter getPresenter() {
        return new Verification_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_verification_;
    }

    @Override
    protected void initView() {

        mBtLandings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = mEtPhones.getText().toString();
                int length = phone.length();
                Map<String, String> map = new HashMap<>();
                map.put("phone", phone);
                String sign = ASCIIUtils.getSign(map);
                RequestBody requestBody = new FormBody.Builder()
                        .add("phone", phone)
                        .add("sign", sign)
                        .build();

                if (phone.equals("")){
                    Toast.makeText(getActivity(), "手机号不能为空", Toast.LENGTH_SHORT).show();
              /*  }else if (phone.matches(telRegex)){
                    Toast.makeText(getContext(), "请使用正确手机号", Toast.LENGTH_SHORT).show();*/
                }else if (length!=11) {
                    Toast.makeText(getActivity(), "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                }else{
                    mPresenter.getData_Verification(requestBody);

                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {


    }



    @Override
    public void getdata_Verification(Verification_bean verification_bean) {
        if (verification_bean!=null){
            int status = verification_bean.getStatus();
            if (status==0){
                Intent intent = new Intent(getActivity(),Verification_acivity.class);
                intent.putExtra("phone",phone);
                startActivity(intent);
                Toast.makeText(getActivity(), "请输入验证码", Toast.LENGTH_SHORT).show();
            }else {
                Log.i("Tab", String.valueOf(status));
                Toast.makeText(getActivity(), "请不要频繁操作", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
