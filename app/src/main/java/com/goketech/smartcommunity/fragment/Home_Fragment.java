package com.goketech.smartcommunity.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.base.BaseFragment;
import com.goketech.smartcommunity.bean.Announce_bean;
import com.goketech.smartcommunity.bean.Commonality_bean;
import com.goketech.smartcommunity.bean.Home_bean;
import com.goketech.smartcommunity.interfaces.contract.Home_Contracy;
import com.goketech.smartcommunity.presenter.Home_Presenter;
import com.goketech.smartcommunity.presenter.acivity.Announcement_acivity;
import com.goketech.smartcommunity.presenter.acivity.Number_acivity;
import com.goketech.smartcommunity.presenter.acivity.QR_acivity;
import com.goketech.smartcommunity.presenter.acivity.Repairs_acivity;
import com.goketech.smartcommunity.presenter.acivity.Visitors_acivity;
import com.goketech.smartcommunity.utils.ASCIIUtils;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class Home_Fragment extends BaseFragment<Home_Contracy.View, Home_Contracy.Presenter> implements Home_Contracy.View {


    @BindView(R.id.weather)
    ImageView mWeather;
    @BindView(R.id.tb)
    Toolbar mTb;
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.fees)
    ImageView mFees;
    @BindView(R.id.iv_guanli)
    ImageView mIvGuanli;
    @BindView(R.id.ll_iv)
    LinearLayout mLlIv;
    @BindView(R.id.entrance)
    TextView mEntrance;
    @BindView(R.id.managment)
    TextView mManagment;
    @BindView(R.id.cost)
    TextView mCost;
    @BindView(R.id.warranty)
    TextView mWarranty;
    @BindView(R.id.ll_text)
    LinearLayout mLlText;
    @BindView(R.id.tongzhi)
    ImageView mTongzhi;
    @BindView(R.id.latest)
    TextView mLatest;
    @BindView(R.id.tv_tong)
    TextView mTvTong;
    @BindView(R.id.iv_tu)
    ImageView mIvTu;
    @BindView(R.id.tv_titl)
    TextView mTvTitl;
    @BindView(R.id.tv_tit11)
    TextView mTvTit11;
    @BindView(R.id.tv_titl11)
    TextView mTvTitl11;
    @BindView(R.id.ll_title)
    RelativeLayout mLlTitle;
    @BindView(R.id.iv_tu1)
    ImageView mIvTu1;
    @BindView(R.id.title1)
    TextView mTitle1;
    @BindView(R.id.title2)
    TextView mTitle2;
    @BindView(R.id.tv_title3)
    TextView mTvTitle3;
    @BindView(R.id.fei)
    ImageView fei;
    Unbinder unbinder1;
    @BindView(R.id.repairs)
    ImageView repairs;
    @BindView(R.id.visitor)
    ImageView visitor;
    Unbinder unbinder;
    private Bundle house_id;
    private String name;

    @Override
    protected Home_Contracy.Presenter getPresenter() {
        return new Home_Presenter();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_;

    }

    @Override
    protected void initView() {
        Intent intent = getActivity().getIntent();
        house_id = intent.getBundleExtra("house_id");


    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("company_id", "1");
        map.put("community_id", "1");
        String sign = ASCIIUtils.getSign(map);

        RequestBody requestBody = new FormBody.Builder()
                .add("company_id", "1")
                .add("community_id", "1")
                .add("sign", sign)
                .build();
        mPresenter.getData_Home(requestBody);


        Map<String, String> maps = new HashMap<>();
        maps.put("company_id", "1");
        maps.put("community_id", "1");
        maps.put("p", String.valueOf(1));
        maps.put("limit", String.valueOf(20));

        String signs = ASCIIUtils.getSign(maps);

        RequestBody requestBodys = new FormBody.Builder()
                .add("company_id", "1")
                .add("community_id", "1")
                .add("p", "1")
                .add("limit", "20")
                .add("sign", signs)
                .build();
        mPresenter.getData_Announce(requestBodys);


        Map<String, String> mapss = new HashMap<>();
        String sign1 = ASCIIUtils.getSign(mapss);
        RequestBody requestBodyss = new FormBody.Builder()
                .add("sign", sign1)
                .build();
        mPresenter.getData_Commonality(requestBodyss);
    }

    @Override
    protected void initListener() {
        //新增访客
        visitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.new 对象
                //2.指定三要素
                //3.显示
                final PopupWindow popupWindow = new PopupWindow();
                //必须给定三要素: 视图(view),宽,高
                //view
                WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
                lp.alpha = 0.7f;
                getActivity().getWindow().setAttributes(lp);

                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.visiors_popuwind, null, false);
                popupWindow.setContentView(inflate);
                //宽
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                //高
                popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

                View inflate1 = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_, null, false);
                popupWindow.showAtLocation(inflate1, Gravity.CENTER, 0, 0);
                ImageView pop_img = inflate.findViewById(R.id.pop_img);
                pop_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
                        lp.alpha = 1f;
                        getActivity().getWindow().setAttributes(lp);
                    }
                });
                Button shijian = inflate.findViewById(R.id.shijian);
                Button number = inflate.findViewById(R.id.number);
               shijian.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent = new Intent(getActivity(), Visitors_acivity.class);
                       startActivity(intent);
                   }
               });
               number.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent = new Intent(getActivity(), Number_acivity.class);
                       startActivity(intent);
                   }
               });



            }
        });
        //保修服务
        repairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Repairs_acivity.class);
                startActivity(intent);

            }
        });
        //物业缴费
        fei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Announcement_acivity.class);
                startActivity(intent);
            }
        });
        //二维码
        mFees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QR_acivity.class);
                intent.putExtra("house_id", house_id);
                startActivity(intent);
            }
        });
        //联系物业
        mIvGuanli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.new 对象
                //2.指定三要素
                //3.显示
                final PopupWindow popupWindow = new PopupWindow();
                //必须给定三要素: 视图(view),宽,高
                //view
                WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
                lp.alpha = 0.7f;
                getActivity().getWindow().setAttributes(lp);

                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.popup, null, false);
                popupWindow.setContentView(inflate);
                //宽
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                //高
                popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

                View inflate1 = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_, null, false);
                popupWindow.showAtLocation(inflate1, Gravity.CENTER, 0, 0);
                ImageView pop_img = inflate.findViewById(R.id.pop_img);
                pop_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
                        lp.alpha = 1f;
                        getActivity().getWindow().setAttributes(lp);
                    }
                });
                Button viewById = inflate.findViewById(R.id.hujiao);
                viewById.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        Uri data = Uri.parse("tel:" + "13147721690");
                        intent.setData(data);
                        startActivity(intent);

                    }
                });
            }
        });
    }

    @Override
    public void getdata_Home(Home_bean home_bean) {
        if (home_bean != null) {
            int status = home_bean.getStatus();
            if (status == 0) {
                List<Home_bean.DataBean.BannerBean> banner = home_bean.getData().getBanner();
                String image = banner.get(0).getImage();
                String image1 = banner.get(1).getImage();
                ArrayList<String> list = new ArrayList<>();
                list.add(image);
                list.add(image1);
                mBanner.setImages(list);
                mBanner.setImageLoader(new MyLoader());
                mBanner.setDelayTime(2000);
                mBanner.isAutoPlay(true);
                mBanner.start();
                List<Home_bean.DataBean.ActivityBean> activity = home_bean.getData().getActivity();
                Home_bean.DataBean.ActivityBean title = activity.get(0);
                String title2 = title.getTitle();
                String image2 = title.getImage();
                String remark = title.getRemark();
                String apply_time = title.getApply_time();

                Glide.with(getActivity()).load(image2).into(mIvTu);
                mTvTitl.setText(title2);
                mTvTit11.setText(remark);
                mTvTitl11.setText(apply_time);

                Home_bean.DataBean.ActivityBean titles = activity.get(1);
                String title2s = titles.getTitle();
                String image2s = titles.getImage();
                String remarks = titles.getRemark();
                String apply_times = titles.getApply_time();

                Glide.with(getActivity()).load(image2s).into(mIvTu1);
                mTvTitle3.setText(remarks);
                mTitle1.setText(title2s);
                mTvTitl11.setText(apply_times);
            } else {
                Log.i("Tab", String.valueOf(status));
                Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();
            }


        }
    }

    @Override
    public void getdata_Announce(Announce_bean announce_bean) {
        if (announce_bean != null) {
            int status = announce_bean.getStatus();
            if (status == 0) {
                List<Announce_bean.DataBean> data = announce_bean.getData();
                for (int i = 0; i < data.size(); i++) {
                    String title = announce_bean.getData().get(i).getTitle();
                    mTvTong.setText(title);
                }
            }
        }
    }

    @Override
    public void getdata_Commonality(Commonality_bean commonality_bean) {
        if (commonality_bean != null) {
            int status = commonality_bean.getStatus();
            if (status == 0) {
                Log.i("Tab", status + "");
                List<Commonality_bean.DataBean.RepairBean> repair = commonality_bean.getData().getRepair();
                for (int i = 0; i < repair.size(); i++) {
                    int id = repair.get(i).getId();
                    name = repair.get(i).getName();

                }
            }
        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }
}



