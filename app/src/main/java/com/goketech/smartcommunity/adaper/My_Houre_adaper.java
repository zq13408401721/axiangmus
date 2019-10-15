package com.goketech.smartcommunity.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.bean.MyHoure_bean;

import java.util.ArrayList;

public class My_Houre_adaper extends RecyclerView.Adapter<My_Houre_adaper.ViewHodler> {
    private ArrayList<MyHoure_bean.DataBean> nei;
    private Context context;

    public My_Houre_adaper(ArrayList<MyHoure_bean.DataBean> nei, Context context) {
        this.nei = nei;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.myhoure_itme, null);
        ViewHodler viewHodler = new ViewHodler(inflate);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {
        String community = nei.get(i).getCommunity();
        String bulid = nei.get(i).getBulid();
        String unit = nei.get(i).getUnit();
        String floor = nei.get(i).getFloor();
        String room = nei.get(i).getRoom();
        viewHodler.fang.setText(community);
        viewHodler.ren.setText("人");
        viewHodler.dan.setText(bulid+unit+floor+room);
    }

    @Override
    public int getItemCount() {
        return nei.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private TextView fang;
        private TextView dan;
        private TextView ren;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            fang=itemView.findViewById(R.id.district);
            dan=itemView.findViewById(R.id.dan);
            ren=itemView.findViewById(R.id.ren);
        }
    }
}
