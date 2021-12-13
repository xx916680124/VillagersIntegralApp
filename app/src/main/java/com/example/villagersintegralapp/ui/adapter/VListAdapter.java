package com.example.villagersintegralapp.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.villagersintegralapp.R;
import com.example.villagersintegralapp.entity.UserEntity;
import com.example.villagersintegralapp.sql.VillagersEntity;

import java.util.List;

public class VListAdapter extends BaseQuickAdapter<VillagersEntity, BaseViewHolder> {
    public VListAdapter(@Nullable List<UserEntity> data) {
        super(R.layout.item_vclist);

    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, VillagersEntity userEntity) {
            int itemPosition = getItemPosition(userEntity);
            baseViewHolder.setText(R.id.tv_number_vc,itemPosition+"");
            baseViewHolder.setText(R.id.tv_name_vc,userEntity.getName());
            baseViewHolder.setText(R.id.tv_age_vc,userEntity.getAge()+"");
            baseViewHolder.setText(R.id.tv_sex_vc,userEntity.getSex());
            baseViewHolder.setText(R.id.tv_adress_vc,userEntity.getAdress());
            baseViewHolder.setText(R.id.tv_integral_vc,userEntity.getIntegral()+"");
    }
}
