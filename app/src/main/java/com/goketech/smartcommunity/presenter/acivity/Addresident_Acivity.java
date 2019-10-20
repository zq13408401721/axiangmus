package com.goketech.smartcommunity.presenter.acivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.app.Constant;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.Addresident_bean;
import com.goketech.smartcommunity.interfaces.contract.Repairs_Contracy;
import com.goketech.smartcommunity.presenter.Resident_Presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class Addresident_Acivity extends BaseActivity<Repairs_Contracy.View, Repairs_Contracy.Presenter> implements Repairs_Contracy.View {

    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.tl)
    Toolbar tl;
    @BindView(R.id.xiao)
    TextView xiao;
    @BindView(R.id.site)
    TextView site;
    @BindView(R.id.xian)
    TextView xian;
    @BindView(R.id.et_identity)
    EditText etIdentity;
    @BindView(R.id.xian1)
    TextView xian1;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.xian2)
    TextView xian2;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.rl_bost)
    RelativeLayout rlBost;
    @BindView(R.id.tv_ok)
    TextView tvOk;
    @BindView(R.id.jing)
    TextView jing;
    @BindView(R.id.sc)
    Switch sc;
    private int b;

    @Override
    protected Repairs_Contracy.Presenter getPresenter() {
        return new Resident_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_addresident_acivity;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        sc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b = 1;
                } else {
                    b=0;
                }
            }
        });
        etIdentity.setText("业主");

        tvOk.setOnClickListener(new View.OnClickListener() {
            private int a;
            @Override
            public void onClick(View v) {
                Map<String, String> map = new HashMap<>();
                int house_id = Constant.community_ids;
                int community_id = Constant.community_ids;
                int is_call = Constant.is_call;
                if (etIdentity.equals("业主")) {
                    a = 2;
                }
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                Log.e("name", name + "" + phone + "" + house_id + "" + community_id + "" + a + is_call);
                map.put("house_id", String.valueOf(house_id));
                map.put("community_id", String.valueOf(community_id));
                map.put("type", String.valueOf(a));
                map.put("is_call", String.valueOf(b));
                map.put("real_name", name);
                map.put("phone", phone);

                String sign = ASCIIUtils.getSign(map);
                RequestBody requestBody = new FormBody.Builder()
                        .add("house_id", String.valueOf(house_id))
                        .add("community_id", String.valueOf(community_id))
                        .add("type", String.valueOf(a))
                        .add("is_call", String.valueOf(b))
                        .add("real_name", name)
                        .add("phone", phone)
                        .add("sign", sign)
                        .build();
                mPresenter.getdata_resident(requestBody);
            }
        });
    }

    @Override
    protected void initListener() {


    }

    @Override
    public void getdata_resident(Addresident_bean addresident_bean) {
        if (addresident_bean != null) {
            int status = addresident_bean.getStatus();
            if (status == 0) {
                Toast.makeText(Addresident_Acivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            } else if (status == 1400) {
                Toast.makeText(Addresident_Acivity.this, "当前用户不是业主", Toast.LENGTH_SHORT).show();
            } else if (status == 1401) {
                Toast.makeText(Addresident_Acivity.this, "手机号不存在", Toast.LENGTH_SHORT).show();
            } else if (status == 1402) {
                Toast.makeText(Addresident_Acivity.this, "已经添加过该住户", Toast.LENGTH_SHORT).show();
            }
            Log.e("a", status + "");
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
