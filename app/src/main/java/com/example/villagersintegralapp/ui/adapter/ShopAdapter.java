package com.example.villagersintegralapp.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.villagersintegralapp.R;
import com.example.villagersintegralapp.entity.GoodsEntity;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder>{

    private Context context;
    private ArrayList<GoodsEntity> list;
    public ShopAdapter(Context content, ArrayList<GoodsEntity> list) {
        this.context=content;
        this.list=list;
    }
    onItemOnClickListener itemOnClickListener;

    public void setItemOnClickListener(onItemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_goods, parent, false);
        return new ShopViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.mtv.setText(list.get(position).getIntegral()+"积分兑换");
        Glide.with(context).load(list.get(position).getImg()).into(holder.miv);
        holder.mtv.setOnClickListener(v -> itemOnClickListener.onItmeClick(v, position));
//        .get(context).(list.get(position).getImg()).into(holder.miv);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ShopViewHolder extends RecyclerView.ViewHolder {
        public TextView mtv;
        public ImageView miv;
        public ShopViewHolder(@NonNull View itemView) {
            super(itemView);
            mtv = itemView.findViewById(R.id.tv_integral);
            miv=itemView.findViewById(R.id.iv_goods);

        }
    }
    public interface onItemOnClickListener{
        void onItmeClick(View v,int position);
    }
}
