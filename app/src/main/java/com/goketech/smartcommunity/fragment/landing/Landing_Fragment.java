package com.goketech.smartcommunity.fragment.landing;

import android.content.Context;
import android.content.Intent;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.goketech.smartcommunity.Eventbus.MessageEvent;
import com.goketech.smartcommunity.MainActivity;
import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.app.Constant;
import com.goketech.smartcommunity.base.BaseFragment;
import com.goketech.smartcommunity.bean.Landing_bean;
import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.interfaces.contract.Landing_Contracy;
import com.goketech.smartcommunity.presenter.Landing_presenter;
import com.goketech.smartcommunity.presenter.acivity.Find_acivity;
import com.goketech.smartcommunity.presenter.acivity.QR_acivity;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;
import okhttp3.Connection;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class Landing_Fragment extends BaseFragment<Landing_Contracy.View,Landing_Contracy.Presenter> implements Landing_Contracy.View{


    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.et_passage)
    EditText mEtPassage;
    @BindView(R.id.forget)
    TextView mForget;
    @BindView(R.id.bt_landings)
    Button mBtLandings;
    private View view;
    private Unbinder unbinder;
    private String android_code = "a01973b3-38a2-4260-8caa-00c4b53e6d86";
    private String phone;
    private String passage;
    private String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
    private String token;
    private int house_id;
    private List<Landing_bean.DataBean.HousesBean> houses;

    @Override
    protected Landing_Contracy.Presenter getPresenter() {
        return new Landing_presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_landing_;
    }

    @Override
    protected void initListener() {
        mBtLandings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = mEtPhone.getText().toString();
                passage = mEtPassage.getText().toString();
                int length = phone.length();
                if (phone.equals("")&&passage.equals("")){
                    Toast.makeText(getActivity(), "手机号和密码不能为空", Toast.LENGTH_SHORT).show();
             /*   }else if (phone.matches(telRegex)) {
                    Toast.makeText(getActivity(), "手机号有误", Toast.LENGTH_SHORT).show();*/
                } else if (length!=11) {
                    Toast.makeText(getActivity(), "手机号有误", Toast.LENGTH_SHORT).show();
                }else {
                    Map<String,String> map = new HashMap<>();
                    map.put("phone",phone);
                    map.put("password",passage);
                    map.put("mode","1");

                    String sign = ASCIIUtils.getSign(map);
                    RequestBody requestBody = new FormBody.Builder()
                            .add("mode","1")
                            .add("phone",phone)
                            .add("password",passage)
                            .add("sign",sign)
                            .build();
                    mPresenter.getData_landing("a01973b3-38a2-4260-8caa-00c4b53e6d86",requestBody);
                }
            }
        });
        mForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Find_acivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mEtPassage.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    @Override
    public void getdata_landing(Landing_bean landing_bean) {
        if (landing_bean!=null){
            int status = landing_bean.getStatus();
            if (status==0){
                Constant.token = landing_bean.getData().getToken();
                houses = landing_bean.getData().getHouses();
                for (int i = 0; i < houses.size(); i++) {
                    house_id = houses.get(i).getHouse_id();

                }
                Toast.makeText(getActivity(), "登陆成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("house_id",house_id);
                startActivity(intent);

            }else if (status==1002) {
                Toast.makeText(getActivity(), landing_bean.getMsg(), Toast.LENGTH_SHORT).show();
            }else if(status==1004) {
            Toast.makeText(getActivity(), landing_bean.getMsg(), Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(getActivity(), landing_bean.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void getdata_Verification(Verification_bean verification_bean) {

    }
}
