package com.goketech.smartcommunity.presenter.acivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.Binding_bean;
import com.goketech.smartcommunity.interfaces.contract.Binding_Contracy;
import com.goketech.smartcommunity.presenter.Banding_Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HourBinding_acivit extends BaseActivity<Binding_Contracy.View, Binding_Contracy.Presenter> implements Binding_Contracy.View {

    @BindView(R.id.fang)
    TextView fang;
    @BindView(R.id.tl)
    Toolbar tl;
    @BindView(R.id.tv_xiugai)
    TextView tvXiugai;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.louyu)
    TextView louyu;
    @BindView(R.id.building)
    TextView building;
    @BindView(R.id.dan)
    TextView dan;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.fan)
    ImageView fan;

    @Override
    protected Binding_Contracy.Presenter getPresenter() {
        return new Banding_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_binding_acivit;
    }

    @Override
    protected void initView() {
        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();
        select.setText("物主");
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        louyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.new 对象
                //2.指定三要素
                //3.显示
                final PopupWindow popupWindow = new PopupWindow();
                //必须给定三要素: 视图(view),宽,高
                //view
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 0.7f;
                getWindow().setAttributes(lp);

                View inflate = LayoutInflater.from(HourBinding_acivit.this).inflate(R.layout.popupwindow, null, false);
                popupWindow.setContentView(inflate);
                //宽
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                //高
                popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

                View inflate1 = LayoutInflater.from(HourBinding_acivit.this).inflate(R.layout.fragment_home_, null, false);
                popupWindow.showAtLocation(inflate1, Gravity.CENTER, 0, 0);
                ImageView pop_img = inflate.findViewById(R.id.pop_img);
                pop_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        WindowManager.LayoutParams lp = getWindow().getAttributes();
                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);
                    }
                });
            }
        });
        building.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
      /*  Map<String, String> map = new HashMap<>();
        map.put("phone", phone);
        map.put("password", passage);
        map.put("c_password", newpassword);
        map.put("code", code);

        String sign = ASCIIUtils.getSign(map);

        RequestBody requestBody = new FormBody.Builder()
                .add("phone", phone)
                .add("password",passage)
                .add("c_password",newpassword)
                .add("code", code)
                .add("sign", sign)
                .build();*/
    }

    @Override
    protected void initListener() {
    fan.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void getdata_Binding(Binding_bean binding_bean) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
