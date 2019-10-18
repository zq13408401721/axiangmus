package com.goketech.smartcommunity.presenter.acivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.goketech.smartcommunity.MainActivity;
import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.app.MyApp;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.WeiCode_bean;
import com.goketech.smartcommunity.fragment.landing.Landing_Fragment;
import com.goketech.smartcommunity.fragment.landing.Verification_Fragment;
import com.goketech.smartcommunity.interfaces.contract.WeiCode_Conreacy;
import com.goketech.smartcommunity.presenter.Weicaode_Presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;
import com.goketech.smartcommunity.utils.HttpCallBackListener;
import com.goketech.smartcommunity.utils.HttpUtil;
import com.goketech.smartcommunity.utils.PrefParams;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class Landing_acivity extends BaseActivity<WeiCode_Conreacy.View, WeiCode_Conreacy.Presenter> implements WeiCode_Conreacy.View {


    @BindView(R.id.color)
    Toolbar mColor;
    @BindView(R.id.background)
    ImageView mBackground;
    @BindView(R.id.fl_landing)
    FrameLayout mFlLanding;
    @BindView(R.id.tv_verificatiom)
    TextView mTvVerificatiom;
    @BindView(R.id.tv_passage)
    TextView mTvPassage;
    @BindView(R.id.WeChat)
    ImageView mWeChat;
    @BindView(R.id.v_vis)
    View mVVis;
    @BindView(R.id.v_viss)
    View mVViss;
    private String android_code = "a01973b3-38a2-4260-8caa-00c4b53e6d86";
    private String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
    public static final String TAG = "loginFragment";
    private IWXAPI api;
    private ReceiveBroadCast receiveBroadCast;
    private String access_token;
    private String openid;
    private String code;


    @Override
    protected WeiCode_Conreacy.Presenter getPresenter() {
        return new Weicaode_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_landing;
    }

    @Override
    protected void initFragments() {
        addFragment(getSupportFragmentManager(), Verification_Fragment.class, R.id.fl_landing, null);
    }

    @Override
    protected void initView() {
        mVViss.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void initListener() {

        mTvPassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(getSupportFragmentManager(), Landing_Fragment.class, R.id.fl_landing, null);
                mVViss.setVisibility(View.VISIBLE);
                mVVis.setVisibility(View.INVISIBLE);

            }
        });
        mTvVerificatiom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(getSupportFragmentManager(), Verification_Fragment.class, R.id.fl_landing, null);
                mVVis.setVisibility(View.VISIBLE);
                mVViss.setVisibility(View.INVISIBLE);
            }
        });
        mWeChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weChatAuth();
               /* Map<String, String> map = new HashMap<>();
              /*  Map<String, String> map = new HashMap<>();
                map.put("wx_code", code);
                String sign = ASCIIUtils.getSign(map);
                RequestBody requestBody = new FormBody.Builder()
                        .add("wx_code", code)
                        .add("sign",sign)
                        .build();
                mPresenter.getData_Weicaode(android_code,requestBody);*/
                mPresenter.getData_Weicaode(requestBody);

                Map<String,String> map1 = new HashMap<>();
                map1.put("code",code);
                map1.put("openid",openid);
                map1.put("access_token",access_token);
                map1.put("mode","3");
*/
              /*  String sign1 = ASCIIUtils.getSign(map);
                RequestBody requestBody1 = new FormBody.Builder()
                        .add("mode","3")
                        .add("openid",openid)
                        .add("access_token",access_token)
                        .add("code",code)
                        .add("sign",sign)
                        .build();
                mPresenter.*/
            }
        });
    }

    private void weChatAuth() {
        if (api == null) {
            api = WXAPIFactory.createWXAPI(Landing_acivity.this, MyApp.WX_APPID, true);
        }
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wx_login_duzun";
        api.sendReq(req);
    }

    @Override
    public void getdata_Weicaode(WeiCode_bean weiCode_bean) {
        if (weiCode_bean != null) {
            int status = weiCode_bean.getStatus();
            if (status == 0) {
                Toast.makeText(Landing_acivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
            } else if (status == 1010) {
                Intent intent = new Intent(Landing_acivity.this, Binding_acivity.class);
                startActivity(intent);
            }
        }
    }
    class ReceiveBroadCast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            getAccessToken();
            Intent intent1 = new Intent(Landing_acivity.this, MainActivity.class);
            startActivity(intent1);
        }
    }

    private void getAccessToken() {
        SharedPreferences WxSp = getApplicationContext().getSharedPreferences(PrefParams.spName, Context.MODE_PRIVATE);
        code = WxSp.getString(PrefParams.CODE, "");
        final SharedPreferences.Editor WxSpEditor = WxSp.edit();
        Log.d(TAG, "-----获取到的code----" + code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + MyApp.WX_APPID + "&secret=" + MyApp.WX_APPSecret + "&code=" + code + "&grant_type=authorization_code";
        Log.d(TAG, "--------即将获取到的access_token的地址--------");
        HttpUtil.sendHttpRequest(url, new HttpCallBackListener() {
            @Override
            public void onFinish(String response) {
                //解析以及存储获取到的信息
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Log.d(TAG, "-----获取到的json数据1-----" + jsonObject.toString());
                    access_token = jsonObject.getString("access_token");
                    Log.d(TAG, "--------获取到的access_token的地址--------" + access_token);
                    openid = jsonObject.getString("openid");
                    String refresh_token = jsonObject.getString("refresh_token");
                    if (!access_token.equals("")) {
                        WxSpEditor.putString(PrefParams.ACCESS_TOKEN, access_token);
                        WxSpEditor.apply();
                    }
                    if (!refresh_token.equals("")) {
                        WxSpEditor.putString(PrefParams.REFRESH_TOKEN, refresh_token);
                        WxSpEditor.apply();
                    }
                    if (!openid.equals("")) {
                        WxSpEditor.putString(PrefParams.WXOPENID, openid);
                        WxSpEditor.apply();
                        getPersonMessage(access_token, openid);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(Landing_acivity.this, "通过code获取数据没有成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getPersonMessage(String access_token, String openid) {
        String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token + "&openid=" + openid;
        HttpUtil.sendHttpRequest(url, new HttpCallBackListener() {
            @Override
            public void onFinish(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Log.d(TAG, "------获取到的个人信息------" + jsonObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(Landing_acivity.this, "通过openid获取数据没有成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        receiveBroadCast = new ReceiveBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction("authlogin");
        this.registerReceiver(receiveBroadCast, filter);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(receiveBroadCast);
    }
    @Override
    public void showError(String errorMsg) {

    }
}
