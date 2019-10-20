package com.goketech.smartcommunity.fragment.repair_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.adaper.All_adaper;
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
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class All_Fragment extends BaseFragment<All_Contracy.View, All_Contracy.Presenter> implements All_Contracy.View {
    @BindView(R.id.rl)
    RecyclerView rl;
    Unbinder unbinder;
    private ArrayList<All_bean.DataBean> dataBeans1;
    private int a;
    private All_adaper all_adaper;

    @Override
    protected All_Contracy.Presenter getPresenter() {
        return new All_presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_all_;
    }

    @Override
    protected void initFragments() {
        a = Constant.house_id;
    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("community_id", a+"");
        map.put("status", "-1");

        String sign = ASCIIUtils.getSign(map);
        RequestBody requestBody = new FormBody.Builder()
                .add("status", "-1")
                .add("community_id", a+"")
                .add("sign", sign)
                .build();
        mPresenter.getData_All(requestBody);
    }

    @Override
    protected void initView() {
        dataBeans1 = new ArrayList<>();
        all_adaper = new All_adaper(dataBeans1, getActivity());
        rl.setAdapter(all_adaper);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rl.setLayoutManager(linearLayoutManager);
        all_adaper.notifyDataSetChanged();
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void getdata_All(All_bean all_bean) {
        if (all_bean != null) {
            int status = all_bean.getStatus();
            if (status == 0) {
                List<All_bean.DataBean> data = all_bean.getData();
                dataBeans1.addAll(data);
                all_adaper.notifyDataSetChanged();
                Toast.makeText(getActivity(), "你的全部订单", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder!=null){
            unbinder.unbind();
        }
    }
}
