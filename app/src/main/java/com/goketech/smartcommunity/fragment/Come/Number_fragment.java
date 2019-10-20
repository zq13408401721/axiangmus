package com.goketech.smartcommunity.fragment.Come;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.app.Constant;
import com.goketech.smartcommunity.base.BaseFragment;
import com.goketech.smartcommunity.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Number_fragment extends BaseFragment {

    @BindView(R.id.shiduan)
    TextView shiduan;
    @BindView(R.id.et_number)
    EditText etNumber;
    Unbinder unbinder;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_number_fragment;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder!=null){
            unbinder.unbind();
        }
    }
    //接口回调
     public void getEditText(CallBack callBack) {
                String msg = etNumber.getText().toString();
                callBack.getResult(msg);
             }
     public interface CallBack {
         public void getResult(String result);
     }

}
