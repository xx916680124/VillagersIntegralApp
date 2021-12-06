package com.example.villagersintegralapp.ui.villagers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.villagersintegralapp.R;
import com.example.villagersintegralapp.entity.UserEntity;
import com.example.villagersintegralapp.ui.adapter.ListAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private Button btn_back;
    private RecyclerView rv_list;
    private ArrayList<UserEntity> villagersEntities;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initView();
        initListener();
        initData();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void initData() {
       /* for (int i = 0; i < 10; i++) {
            villagersEntities.add(new VillagersEntity("张"+i,13+i,"男",456+i));
        }*/
        listAdapter.notifyDataSetChanged();
        if (listAdapter.getItemCount()==0){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.ic_launcher_background);
            listAdapter.setEmptyView(imageView);
        }
    }

    private void initListener() {
        btn_back.setOnClickListener(v -> finish());
    }

    private void initView() {
        btn_back = findViewById(R.id.btn_back);
        rv_list = findViewById(R.id.rv_list);
        villagersEntities = new ArrayList<>();
        listAdapter = new ListAdapter(villagersEntities);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.setAdapter(listAdapter);
    }
}