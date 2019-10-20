package com.goketech.smartcommunity.presenter.acivity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.app.Constant;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.Visitor_bean;
import com.goketech.smartcommunity.interfaces.contract.Visitors_Contracy;
import com.goketech.smartcommunity.presenter.Visitor_Presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.RequestBody;

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
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.fangkeshu)
    EditText fangkeshu;
    @BindView(R.id.dpPicker)
    DatePicker dpPicker;
    @BindView(R.id.dao)
    TextView dao;
    @BindView(R.id.dpPicker1)
    DatePicker dpPicker1;
    private FragmentManager manager;
    private String numbar;
    private String y;
    private String f;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
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


    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initListener() {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final int hour_id = Constant.houre_id;
        final String name = etName.getText().toString();
        final String phone = etPhone.getText().toString();
        final String Cause = etCause.getText().toString();
        final String fangke = fangkeshu.getText().toString();

        dpPicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                y=year+monthOfYear+dayOfMonth+"";
            }
        });
        dpPicker1.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                f=year+monthOfYear+dayOfMonth+"";
                Log.i("f",f);
            }
        });

        yaoqing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> map = new HashMap<>();
                map.put("community_id", "1");
                map.put("house_id", hour_id + "");
                map.put("name", name + "");
                map.put("phone", phone);
                map.put("number", fangke);
                map.put("reason", Cause);
                map.put("type",  "1");
                map.put("visitor_number", "1");
                map.put("start_time", y);
                map.put("end_time", f);
                String sign = ASCIIUtils.getSign(map);

                RequestBody requestBody = new FormBody.Builder()
                        .add("community_id", "1")
                        .add("house_id", hour_id + "")
                        .add("name", name + "")
                        .add("phone", phone)
                        .add("number", fangke)
                        .add("reason", Cause)
                        .add("type", "1")
                        .add("visitor_number", "1")
                        .add("start_time", y)
                        .add("end_time", f)
                        .add("sign", sign)
                        .build();
                mPresenter.getData_visitors(requestBody);
            }
        });
    }

    @Override
    public void showError(String errorMsg) {


    }

    @Override
    public void getdata_visitors(Visitor_bean visitor_bean) {
        if (visitor_bean!=null){
            int status = visitor_bean.getStatus();
            if (status==0){
                Toast.makeText(Visitors_acivity.this, "完成", Toast.LENGTH_SHORT).show();
            }
            Log.e("Tab",status+"");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}