package com.goketech.smartcommunity.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.bean.All_bean;

import java.util.ArrayList;

public class All_adaper extends RecyclerView.Adapter<All_adaper.ViewHodler>{
    private ArrayList<All_bean.DataBean> nei;
    private Context context;

    public All_adaper(ArrayList<All_bean.DataBean> nei, Context context) {
        this.nei = nei;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.ongoing_itme, null);
        ViewHodler viewHodler = new ViewHodler(inflate);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHodler viewHodler, final int i) {
        String address = nei.get(i).getAddress();
        int order_type = nei.get(i).getOrder_type();
        String remark = nei.get(i).getRemark();
        String date = nei.get(i).getDate();
        final String assigned_phone = nei.get(i).getAssigned_phone();
        viewHodler.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.All(i,assigned_phone,viewHodler.phone);
            }
        });
        viewHodler.tv_xian.setText(remark);
        if (order_type==0){
            viewHodler.tv_chu.setText("全部");
        }
        viewHodler.dizhi.setText(address);
        viewHodler.itme.setText(date);

    }

    @Override
    public int getItemCount() {
        return nei.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private TextView tv_xian;
        private TextView tv_chu;
        private TextView itme;
        private TextView dizhi;
        private TextView phone;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            tv_xian=itme.findViewById(R.id.deng);
            tv_chu=itme.findViewById(R.id.chuli);
            itme=itemView.findViewById(R.id.time);
            dizhi=itme.findViewById(R.id.dizhi);
            phone=itme.findViewById(R.id.phone);
        }
    }
    private All all;

    public void setAll(All all) {
        this.all = all;
    }

    public interface All{
        void All(int p, String phone, TextView tv);
    }
}
