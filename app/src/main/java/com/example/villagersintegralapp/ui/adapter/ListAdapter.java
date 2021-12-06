package com.example.villagersintegralapp.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.villagersintegralapp.R;
import com.example.villagersintegralapp.entity.UserEntity;

import java.util.List;

public class ListAdapter extends BaseMultiItemQuickAdapter<UserEntity, BaseViewHolder> {
    public ListAdapter(@Nullable List<UserEntity> data) {
        super(data);
        addItemType(1, R.layout.item_villagerslist);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, UserEntity quickMultipleEntity) {
        if (quickMultipleEntity.getItemType()==baseViewHolder.getItemViewType()){
            int itemPosition = getItemPosition(quickMultipleEntity);
            baseViewHolder.setText(R.id.tv_number_list,itemPosition+"");
            baseViewHolder.setText(R.id.tv_name_list,quickMultipleEntity.getName());
            baseViewHolder.setText(R.id.tv_age_list,quickMultipleEntity.getAge()+"");
            baseViewHolder.setText(R.id.tv_sex_list,quickMultipleEntity.getSex());
            baseViewHolder.setText(R.id.tv_integral_list,quickMultipleEntity.getIntegral()+"");
        }
    }
}
