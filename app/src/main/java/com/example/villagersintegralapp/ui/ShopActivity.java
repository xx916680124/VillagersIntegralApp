package com.example.villagersintegralapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.villagersintegralapp.R;

public class ShopActivity extends AppCompatActivity {

    private Button btn_back;
    private RecyclerView rv_shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        initView();
        initListener();
        initData();
    }

    private void initData() {

    }

    private void initListener() {
        btn_back.setOnClickListener(v -> finish());
    }

    private void initView() {
        btn_back = findViewById(R.id.btn_back);
        rv_shop = findViewById(R.id.rv_shop);
    }
}