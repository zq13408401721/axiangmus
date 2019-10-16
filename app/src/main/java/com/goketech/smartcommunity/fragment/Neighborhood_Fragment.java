package com.goketech.smartcommunity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;


import com.goketech.smartcommunity.R;
import com.goketech.smartcommunity.adaper.NeighborhoodRec_Adapter;
import com.goketech.smartcommunity.base.BaseFragment;
import com.goketech.smartcommunity.fragment.neighbor.ContactsActivity;
import com.goketech.smartcommunity.interfaces.IBasePresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Neighborhood_Fragment extends BaseFragment implements PopupWindow.OnDismissListener,
        CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.neighbor_rec)
    RecyclerView neighborRec;
    Unbinder unbinder;
    @BindView(R.id.address_secrecy)
    CheckBox addressSecrecy;
    @BindView(R.id.address_more)
    ImageView addressMore;
    Unbinder unbinder1;
    @BindView(R.id.neighbor_relativelayout)
    RelativeLayout neighborRelativelayout;

    private PopupWindow popupWindow;
    private WindowManager.LayoutParams lp;


    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_neighborhood_;
    }

    @Override
    protected void initView() {
        super.initView();
        neighborRec.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            strings.add("asd");
        }
        NeighborhoodRec_Adapter neighborhoodRec_adapter = new NeighborhoodRec_Adapter(strings);
        neighborRec.setAdapter(neighborhoodRec_adapter);
        //创建popwindow
        View layout_address_pop =
                LayoutInflater.from(getContext()).inflate(R.layout.layout_address_pop, null);
        popupWindow = new PopupWindow(layout_address_pop, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置PopupWindow是否能响应外部点击事件
        popupWindow.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        popupWindow.setTouchable(true);
        lp = getActivity().getWindow().getAttributes();
        popupWindow.setOnDismissListener(this);
        addressSecrecy.setOnCheckedChangeListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }

    @OnClick({R.id.address_secrecy, R.id.address_more, R.id.neighbor_ll})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.neighbor_ll:
                Intent intent = new Intent(getContext(), ContactsActivity.class);
                startActivity(intent);


                break;

            case R.id.address_more:

                popupWindow.showAsDropDown(addressMore, -330, 0);
                if (popupWindow.isShowing()) {
                    lp.alpha = 0.7f;

                    getActivity().getWindow().setAttributes(lp);
                }
                break;
        }
    }

    @Override
    public void onDismiss() {
        lp.alpha = 1f;
        getActivity().getWindow().setAttributes(lp);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {

            neighborRelativelayout.setAlpha(0.3f);

        } else {
            neighborRelativelayout.setAlpha(1f);

        }
    }
}
