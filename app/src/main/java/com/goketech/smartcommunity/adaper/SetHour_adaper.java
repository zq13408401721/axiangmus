package com.goketech.smartcommunity.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.bean.SetHour_bean;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SetHour_adaper extends RecyclerView.Adapter<SetHour_adaper.ViewHodler>{
    private ArrayList<SetHour_bean.DataBean> nei;
    private Context context;
    private String name1;
    private String room_number1;
    private int house_id;

    public SetHour_adaper(ArrayList<SetHour_bean.DataBean> nei, Context context) {
        this.nei = nei;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.sethour_itme, null);
        ViewHodler viewHodler = new ViewHodler(inflate);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, final int i) {
        final String bulid_name = nei.get(i).getBulid_name();
        List<SetHour_bean.DataBean.UnitListBean> unit_list = nei.get(i).getUnit_list();
        for (int j = 0; j < unit_list.size(); j++) {
            name1 = unit_list.get(j).getName();
            List<SetHour_bean.DataBean.UnitListBean.RoomListBean> room_list = unit_list.get(j).getRoom_list();
            for (int k = 0; k < room_list.size(); k++) {
                room_number1 = room_list.get(k).getRoom_number();
                house_id = room_list.get(k).getHouse_id();
            }
        }
        viewHodler.tv_list.setText(bulid_name+name1+room_number1);
        viewHodler.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addhour.AddHour(i,bulid_name,name1,room_number1,house_id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nei.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private TextView tv_list;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            tv_list=itemView.findViewById(R.id.tv_list);
        }
    }
    private AddHour addhour;

    public void setAddhour(AddHour addhour) {
        this.addhour = addhour;
    }

    public interface AddHour{
        void AddHour(int p, String bulid_name,String name1,String room_number1,int id);
    }
}
