package com.goketech.smartcommunity.fragment.repair_fragment;


import android.os.Bundle;



import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseFragment;
import com.goketech.smartcommunity.interfaces.IBasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Processing_fragment extends BaseFragment {

import com.goketech.smartcommunity.adaper.Orange_adaper;
import com.goketech.smartcommunity.adaper.Processing_adaper;
import com.goketech.smartcommunity.app.Constant;
import com.goketech.smartcommunity.base.BaseFragment;
import com.goketech.smartcommunity.bean.All_bean;
import com.goketech.smartcommunity.interfaces.contract.All_Contracy;
import com.goketech.smartcommunity.presenter.All_presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;
import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class Processing_fragment extends BaseFragment<All_Contracy.View, All_Contracy.Presenter> implements All_Contracy.View {


    @BindView(R.id.rl)
    RecyclerView rl;
    Unbinder unbinder;
    private int a;
    private ArrayList<All_bean.DataBean> dataBeans1;
    private Orange_adaper Orange_adaper;
    private Processing_adaper processing_adaper;


    public Processing_fragment() {
        // Required empty public constructor
    }

    @Override
    protected All_Contracy.Presenter getPresenter() {
        return new All_presenter();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_processing_fragment;
    }

    @Override
    protected void initFragments() {
        a = Constant.house_id;
    }

    @Override
    protected void initView() {
        dataBeans1 = new ArrayList<>();
        processing_adaper = new Processing_adaper(dataBeans1, getActivity());
        rl.setAdapter(processing_adaper);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rl.setLayoutManager(linearLayoutManager);
        processing_adaper.notifyDataSetChanged();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("community_id", a+"");
        map.put("status", "2");

        String sign = ASCIIUtils.getSign(map);
        RequestBody requestBody = new FormBody.Builder()
                .add("status", "1")
                .add("community_id", a+"")
                .add("sign", sign)
                .build();
        mPresenter.getData_All(requestBody);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder!=null){
            unbinder.unbind();
        }
    }

    @Override
<<<<<<< HEAD
    public void getdata_All(All_bean all_bean) {
        if (all_bean != null) {
            int status = all_bean.getStatus();
            if (status == 0) {
                List<All_bean.DataBean> data = all_bean.getData();
                dataBeans1.addAll(data);
                Orange_adaper.notifyDataSetChanged();
                if (data.equals("")){
                    Toast.makeText(getActivity(),"您还没有需要评价的订单" ,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "正等待您的评价", Toast.LENGTH_SHORT).show();
                }

            } else {
                Log.i("Tab", String.valueOf(status));
            }
        }
    }
=======
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

>>>>>>> origin/master
}
