package com.goketech.smartcommunity.presenter.acivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Setting_acivity extends BaseActivity {

    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.tl)
    Toolbar tl;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_names)
    TextView tvNames;
    @BindView(R.id.xain)
    TextView xain;
    @BindView(R.id.tv_identity)
    TextView tvIdentity;
    @BindView(R.id.xian)
    TextView xian;
    @BindView(R.id.modification)
    TextView modification;
    @BindView(R.id.xian2)
    TextView xian2;
    @BindView(R.id.blacklist)
    TextView blacklist;
    @BindView(R.id.xian3)
    TextView xian3;
    @BindView(R.id.WeChat)
    TextView WeChat;
    @BindView(R.id.xian4)
    TextView xian4;
    @BindView(R.id.hu_bo)
    TextView huBo;
    @BindView(R.id.scs)
    Switch scs;
    @BindView(R.id.xian5)
    TextView xian5;
    @BindView(R.id.guanyu)
    TextView guanyu;
    @BindView(R.id.xian6)
    TextView xian6;
    @BindView(R.id.yijian)
    TextView yijian;
    @BindView(R.id.xian7)
    TextView xian7;
    @BindView(R.id.autonym)
    ImageView autonym;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting_acivity;
    }

    @Override
    protected void initFragments() {
        Intent intent = getIntent();
        String sd = intent.getStringExtra("sd");
        String name = intent.getStringExtra("name");
       tvNames.setText(name);

    }

    @Override
    protected void initListener() {

        autonym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting_acivity.this,Autonym_acivity.class);
                startActivity(intent);
            }
        });
        modification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting_acivity.this, Find_acivity.class);
                startActivity(intent);
            }
        });
        guanyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting_acivity.this, Regard_Acivity.class);
                startActivity(intent);
            }
        });

        yijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Setting_acivity.this, "asdasf", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Setting_acivity.this,Feedback_Acivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showError(String errorMsg) {

    }
}
