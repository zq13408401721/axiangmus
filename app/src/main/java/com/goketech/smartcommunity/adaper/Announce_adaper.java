package com.goketech.smartcommunity.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.bean.Announcement_bean;


import java.util.ArrayList;

public class Announce_adaper extends RecyclerView.Adapter<Announce_adaper.ViewHodler> {
    private ArrayList<Announcement_bean.DataBean> nei;
    private Context context;

    public Announce_adaper(ArrayList<Announcement_bean.DataBean> nei, Context context) {
        this.nei = nei;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.announment_itme, null);
        ViewHodler viewHodler = new ViewHodler(inflate);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHodler viewHodler, final int i) {
        viewHodler.tv_zhang.setText(nei.get(i).getTitle());
        int status = nei.get(i).getStatus();
        if (status==0){
            viewHodler.tv_jieqing.setText("待支付");
        }else if (status==1){
            viewHodler.tv_jieqing.setText("未支付");
        }else if (status==2){
            viewHodler.tv_jieqing.setText("已支付");
        }
        viewHodler.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setfei.Setfei(viewHodler.RL_dianji,i,viewHodler.tv_jieqing);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nei.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private TextView tv_zhang;
        private TextView tv_jieqing;
        private RecyclerView RL_dianji;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            tv_zhang=itemView.findViewById(R.id.zhang);
            tv_jieqing=itemView.findViewById(R.id.jie);
            RL_dianji=itemView.findViewById(R.id.rl_dianji);
        }
    }
    private Setfei setfei;

    public void setSetfei(Setfei setfei) {
        this.setfei = setfei;
    }

    public interface Setfei{
        void Setfei(RecyclerView RL_dianji, int p, TextView tv_ji);
    }
}
