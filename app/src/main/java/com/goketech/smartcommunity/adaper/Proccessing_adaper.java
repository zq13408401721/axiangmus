package com.goketech.smartcommunity.adaper;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class Proccessing_adaper extends RecyclerView.Adapter<Proccessing_adaper.ViewHodler>{
    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
        }
    }
}
