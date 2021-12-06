package com.example.villagersintegralapp.ui.villag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.villagersintegralapp.R;
import com.example.villagersintegralapp.ui.villagers.ApplyActivity;
import com.example.villagersintegralapp.ui.villagers.ListActivity;
import com.example.villagersintegralapp.ui.villagers.QueryActivity;
import com.example.villagersintegralapp.ui.villagers.ShopActivity;

public class VillageCommitteeActivity extends AppCompatActivity {

    private TextView title,tv_query,tv_apply,tv_list,tv_shop;
    private CardView cv_query,cv_list,cv_apply,cv_shop;

    private Button btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        cv_query.setOnClickListener(v -> startActivity(new Intent(VillageCommitteeActivity.this, VListActivity.class)));
        cv_apply.setOnClickListener(v -> startActivity(new Intent(VillageCommitteeActivity.this, AuditActivity.class)));
        cv_list.setOnClickListener(v -> startActivity(new Intent(VillageCommitteeActivity.this, ListActivity.class)));
        cv_shop.setOnClickListener(v -> startActivity(new Intent(VillageCommitteeActivity.this, ShopActivity.class)));
        btn_exit.setOnClickListener(v -> finish());
    }

    private void initView() {
        title = findViewById(R.id.tv_title);
        cv_query = findViewById(R.id.cv_query);
        cv_apply = findViewById(R.id.cv_apply);
        cv_list = findViewById(R.id.cv_list);
        cv_shop = findViewById(R.id.cv_shop);
        tv_query = findViewById(R.id.tv_query);
        tv_apply = findViewById(R.id.tv_apply);
        tv_list = findViewById(R.id.tv_list);
        tv_shop = findViewById(R.id.tv_shop);
        btn_exit = findViewById(R.id.btn_exit);

        tv_query.setText("村民名单");
        tv_apply.setText("审核积分材料");

    }

}