package com.goketech.smartcommunity.fragment.repair_fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.adaper.Orange_adaper;
import com.goketech.smartcommunity.adaper.Receiving_adaper;
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
public class Orders_fragment extends BaseFragment<All_Contracy.View, All_Contracy.Presenter> implements All_Contracy.View {

    @BindView(R.id.fl)
    RecyclerView fl;
    Unbinder unbinder;
    private String community_id;
    private ArrayList<All_bean.DataBean> dataBeans1;
    private Orange_adaper Orange_adaper;
    private int a;

    @Override
    protected All_Contracy.Presenter getPresenter() {
        return new All_presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_orders_fragment;
    }

    @Override
    protected void initFragments() {
        a = Constant.house_id;
    }

    @Override
    protected void initView() {
        dataBeans1 = new ArrayList<>();
        Orange_adaper = new Orange_adaper(dataBeans1, getActivity());
        fl.setAdapter(Orange_adaper);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        fl.setLayoutManager(linearLayoutManager);
        Orange_adaper.notifyDataSetChanged();
    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("community_id", a+"");
        map.put("status", "1");

        String sign = ASCIIUtils.getSign(map);
        RequestBody requestBody = new FormBody.Builder()
                .add("status", "1")
                .add("community_id", a+"")
                .add("sign", sign)
                .build();
        mPresenter.getData_All(requestBody);
    }

    @Override
    protected void initListener() {
        Orange_adaper.setPhone(new Orange_adaper.Phones() {
            @Override
            public void Phone(int p, final String phone, TextView tv) {
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        Uri data = Uri.parse("tel:" + phone);
                        intent.setData(data);
                        startActivity(intent);
                    }
                });
            }
        });

    }

    @Override
    public void getdata_All(All_bean all_bean) {
        if (all_bean != null) {
            int status = all_bean.getStatus();
            if (status == 0) {
                List<All_bean.DataBean> data = all_bean.getData();
                dataBeans1.addAll(data);
                Orange_adaper.notifyDataSetChanged();
<<<<<<< HEAD

                Toast.makeText(getActivity(),"处理中", Toast.LENGTH_SHORT).show();


                if (data.equals("")){
                    Toast.makeText(getActivity(),"您还没有接单" ,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "正在进行中的订单", Toast.LENGTH_SHORT).show();
                }

=======
                if (data!=null){
                    Toast.makeText(getActivity(),"您接收到的订单正在处理中", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),"您没有要处理的订单", Toast.LENGTH_SHORT).show();
                }
>>>>>>> origin/master
            }else{
                Log.i("Tab", String.valueOf(status));
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
