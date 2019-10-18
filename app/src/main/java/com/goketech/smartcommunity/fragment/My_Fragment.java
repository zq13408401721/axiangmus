package com.goketech.smartcommunity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.app.Constant;
import com.goketech.smartcommunity.base.BaseFragment;
import com.goketech.smartcommunity.bean.My_bean;
import com.goketech.smartcommunity.interfaces.contract.My_Contracy;
import com.goketech.smartcommunity.presenter.My_Preserter;
import com.goketech.smartcommunity.presenter.acivity.My_Acivity;
import com.goketech.smartcommunity.presenter.acivity.My_house;
import com.goketech.smartcommunity.presenter.acivity.Repair_list_acivity;
import com.goketech.smartcommunity.presenter.acivity.Setting_acivity;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class My_Fragment extends BaseFragment<My_Contracy.View, My_Contracy.Presenter> implements My_Contracy.View {


    @BindView(R.id.tou)
    ImageView tou;
    @BindView(R.id.head)
    ImageView head;
    @BindView(R.id.jilu)
    TextView jilu;
    @BindView(R.id.xian)
    View xian;
    @BindView(R.id.processing)
    ImageView processing;
    @BindView(R.id.orders)
    ImageView orders;

    @BindView(R.id.evaluation)
    ImageView evaluation;
    @BindView(R.id.jiedan)
    TextView jiedan;
    @BindView(R.id.chuli)
    TextView chuli;

    @BindView(R.id.evaluate)
    TextView evaluate;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.fangwu)
    TextView fangwu;
    @BindView(R.id.geng)
    TextView geng;
    @BindView(R.id.xian1)
    View xian1;
    @BindView(R.id.rentou1)
    ImageView rentou1;
    @BindView(R.id.rentou2)
    ImageView rentou2;
    @BindView(R.id.rentou3)
    ImageView rentou3;
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.rl_fang)
    RelativeLayout rlFang;
    @BindView(R.id.huo)
    TextView huo;
    @BindView(R.id.geng1)
    TextView geng1;
    @BindView(R.id.xian2)
    View xian2;
    @BindView(R.id.shidai)
    TextView shidai;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.jie)
    TextView jie;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.rentous)
    ImageView rentous;
    @BindView(R.id.rentous1)
    ImageView rentous1;
    @BindView(R.id.rentous3)
    ImageView rentous3;
    @BindView(R.id.nums)
    TextView nums;
    Unbinder unbinder;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.louhao)
    TextView louhao;
    @BindView(R.id.set)
    ImageView set;
    Unbinder unbinder1;

    private String address;
    private String end_time;
    private int id;
    private String image;
    private String title;
    private int total_apply;
    private int status;

    private List<My_bean.DataBean.HouseListBean> house_list;
    private List<My_bean.DataBean.ActivityListBean> activity_list;

    @Override
    protected My_Contracy.Presenter getPresenter() {
        return new My_Preserter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_;
    }

    @Override
    protected void initListener() {
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Setting_acivity.class);
                startActivity(intent);
            }
        });
        jilu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        geng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), My_house.class);
                startActivity(intent);
            }
        });
        geng1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), My_Acivity.class);
                startActivity(intent);
            }
        });

        //处理中
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constant.id="2";
                Intent intent = new Intent(getActivity(), Repair_list_acivity.class);
                startActivity(intent);

            }
        });
        //待接单
        processing.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                for (int i = 0; i < house_list.size(); i++) {
                    Constant.house_id = house_list.get(i).getHouse_id();
                    Constant.is_call = house_list.get(i).getIs_call();
                    Constant.type = house_list.get(i).getType();
                }

                Constant.id="1";
                Intent intent = new Intent(getActivity(), Repair_list_acivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        String sign = ASCIIUtils.getSign(map);

        RequestBody requestBody = new FormBody.Builder()
                .add("sign", sign)
                .build();
        mPresenter.getData_My(requestBody);
    }

    @Override
    protected void initView() {

    }

    @Override
    public void getdata_My(My_bean my_bean) {
        if (my_bean != null) {
            status = my_bean.getStatus();
            if (status == 0) {
                //活动
                activity_list = my_bean.getData().getActivity_list();
                //房屋
                house_list = my_bean.getData().getHouse_list();
                for (int i = 0; i < house_list.size(); i++) {
                    String community = house_list.get(i).getCommunity();
                    String bulid = house_list.get(i).getBulid();
                    String room = house_list.get(i).getRoom();
                    String floor = house_list.get(i).getFloor();
                    String unit = house_list.get(i).getUnit();
                    tvName.setText(community);
                    louhao.setText(bulid + "号楼" + unit + "单元" + floor + room);
                 Constant.community_ids =house_list.get(i).getCommunity_id();

                }

                for (int i = 0; i < activity_list.size(); i++) {
                    String title = activity_list.get(i).getTitle();
                    String address = activity_list.get(i).getAddress();
                    int total_apply = activity_list.get(i).getTotal_apply();
                    String end_time = activity_list.get(i).getEnd_time();
                    shidai.setText(title);
                    time.setText(end_time);
                    jie.setText(end_time);
                    dizhi.setText(address);
                    nums.setText(total_apply + "");
                }
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}