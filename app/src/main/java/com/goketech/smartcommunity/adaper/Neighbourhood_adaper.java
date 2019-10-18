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
import com.goketech.smartcommunity.bean.Neighbourhood_bean;

import java.util.ArrayList;

public class Neighbourhood_adaper extends RecyclerView.Adapter<Neighbourhood_adaper.ViewHodler> {
    private ArrayList<Neighbourhood_bean.DataBean> nei;
    private Context context;

    public Neighbourhood_adaper(ArrayList<Neighbourhood_bean.DataBean> nei, Context context) {
        this.nei = nei;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.neighborhood, null);
        ViewHodler viewHodler = new ViewHodler(inflate);

        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {
        viewHodler.tv_name.setText(nei.get(i).getNick()+"");
        viewHodler.tv_Content.setText(nei.get(i).getAddress());
        viewHodler.tv_building.setText("内容");
        Glide.with(context).load(nei.get(i).getAvatar()).into(viewHodler.iv);
    }

    @Override
    public int getItemCount() {
        return nei.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv_name;
        private TextView tv_building;
        private TextView tv_Content;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv_tu);
            tv_name=itemView.findViewById(R.id.tv_name);
            tv_building=itemView.findViewById(R.id.building);
            tv_Content=itemView.findViewById(R.id.content);
        }
    }
}
