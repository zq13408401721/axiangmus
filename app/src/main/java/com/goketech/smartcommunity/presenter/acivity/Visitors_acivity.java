package com.goketech.smartcommunity.presenter.acivity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.Visitor_bean;
import com.goketech.smartcommunity.fragment.Come.Number_fragment;
import com.goketech.smartcommunity.fragment.Come.Time_fragment;
import com.goketech.smartcommunity.fragment.Home_Fragment;
import com.goketech.smartcommunity.interfaces.contract.Visitors_Contracy;
import com.goketech.smartcommunity.presenter.Visitor_Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Visitors_acivity extends BaseActivity<Visitors_Contracy.View, Visitors_Contracy.Presenter> implements Visitors_Contracy.View {


    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.toob_fangke)
    Toolbar toobFangke;
    @BindView(R.id.fangke)
    TextView fangke;
    @BindView(R.id.dianhua)
    TextView dianhua;
    @BindView(R.id.shuliang)
    TextView shuliang;
    @BindView(R.id.tv_fangshi)
    TextView tvFangshi;
    @BindView(R.id.xian)
    View xian;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.ll_date)
    LinearLayout llDate;
    @BindView(R.id.yuanyin)
    TextView yuanyin;
    @BindView(R.id.et_cause)
    EditText etCause;
    @BindView(R.id.v_xian)
    View vXian;
    @BindView(R.id.yaoqing)
    Button yaoqing;
    @BindView(R.id.rb_time)
    RadioButton rbTime;
    @BindView(R.id.rb_number)
    RadioButton rbNumber;
    @BindView(R.id.rg)
    RadioGroup rg;

    @Override
    protected Visitors_Contracy.Presenter getPresenter() {
        return new Visitor_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_visitors_acivity;
    }

    @Override
    protected void initFragments() {
        FragmentManager manager = getSupportFragmentManager();
        if(rbTime.isChecked()){
           addFragment(manager, Time_fragment.class, R.id.fl, null);
       }else if (rbNumber.isChecked()){
           addFragment(manager, Number_fragment.class, R.id.fl, null);
       }
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initListener() {
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        yaoqing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   Map<String, String> map = new HashMap<>();
                map.put("community_id", "1");
                map.put("house_id", id1 + "");
                map.put("name", miao);
                map.put("phone", "1");
                map.put("number", site);
                map.put("reason", phone);
                map.put("type", time);
                map.put("visitor_number", Quantum);
                map.put("start_time", Quantum);
                map.put("end_time", Quantum);
                String sign = ASCIIUtils.getSign(map);

                RequestBody requestBody = new FormBody.Builder()
                        .add("community_id", "1")
                        .add("house_id", id1 + "")
                        .add("name", miao)
                        .add("phone", "1")
                        .add("number", site)
                        .add("reason", phone)
                        .add("type", time)
                        .add("visitor_number", Quantum)
                        .add("start_time", Quantum)
                        .add("end_time", Quantum)
                        .add("sign", sign)
                        .build();*/
            }
        });
    }

    @Override
    public void showError(String errorMsg) {


    }

    @Override
    public void getdata_visitors(Visitor_bean visitor_bean) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}