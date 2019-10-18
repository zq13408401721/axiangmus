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
import com.goketech.smartcommunity.bean.MyHoure_bean;

import java.util.ArrayList;
import java.util.List;

public class Administrator_adaper extends RecyclerView.Adapter<Administrator_adaper.ViewHodler> {
    private ArrayList<MyHoure_bean.DataBean> nei;
    private Context context;
    private String phone;
    private String avatar;
    private String created_at;
    private int is_owner;
    private int is_call;
    private String nick;
    private int type;

    public Administrator_adaper(ArrayList<MyHoure_bean.DataBean> nei, Context context) {
        this.nei = nei;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.administrator_itme, null);
        ViewHodler viewHodler = new ViewHodler(inflate);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, final int i) {
        List<MyHoure_bean.DataBean.UsersBean> users = nei.get(i).getUsers();
        for (int j = 0; j < users.size(); j++) {
            phone = users.get(j).getPhone();
            avatar = users.get(j).getAvatar();
            created_at = users.get(j).getCreated_at();
            is_owner = users.get(j).getIs_owner();
            is_call = users.get(j).getIs_call();
            nick = (String) users.get(j).getNick();
            type = users.get(j).getType();
        }
        Glide.with(context).load(avatar).into(viewHodler.iv_tou);
        viewHodler.zhuhu.setText(nick);
        viewHodler.phone.setText(phone);
        if (type==1){
            viewHodler.fangzhu.setText("业主");
        }else if (type==2){
            viewHodler.fangzhu.setText("租户");
        }else if (type==3){
            viewHodler.fangzhu.setText("家属");
        }
        viewHodler.itme.setText(created_at);
        if (is_call==0){
            viewHodler.hu.setText("互播信息接收人");
        }else if (is_call==1){
            viewHodler.hu.setText("");
        }
        viewHodler.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                delete.delete(i);
                return true;
            }
        });




    }

    @Override
    public int getItemCount() {
        return nei.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private ImageView iv_tou;

        private TextView zhuhu;
        private TextView fangzhu;
        private TextView phone;
        private TextView itme;
        private TextView hu;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            hu=itemView.findViewById(R.id.hu);
            iv_tou=itemView.findViewById(R.id.iv_tou);
            zhuhu=itemView.findViewById(R.id.zhuhu);
            fangzhu=itemView.findViewById(R.id.fangzhu);
            phone=itemView.findViewById(R.id.phone);
            itme=itemView.findViewById(R.id.time);
        }
    }
    private Delete delete;

    public void setDelete(Delete delete) {
        this.delete = delete;
    }

    public interface Delete{
        void delete(int p);
    }
}
