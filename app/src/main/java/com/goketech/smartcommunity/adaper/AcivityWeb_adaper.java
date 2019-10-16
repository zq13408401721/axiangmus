package com.goketech.smartcommunity.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.bean.Acivity_Web_bean;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AcivityWeb_adaper extends RecyclerView.Adapter<AcivityWeb_adaper.ViewHodler> {
    private ArrayList<Acivity_Web_bean.DataBean> AcivityWeb;
    private Context context;

    public AcivityWeb_adaper(ArrayList<Acivity_Web_bean.DataBean> acivityWeb, Context context) {
        AcivityWeb = acivityWeb;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.acivityweb_itme, null);
        ViewHodler viewHodler = new ViewHodler(inflate);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {
        Acivity_Web_bean.DataBean dataBean = AcivityWeb.get(i);
        Glide.with(context).load(dataBean.getImage()).into(viewHodler.iv);
        viewHodler.textView.setText(dataBean.getTitle());
        for (int j = 0; j < AcivityWeb.size(); j++) {
            String avatar = AcivityWeb.get(j).getAvatar();
            Glide.with(context).load(avatar).into(viewHodler.iv_biao);
        }
        viewHodler.tv_faqi.setText(dataBean.getNick()+"");
        viewHodler.tv_establish.setText(dataBean.getBegin_time());
        viewHodler.remark.setText(dataBean.getRemark());
        Glide.with(context).load(dataBean.getImage()).into(viewHodler.iv_tu);
        viewHodler.content.setText(dataBean.getContent());
        viewHodler.time.setText(dataBean.getBegin_time()+dataBean.getEnd_time());
        viewHodler.upto.setText(dataBean.getApply_time());
        viewHodler.site.setText(dataBean.getAddress());
        viewHodler.number.setText(dataBean.getApply_num()+"");
        viewHodler.cost.setText(dataBean.getPrice()+"");
        viewHodler.linkman.setText(dataBean.getContact()+"");
        viewHodler.linkmanPhone.setText(dataBean.getContact_phone()+"");
        List<Acivity_Web_bean.DataBean.UsersBean> users = dataBean.getUsers();
        for (int j = 0; j < users.size(); j++) {
            String avatar = users.get(j).getAvatar();
            Glide.with(context).load(avatar).into(viewHodler.tu);
            Glide.with(context).load(avatar).into(viewHodler.tu1);
            Glide.with(context).load(avatar).into(viewHodler.tu2);
            Glide.with(context).load(avatar).into(viewHodler.tu3);
        }
        viewHodler.num.setText(dataBean.getTotal_apply()+"");
    }

    @Override
    public int getItemCount() {
        return AcivityWeb.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView textView;
        private ImageView iv_biao;
        private TextView tv_faqi;
        private TextView tv_establish;
        private TextView remark;
        private ImageView iv_tu;
        private TextView content;
        private TextView time;
        private TextView upto;
        private TextView site;
        private TextView number;
        private TextView cost;
        private TextView linkman;
        private TextView linkmanPhone;
        private ImageView tu;
        private ImageView tu1;
        private ImageView tu2;
        private ImageView tu3;
        private TextView num;

        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv_tuWeb);
            textView=itemView.findViewById(R.id.title_shidai);
            iv_biao=itemView.findViewById(R.id.iv_biao);
            tv_faqi=itemView.findViewById(R.id.faqi);
            tv_establish=itemView.findViewById(R.id.tv_establish);
            remark=itemView.findViewById(R.id.remark);
            iv_tu=itemView.findViewById(R.id.iv_tu);
            content=itemView.findViewById(R.id.content);
            time=itemView.findViewById(R.id.time);
            upto=itemView.findViewById(R.id.upto);
            site=itemView.findViewById(R.id.site);
            number=itemView.findViewById(R.id.number);
            cost=itemView.findViewById(R.id.cost);
            linkman=itemView.findViewById(R.id.linkman);
            linkmanPhone=itemView.findViewById(R.id.linkmanPhone);
            tu=itemView.findViewById(R.id.tu1);
            tu1=itemView.findViewById(R.id.tu2);
            tu2=itemView.findViewById(R.id.tu3);
            tu3=itemView.findViewById(R.id.tu4);
            num=itemView.findViewById(R.id.num);

        }

    }
}
