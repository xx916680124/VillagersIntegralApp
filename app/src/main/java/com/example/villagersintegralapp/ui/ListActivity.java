package com.example.villagersintegralapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.villagersintegralapp.R;

import org.json.JSONObject;

public class ListActivity extends AppCompatActivity {

    private Button btn_back;
    private RecyclerView rv_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
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
        rv_list = findViewById(R.id.rv_list);

    }
}