package com.goketech.smartcommunity.presenter.acivity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.goketech.smartcommunity.MainActivity;
import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.app.Constant;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.Landing_bean;
import com.goketech.smartcommunity.bean.Verification_bean;
import com.goketech.smartcommunity.interfaces.contract.Landing_Contracy;
import com.goketech.smartcommunity.presenter.Landing_presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class Verification_acivity extends BaseActivity<Landing_Contracy.View, Landing_Contracy.Presenter> implements Landing_Contracy.View, View.OnFocusChangeListener {

    @BindView(R.id.fan)
    ImageView mFan;
    @BindView(R.id.enclosed)
    TextView mEnclosed;
    @BindView(R.id.ll_verification)
    LinearLayout mLlVerification;
    @BindView(R.id.anew)
    TextView mAnew;
    @BindView(R.id.bt_landing)
    Button mBtLanding;
    @BindView(R.id.edit_first1)
    EditText first1;
    @BindView(R.id.edit_first2)
    EditText first2;
    @BindView(R.id.edit_first)
    EditText first;
    @BindView(R.id.edit_second)
    EditText second;
    @BindView(R.id.edit_third)
    EditText third;
    @BindView(R.id.edit_fourth)
    EditText fourth;
    private List<EditText> mEdits = new ArrayList<EditText>();
    private OnInputFinishListener mInputListener;
    private Context context;
    private String android_code = "a01973b3-38a2-4260-8caa-00c4b53e6d86";

    private String code;
    private String phone1;

    @Override
    protected Landing_Contracy.Presenter getPresenter() {
        return new Landing_presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_verification;
    }

    @Override
    protected void initView() {
        mEdits.add(first);
        mEdits.add(first1);
        mEdits.add(first2);
        mEdits.add(second);
        mEdits.add(third);
        mEdits.add(fourth);

        first.setFocusable(true);
        first.addTextChangedListener(new MyTextWatcher());
        first1.addTextChangedListener(new MyTextWatcher());
        first2.addTextChangedListener(new MyTextWatcher());
        second.addTextChangedListener(new MyTextWatcher());
        third.addTextChangedListener(new MyTextWatcher());
        fourth.addTextChangedListener(new MyTextWatcher());


        first.setOnFocusChangeListener(this);
        first1.setOnFocusChangeListener(this);
        first2.setOnFocusChangeListener(this);
        second.setOnFocusChangeListener(this);
        third.setOnFocusChangeListener(this);
        fourth.setOnFocusChangeListener(this);
        Intent intent = getIntent();
        phone1 = intent.getStringExtra("phone");
        mEnclosed.setText("验证码已发送至+" + phone1);

    }

    @Override
    public void onFocusChange(View view, boolean focus) {
        if (focus) {
            focus();
        }
    }

    public void setmInputListener(OnInputFinishListener mInputListener) {
        this.mInputListener = mInputListener;
    }


    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected void initData() {
        mFan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBtLanding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = first.getText().toString();
                String s1 = first1.getText().toString();
                String s2 = first2.getText().toString();
                String s3 = second.getText().toString();
                String s4 = third.getText().toString();
                String s5 = fourth.getText().toString();
                code = s + s1 + s2 + s3 + s4 + s5;

                Map<String, String> map = new HashMap<>();
                map.put("phone", phone1);
                map.put("mode", "2");
                map.put("code", code);

                String sign = ASCIIUtils.getSign(map);
                RequestBody requestBody = new FormBody.Builder()
                        .add("phone", phone1)
                        .add("mode", "2")
                        .add("code", code)
                        .add("sign", sign)
                        .build();
                mPresenter.getData_landing("a01973b3-38a2-4260-8caa-00c4b53e6d86", requestBody);
            }
        });

    }

    @Override
    public void getdata_landing(Landing_bean landing_bean) {
        if (landing_bean != null) {
            int status = landing_bean.getStatus();
            if (status == 0) {
                Log.e("Tab", String.valueOf(status));
                Constant.token = landing_bean.getData().getToken();
                Intent intent = new Intent(Verification_acivity.this, MainActivity.class);

                startActivity(intent);
                Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();


            } else if (status==1000){
                Log.e("Tab", String.valueOf(status));
                Intent intent1 = new Intent(Verification_acivity.this, Enter_password_acivity.class);
                intent1.putExtra("code",code);
                intent1.putExtra("phone",phone1);
                startActivity(intent1);
            }else if (status==1002){
                Toast.makeText(Verification_acivity.this, landing_bean.getMsg(), Toast.LENGTH_SHORT).show();
            }else if(status==1004){
                Toast.makeText(Verification_acivity.this, landing_bean.getMsg(), Toast.LENGTH_SHORT).show();

            }else{

            }
        }
    }

    @Override
    public void getdata_Verification(Verification_bean verification_bean) {
        if (verification_bean != null) {
            int status = verification_bean.getStatus();
            if (status == 0) {
                Toast.makeText(Verification_acivity.this, "请稍等", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Verification_acivity.this, "您没有绑定房屋", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private class MyTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (editable.length() != 0) {
                focus();
            }
        }
    }

    @Override
    protected void initListener() {
        mFan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mAnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           /*     Intent intent = getIntent();
                String phone = intent.getStringExtra("phone");*/

                Map<String, String> map = new HashMap<>();
                map.put("phone", phone1);

                String sign = ASCIIUtils.getSign(map);

                RequestBody requestBody = new FormBody.Builder()
                        .add("phone", phone1)
                        .add("sign", sign)
                        .build();
                mPresenter.getData_Verification( requestBody);
            }
        });
    }

    private void focus() {
        EditText editText;
        //利用for循环找出前面还没被输入字符的EditText
        for (int i = 0; i < mEdits.size(); i++) {
            editText = mEdits.get(i);
            if (editText.getText().length() < 1) {
                editText.requestFocus();
                return;
            } else {
                editText.setCursorVisible(false);
            }
        }
        EditText lastEditText = mEdits.get(mEdits.size() - 1);
        if (lastEditText.getText().length() > 0) {
            //收起软键盘 并不允许编辑 同时将输入的文本提交
            getResponse();
            lastEditText.setCursorVisible(false);
            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

        }
    }

    public void getResponse() {
        Log.e("CodeView", "ok");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mEdits.size(); i++) {
            sb.append(mEdits.get(i).getText().toString());
        }
        if (mInputListener != null) {
            mInputListener.onFinish(sb.toString());
        }
    }

    //对外封装一个重置或直接填写验证码的方法
    public void setText(String text) {
        if (text.length() == mEdits.size()) {
            StringBuilder sb = new StringBuilder(text);
            first.setText(sb.substring(0, 1));
            first1.setText(sb.substring(1, 2));
            first2.setText(sb.substring(2, 3));
            second.setText(sb.substring(3, 4));
            third.setText(sb.substring(4, 5));
            fourth.setText(sb.substring(5, 6));
        } else {
            first.setText("");
            first1.setText("");
            first2.setText("");
            second.setText("");
            third.setText("");
            fourth.setText("");
            first.setCursorVisible(true);
            first.requestFocus();
        }
    }

    //一个监听输入结束的接口，以便外部回调结束后执行的方法
    public interface OnInputFinishListener {
        void onFinish(String code);
    }

    @Override
    public void showError(String errorMsg) {

    }
}