package com.goketech.smartcommunity.presenter.acivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.viewper.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Guide_acivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewpager;
    private List<View> views;
    /**
     * 跳过
     */
    private Button mBtTiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_acivity);
        initView();
    }

    private void initView() {
        mViewpager = (ViewPager) findViewById(R.id.viewpager);

        View inflate = View.inflate(Guide_acivity.this, R.layout.one, null);
        View inflate1 = View.inflate(Guide_acivity.this, R.layout.two, null);
        View inflate2 = View.inflate(Guide_acivity.this, R.layout.three, null);
        views = new ArrayList<View>();
        views.add(inflate);
        views.add(inflate1);
        views.add(inflate2);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(views, Guide_acivity.this);
        mViewpager.setAdapter(viewPagerAdapter);
        mBtTiao = (Button) findViewById(R.id.bt_tiao);
        mBtTiao.setOnClickListener(this);
        mViewpager.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_tiao:
                Intent intent = new Intent(Guide_acivity.this,Landing_acivity.class);
                startActivity(intent);
                break;
            case R.id.viewpager:
                break;
        }
    }
}
