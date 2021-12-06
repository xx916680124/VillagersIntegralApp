package com.example.villagersintegralapp.ui.villagers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.villagersintegralapp.R;
import com.example.villagersintegralapp.entity.GoodsEntity;
import com.example.villagersintegralapp.ui.adapter.ShopAdapter;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {

    private Button btn_back;
    private RecyclerView rv_shop;
    private ArrayList<GoodsEntity> list;
    private ShopAdapter shopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        initView();
        initListener();
        initData();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void initData() {
        for (int i = 0; i < 10; i++) {
            list.add(new GoodsEntity("https://c-ssl.duitang.com/uploads/item/201812/05/20181205205729_yzAx5.jpeg",32+i));
        }
        shopAdapter.notifyDataSetChanged();
    }

    private void initListener() {
        btn_back.setOnClickListener(v -> finish());
        shopAdapter.setItemOnClickListener((v, position) -> {
            Toast.makeText(this, ""+((TextView)v).getText(), Toast.LENGTH_SHORT).show();
        });
    }

    private void initView() {
        btn_back = findViewById(R.id.btn_back);
        rv_shop = findViewById(R.id.rv_shop);
        rv_shop.setLayoutManager(new GridLayoutManager(this,2));

        list = new ArrayList<>();
        shopAdapter = new ShopAdapter(this, list);
        rv_shop.setAdapter(shopAdapter);
    }
}