package com.goketech.smartcommunity.adaper;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.bean.Acivity_bean;
import com.goketech.smartcommunity.presenter.acivity.Acivity_WebView_acivity;

import java.util.List;

public class Acivity_adaper extends RecyclerView.Adapter<Acivity_adaper.ViewHodler> {
    private List<Acivity_bean.DataBean> AcivityNei;
    private Context context;

    public Acivity_adaper(List<Acivity_bean.DataBean> acivityNei, Context context) {
        AcivityNei = acivityNei;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.acivity_itme, null);
        ViewHodler viewHodler = new ViewHodler(inflate);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHodler viewHodler, final int i) {
        final Acivity_bean.DataBean dataBean = AcivityNei.get(i);
        Glide.with(context).load(dataBean.getImage()).into(viewHodler.iv_tu);
        viewHodler.tv_title.setText(dataBean.getTitle());
        viewHodler.tv_titles.setText(dataBean.getContent());
        viewHodler.tv_titless.setText(dataBean.getApply_time());
        viewHodler.renshu.setText(dataBean.getTotal_apply()+"参与");
        Glide.with(context).load(dataBean.getUsers().get(i).getAvatar()).into(viewHodler.iv_ren1);
        Glide.with(context).load(dataBean.getUsers().get(i).getAvatar()).into(viewHodler.iv_ren2);
        Glide.with(context).load(dataBean.getUsers().get(i).getAvatar()).into(viewHodler.iv_ren3);
        viewHodler.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRenqi.SetRenqi(viewHodler.iv_tu,i,dataBean.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return AcivityNei.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private ImageView iv_tu;
        private TextView tv_title;
        private TextView tv_titles;
        private TextView tv_titless;
        private ImageView iv_ren1;
        private ImageView iv_ren2;
        private ImageView iv_ren3;
        private TextView renshu;


        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            tv_title=itemView.findViewById(R.id.tv_titl);
            tv_titles=itemView.findViewById(R.id.tv_titl1);
            tv_titless=itemView.findViewById(R.id.tv_titl2);
            renshu=itemView.findViewById(R.id.renshu);
            iv_tu=itemView.findViewById(R.id.iv_tu);
            iv_ren1=itemView.findViewById(R.id.tou);
            iv_ren2=itemView.findViewById(R.id.tou1);
            iv_ren3=itemView.findViewById(R.id.tou2);


        }
    }
    private SetRenqi setRenqi;

    public void setSetRenqi(SetRenqi setRenqi) {
        this.setRenqi = setRenqi;
    }

    public interface SetRenqi{
        void SetRenqi(ImageView iv,int p,int id);
    }
}
