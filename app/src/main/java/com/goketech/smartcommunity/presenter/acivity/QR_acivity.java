package com.goketech.smartcommunity.presenter.acivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.goketech.smartcommunity.Eventbus.MessageEvent;
import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.app.Constant;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.QR_bean;
import com.goketech.smartcommunity.interfaces.contract.Qr_Contracy;
import com.goketech.smartcommunity.presenter.Qr_Presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;
import com.goketech.smartcommunity.utils.QRCodeUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class QR_acivity extends BaseActivity<Qr_Contracy.View,Qr_Contracy.Presenter> implements Qr_Contracy.View {

    @BindView(R.id.iv_qr)
    ImageView ivQr;
    private String code_str;
    private RequestBody requestBody1;
    private int id;

    @Override
    protected Qr_Contracy.Presenter getPresenter() {
        return new Qr_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_qr_acivity;
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getdata(MessageEvent event){
        id = event.name;

    }
    @Override
    protected void initData() {
        Intent intent = getIntent();
        String house_id = intent.getStringExtra("house_id");
        if (id==0){
            Toast.makeText(this, "您没有绑定房屋", Toast.LENGTH_SHORT).show();
        }else{
        Map<String, String> map = new HashMap<>();
        map.put("community_id", "1");
        map.put("house_id", house_id);

        String sign = ASCIIUtils.getSign(map);
        requestBody1 = new FormBody.Builder()
                .add("community_id", "1")
                .add("house_id",  house_id+"")
                .add("sign", sign)
                .build();
        mPresenter.getData_QR(requestBody1);
        }
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void getdata_QR(QR_bean qr_bean) {
        if (qr_bean!=null){
            int status = qr_bean.getStatus();
            if (status==0){
                code_str = qr_bean.getData().getCode_str();
                Log.e("Tav",code_str);
                Bitmap mBitmap = QRCodeUtil.createQRCodeBitmap(code_str, 480, 480);
                ivQr.setImageBitmap(mBitmap);
            }
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消事件注册
        EventBus.getDefault().unregister(this);
    }
}
