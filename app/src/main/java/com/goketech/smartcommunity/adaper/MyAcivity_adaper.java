package com.goketech.smartcommunity.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.bean.MyAcivity_bean;

import java.util.ArrayList;
import java.util.List;

public class MyAcivity_adaper extends RecyclerView.Adapter<MyAcivity_adaper.ViewHodler> {
    private ArrayList<MyAcivity_bean.DataBean> nei;
    private Context context;
    private String avatar;

    public MyAcivity_adaper(ArrayList<MyAcivity_bean.DataBean> nei, Context context) {
        this.nei = nei;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.myacivity_itme, null);
        ViewHodler viewHodler = new ViewHodler(inflate);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {
        String title = nei.get(i).getTitle();
        String image = nei.get(i).getImage();
        String remark = nei.get(i).getRemark();
        String end_time = nei.get(i).getEnd_time();
        String apply_num = (String) nei.get(i).getApply_num();
        List<MyAcivity_bean.DataBean.UsersBean> users = nei.get(i).getUsers();
        for (int j = 0; j < users.size(); j++) {
            avatar = users.get(j).getAvatar();

        }
        Glide.with(context).load(image).into(viewHodler.iv_tu);
        viewHodler.tv_titl.setText(title);
        viewHodler.tv_titl1.setText(remark);
        viewHodler.tv_titl2.setText(end_time);
        Glide.with(context).load(avatar).into(viewHodler.tou);
        Glide.with(context).load(avatar).into(viewHodler.tou1);
        Glide.with(context).load(avatar).into(viewHodler.tou2);
        viewHodler.renshu.setText(apply_num);

    }

    @Override
    public int getItemCount() {
        return nei.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private ImageView iv_tu;//tu
        private TextView tv_titl;//标题
        private TextView tv_titl1;
        private TextView tv_titl2;
        private ImageView tou;
        private ImageView tou1;
        private ImageView tou2;
        private TextView renshu;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            iv_tu=itemView.findViewById(R.id.iv_tu);
            tv_titl=itemView.findViewById(R.id.tv_titl);
            tv_titl1=itemView.findViewById(R.id.tv_titl1);
            tv_titl2=itemView.findViewById(R.id.tv_titl2);
            tou=itemView.findViewById(R.id.tou);
            tou1=itemView.findViewById(R.id.tou1);
            tou2=itemView.findViewById(R.id.tou2);
            renshu=itemView.findViewById(R.id.renshu);
        }
    }
}
