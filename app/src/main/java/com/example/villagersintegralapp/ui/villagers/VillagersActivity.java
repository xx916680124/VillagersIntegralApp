package com.example.villagersintegralapp.ui.villagers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.villagersintegralapp.R;

public class VillagersActivity extends AppCompatActivity {

    private TextView title;
    private CardView cv_query;
    private CardView cv_list;
    private CardView cv_apply;
    private CardView cv_shop;
    private Button btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        cv_query.setOnClickListener(v -> startActivity(new Intent(VillagersActivity.this, QueryActivity.class)));
        cv_apply.setOnClickListener(v -> startActivity(new Intent(VillagersActivity.this, ApplyActivity.class)));
        cv_list.setOnClickListener(v -> startActivity(new Intent(VillagersActivity.this, ListActivity.class)));
        cv_shop.setOnClickListener(v -> startActivity(new Intent(VillagersActivity.this, ShopActivity.class)));
        btn_exit.setOnClickListener(v -> finish());
    }

    private void initView() {
        title = findViewById(R.id.tv_title);
        cv_query = findViewById(R.id.cv_query);
        cv_apply = findViewById(R.id.cv_apply);
        cv_list = findViewById(R.id.cv_list);
        cv_shop = findViewById(R.id.cv_shop);
        btn_exit = findViewById(R.id.btn_exit);
    }
}