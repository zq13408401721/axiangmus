package com.goketech.smartcommunity.presenter.acivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.app.Constant;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.Commonality_bean;
import com.goketech.smartcommunity.bean.Repairs_bean;
import com.goketech.smartcommunity.interfaces.contract.Repair_contracy;
import com.goketech.smartcommunity.presenter.Repairs_presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class Repairs_acivity extends BaseActivity<Repair_contracy.View, Repair_contracy.Presenter> implements Repair_contracy.View {

    @BindView(R.id.tt)
    TextView mTt;
    @BindView(R.id.et_describe)
    EditText mEtDescribe;
    @BindView(R.id.tv_number)
    TextView mTvNumber;
    @BindView(R.id.xian)
    TextView mXian;
    @BindView(R.id.dizhi)
    TextView mDizhi;
    @BindView(R.id.site)
    EditText mSite;
    @BindView(R.id.shijian)
    TextView mShijian;
    @BindView(R.id.time)
    EditText mTime;
    @BindView(R.id.dianhua)
    TextView mDianhua;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.bt_tijiao)
    Button btTijiao;
    @BindView(R.id.tl)
    TabLayout tl;

    @BindView(R.id.quantum)
    TextView quantum;
    @BindView(R.id.et_quantum)
    EditText etQuantum;
    @BindView(R.id.fan)
    ImageView fan;
    private int num = 200;

    private CharSequence recording;
    private int id1;
    private List<Commonality_bean.DataBean.RepairBean> repair;
    private String name;

    @Override
    protected Repair_contracy.Presenter getPresenter() {
        return new Repairs_presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_repairs_acivity;
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
       List<Commonality_bean.DataBean.RepairBean> list = new ArrayList<>();
        list=Constant.list;
        for (int i = 0; i < list.size(); i++) {
            name = list.get(i).getName();
            tl.addTab(tl.newTab().setText(name));
        }
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mEtDescribe.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                recording = s;
                int length = recording.length();
                mTvNumber.setText(length + "/" + num);
            }
        });

    }

    @Override
    protected void initData() {

        btTijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String miao = mEtDescribe.getText().toString();
                String site = mSite.getText().toString();
                String time = mTime.getText().toString();
                String phone = etPhone.getText().toString();
                String Quantum = etQuantum.getText().toString();

                Map<String, String> map = new HashMap<>();
                map.put("community_id", "1");
                map.put("dict_id", id1 + "");
                map.put("remark", miao);
                map.put("images", "1");
                map.put("address", site);
                map.put("phone", phone);
                map.put("time", time);
                map.put("make_at", Quantum);
                String sign = ASCIIUtils.getSign(map);

                RequestBody requestBody = new FormBody.Builder()
                        .add("community_id", "1")
                        .add("dict_id", id1 + "")
                        .add("remark", miao)
                        .add("images", "1")
                        .add("address", site)
                        .add("phone", phone)
                        .add("date", time)
                        .add("make_at", Quantum)
                        .add("sign", sign)
                        .build();
                mPresenter.getData_Repair(requestBody);

                Map<String, String> mapss = new HashMap<>();
                String sign1 = ASCIIUtils.getSign(mapss);
                RequestBody requestBodyss = new FormBody.Builder()
                        .add("sign", sign1)
                        .build();
                mPresenter.getData_Commonality(requestBodyss);

                for (int i = 0; i < repair.size(); i++) {
                    tl.addTab(tl.newTab().setText(repair.get(i).getName()));
                }

            }
        });

    }

    @Override
    public void getdata_Repair(Repairs_bean repairs_bean) {
        if (repairs_bean != null) {
            int status = repairs_bean.getStatus();
            if (status == 0) {
                Toast.makeText(Repairs_acivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            } else {
                Log.e("Tabs", status + "");
            }
        }
    }

    @Override
    public void getdata_Commonality(Commonality_bean commonality_bean) {
        if (commonality_bean != null) {
            int status = commonality_bean.getStatus();
            if (status == 0) {
                Toast.makeText(Repairs_acivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                repair = commonality_bean.getData().getRepair();
                for (int i = 0; i < repair.size(); i++) {
                    id1 = repair.get(i).getId();

                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
