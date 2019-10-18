package com.goketech.smartcommunity.presenter.acivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.goketech.smartcommunity.R;

public class Nofees_acivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mFan;
    private Toolbar mTl;
    private RecyclerView mRlList;
    /**
     * 滞纳金
     */
    private TextView mOverdue;
    private View mXian;
    /**
     * 如需发票，请联系物业
     */
    private TextView mTong;
    private RelativeLayout mRlBilling;
    /**
     * 登陆
     */
    private Button mBtLandings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nofees_acivity);
        initView();
    }

    private void initView() {
        mFan = (ImageView) findViewById(R.id.fan);
        mTl = (Toolbar) findViewById(R.id.tl);
        mRlList = (RecyclerView) findViewById(R.id.rl_list);
        mOverdue = (TextView) findViewById(R.id.overdue);
        mXian = (View) findViewById(R.id.xian);
        mTong = (TextView) findViewById(R.id.tong);
        mRlBilling = (RelativeLayout) findViewById(R.id.rl_billing);
        mBtLandings = (Button) findViewById(R.id.bt_landings);
        mBtLandings.setOnClickListener(this);
        mFan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_landings:
                break;
        }
    }
}
