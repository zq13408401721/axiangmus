package com.goketech.smartcommunity.presenter.acivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.adaper.SetHour_adaper;
import com.goketech.smartcommunity.adaper.Setelementt_adaper;
import com.goketech.smartcommunity.adaper.Setroom_adaper;
import com.goketech.smartcommunity.base.BaseActivity;
import com.goketech.smartcommunity.bean.Binding_bean;
import com.goketech.smartcommunity.bean.SetHour_bean;
import com.goketech.smartcommunity.interfaces.contract.Binding_Contracy;
import com.goketech.smartcommunity.presenter.Banding_Presenter;
import com.goketech.smartcommunity.utils.ASCIIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class Hour_Binding_acivity extends BaseActivity<Binding_Contracy.View, Binding_Contracy.Presenter> implements Binding_Contracy.View {


    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.fang)
    TextView fang;
    @BindView(R.id.tl)
    Toolbar tl;
    @BindView(R.id.tv_xiugai)
    TextView tvXiugai;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.xian)
    TextView xian;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.xian1)
    TextView xian1;
    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.louyu)
    TextView louyu;
    @BindView(R.id.bt_tijiao)
    Button btTijiao;
    @BindView(R.id.xian5)
    TextView xian5;
    @BindView(R.id.xian2)
    TextView xian2;
    @BindView(R.id.danyuan)
    TextView danyuan;
    @BindView(R.id.xian3)
    TextView xian3;
    @BindView(R.id.fangjian)
    TextView fangjian;
    private ArrayList<SetHour_bean.DataBean> dataBeans;
    private SetHour_adaper setHour_adaper;
    private RecyclerView rl_list;
    private LinearLayoutManager linearLayoutManager;
    private List<SetHour_bean.DataBean> data;
    private String ids;

    @Override
    protected Binding_Contracy.Presenter getPresenter() {
        return new Banding_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hour__binding_acivity;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {

        louyu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //1.new 对象
                //2.指定三要素
                //3.显示
                final PopupWindow popupWindow = new PopupWindow();
                //必须给定三要素: 视图(view),宽,高
                //view
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 0.7f;
                getWindow().setAttributes(lp);

                View inflate = LayoutInflater.from(Hour_Binding_acivity.this).inflate(R.layout.popupwindow, null, false);
                popupWindow.setContentView(inflate);
                //宽
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                //高
                popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

                View inflate1 = LayoutInflater.from(Hour_Binding_acivity.this).inflate(R.layout.fragment_home_, null, false);
                popupWindow.showAtLocation(inflate1, Gravity.CENTER, 0, 0);
                ImageView pop_img = inflate.findViewById(R.id.pop_img);
                pop_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        WindowManager.LayoutParams lp = getWindow().getAttributes();
                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);
                    }
                });
                rl_list = inflate.findViewById(R.id.rl_list);
                dataBeans = new ArrayList<>();
                setHour_adaper = new SetHour_adaper(dataBeans, Hour_Binding_acivity.this);
                rl_list.setAdapter(setHour_adaper);
                linearLayoutManager = new LinearLayoutManager(Hour_Binding_acivity.this);
                rl_list.setLayoutManager(linearLayoutManager);
                dataBeans.addAll(data);
                setHour_adaper.notifyDataSetChanged();
                setHour_adaper.setAddhour(new SetHour_adaper.AddHour() {
                    @Override
                    public void AddHour(int p, String bulid_name, String name1, String room_number1, int id) {
                        ids = id + "";
                        louyu.setText(bulid_name);
                        popupWindow.dismiss();
                        WindowManager.LayoutParams lp = getWindow().getAttributes();
                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);
                    }
                });

            }
        });
        danyuan.setOnClickListener(new View.OnClickListener() {

            private Setelementt_adaper setelementt_adaper;

            @Override
            public void onClick(View v) {
                //1.new 对象
                //2.指定三要素
                //3.显示
                final PopupWindow popupWindow = new PopupWindow();
                //必须给定三要素: 视图(view),宽,高
                //view
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 0.7f;
                getWindow().setAttributes(lp);

                View inflate = LayoutInflater.from(Hour_Binding_acivity.this).inflate(R.layout.popupwindow, null, false);
                popupWindow.setContentView(inflate);
                //宽
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                //高
                popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

                View inflate1 = LayoutInflater.from(Hour_Binding_acivity.this).inflate(R.layout.fragment_home_, null, false);
                popupWindow.showAtLocation(inflate1, Gravity.CENTER, 0, 0);
                ImageView pop_img = inflate.findViewById(R.id.pop_img);
                pop_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        WindowManager.LayoutParams lp = getWindow().getAttributes();
                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);
                    }
                });
                rl_list = inflate.findViewById(R.id.rl_list);
                dataBeans = new ArrayList<>();
                setelementt_adaper = new Setelementt_adaper(dataBeans,Hour_Binding_acivity.this);
                rl_list.setAdapter(setelementt_adaper);
                linearLayoutManager = new LinearLayoutManager(Hour_Binding_acivity.this);
                rl_list.setLayoutManager(linearLayoutManager);
                dataBeans.addAll(data);
                setelementt_adaper.notifyDataSetChanged();
                setelementt_adaper.setSetelement(new Setelementt_adaper.Setelement() {
                    @Override
                    public void Setelement(int p, String bulid_name, String name1, String room_number1, int id) {
                        ids = id + "";
                        danyuan.setText(name1+"");
                        Log.i("name",name1);
                        popupWindow.dismiss();
                        WindowManager.LayoutParams lp = getWindow().getAttributes();
                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);
                    }
                });
            }
        });
        fangjian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.new 对象
                //2.指定三要素
                //3.显示
                final PopupWindow popupWindow = new PopupWindow();
                //必须给定三要素: 视图(view),宽,高
                //view
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 0.7f;
                getWindow().setAttributes(lp);

                View inflate = LayoutInflater.from(Hour_Binding_acivity.this).inflate(R.layout.popupwindow, null, false);
                popupWindow.setContentView(inflate);
                //宽
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                //高
                popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

                View inflate1 = LayoutInflater.from(Hour_Binding_acivity.this).inflate(R.layout.fragment_home_, null, false);
                popupWindow.showAtLocation(inflate1, Gravity.CENTER, 0, 0);
                ImageView pop_img = inflate.findViewById(R.id.pop_img);
                pop_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        WindowManager.LayoutParams lp = getWindow().getAttributes();
                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);
                    }
                });
                rl_list = inflate.findViewById(R.id.rl_list);
                dataBeans = new ArrayList<>();
                Setroom_adaper setroom_adaper = new Setroom_adaper(dataBeans, Hour_Binding_acivity.this);
                rl_list.setAdapter(setroom_adaper);
                linearLayoutManager = new LinearLayoutManager(Hour_Binding_acivity.this);
                rl_list.setLayoutManager(linearLayoutManager);
                dataBeans.addAll(data);
                setroom_adaper.notifyDataSetChanged();
                setroom_adaper.setSetroom(new Setroom_adaper.Setroom() {
                    @Override
                    public void Setroom(int p, String bulid_name, String name1, String room_number1, int id) {
                        ids = id + "";
                        fangjian.setText(room_number1);
                        popupWindow.dismiss();
                        WindowManager.LayoutParams lp = getWindow().getAttributes();
                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);
                    }
                });
            }
        });
        danyuan.setOnClickListener(new View.OnClickListener() {

            private Setelementt_adaper setelementt_adaper;

            @Override
            public void onClick(View v) {
                //1.new 对象
                //2.指定三要素
                //3.显示
                final PopupWindow popupWindow = new PopupWindow();
                //必须给定三要素: 视图(view),宽,高
                //view
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 0.7f;
                getWindow().setAttributes(lp);

                View inflate = LayoutInflater.from(Hour_Binding_acivity.this).inflate(R.layout.popupwindow, null, false);
                popupWindow.setContentView(inflate);
                //宽
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                //高
                popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

                View inflate1 = LayoutInflater.from(Hour_Binding_acivity.this).inflate(R.layout.fragment_home_, null, false);
                popupWindow.showAtLocation(inflate1, Gravity.CENTER, 0, 0);
                ImageView pop_img = inflate.findViewById(R.id.pop_img);
                pop_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        WindowManager.LayoutParams lp = getWindow().getAttributes();
                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);
                    }
                });
                rl_list = inflate.findViewById(R.id.rl_list);
                dataBeans = new ArrayList<>();
                setelementt_adaper = new Setelementt_adaper(dataBeans,Hour_Binding_acivity.this);
                rl_list.setAdapter(setelementt_adaper);
                linearLayoutManager = new LinearLayoutManager(Hour_Binding_acivity.this);
                rl_list.setLayoutManager(linearLayoutManager);
                dataBeans.addAll(data);
                setelementt_adaper.notifyDataSetChanged();
                setelementt_adaper.setSetelement(new Setelementt_adaper.Setelement() {
                    @Override
                    public void Setelement(int p, String bulid_name, String name1, String room_number1, int id) {
                        ids = id + "";
                        danyuan.setText(name1);
                        popupWindow.dismiss();
                        WindowManager.LayoutParams lp = getWindow().getAttributes();
                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);
                    }
                });
            }
        });
        Map<String, String> map = new HashMap<>();
        map.put("community_id", "1");


        String sign = ASCIIUtils.getSign(map);

        RequestBody requestBody = new FormBody.Builder()
                .add("community_id", "1")
                .add("sign", sign)
                .build();
        mPresenter.getData_SetHour(requestBody);
    }

    @Override
    protected void initListener() {
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

      /*  select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items3 = new String[]{"住户", "业主"};//创建item
                AlertDialog dialog = new AlertDialog.Builder(Hour_Binding_acivity.this)
                        .setTitle("您的身份是")
                        .setItems(items3, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                    select.setText(items3[which]);
                            }
                        }).create();
                    dialog.show();
            }
        });*/
        select.setText("住户");
        btTijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wu = select.getText().toString();
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                if (wu.equals("住户")) {
                    wu = "0";
                }
                Map<String, String> map = new HashMap<>();

                map.put("phone", phone + "");
                map.put("real_name", name);
                map.put("house_id", ids + "");
                map.put("is_owner", wu + "");
                map.put("community_id", "1");
                Log.i("sign",phone+""+name+ids+""+wu+"");
                String sign = ASCIIUtils.getSign(map);

                RequestBody requestBody = new FormBody.Builder()
                        .add("phone", phone)
                        .add("real_name", name)
                        .add("house_id", ids)
                        .add("is_owner", wu)
                        .add("community_id", "1")
                        .add("sign", sign)
                        .build();
                mPresenter.getData_Binding(requestBody);
            }
        });

    }

    @Override
    public void getdata_Binding(Binding_bean binding_bean) {
        if (binding_bean != null) {
            int status = binding_bean.getStatus();
            if (status == 0) {
                Toast.makeText(Hour_Binding_acivity.this, "绑定成功", Toast.LENGTH_SHORT).show();
            } else if (status == 1100) {
                Toast.makeText(Hour_Binding_acivity.this, "房屋不存在", Toast.LENGTH_SHORT).show();
            } else if (status == 1101) {
                Toast.makeText(Hour_Binding_acivity.this, "已存在业主，请检查重新绑定", Toast.LENGTH_SHORT).show();
            } else if (status == 1102) {
                Toast.makeText(Hour_Binding_acivity.this, "手机号与房屋不匹配", Toast.LENGTH_SHORT).show();
            } else if (status == 1103) {
                Toast.makeText(Hour_Binding_acivity.this, "真实姓名与房屋不匹配", Toast.LENGTH_SHORT).show();
            } else if (status == 1104) {
                Toast.makeText(Hour_Binding_acivity.this, "您已经绑定过该房屋", Toast.LENGTH_SHORT).show();
            } else {
                Log.e("Tab", status + "");
            }
        }
    }

    @Override
    public void getdata_SetHour(SetHour_bean setHour) {
        if (setHour != null) {
            int status = setHour.getStatus();
            if (status == 0) {
                data = setHour.getData();

            }
        }
    }

    @Override
    public void showError(String errorMsg) {

    }
}
