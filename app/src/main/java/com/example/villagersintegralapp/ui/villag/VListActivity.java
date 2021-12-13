package com.example.villagersintegralapp.ui.villag;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.example.villagersintegralapp.R;
import com.example.villagersintegralapp.entity.UserEntity;
import com.example.villagersintegralapp.sql.DbControl;
import com.example.villagersintegralapp.sql.VillagersEntity;
import com.example.villagersintegralapp.ui.adapter.ListAdapter;
import com.example.villagersintegralapp.ui.adapter.VListAdapter;
import com.example.villagersintegralapp.ui.popu.AddPopu;
import com.example.villagersintegralapp.ui.popu.FindPopu;
import com.example.villagersintegralapp.ui.popu.LongPopu;
import com.lxj.xpopup.XPopup;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.R)
public class VListActivity extends AppCompatActivity {
    private Button btn_back,btn_find,btn_add;
    private RecyclerView rv_list;
    private ArrayList<UserEntity> villagersEntities;
    private VListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlist);
        initView();
        initListener();
        initData();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void initData() {
        List<VillagersEntity> list = DbControl.getInstance(this).searchAll();
        listAdapter.addData(list);
        if (listAdapter.getItemCount()==0){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.ic_launcher_background);
            listAdapter.setEmptyView(imageView);
        }
    }

    private void initListener() {


        btn_back.setOnClickListener(v -> finish());
        btn_add.setOnClickListener(v -> {
            new XPopup.Builder(this)
                    .autoFocusEditText(false)
                    .asCustom(new AddPopu(this))
                    .show();
        });
        btn_find.setOnClickListener(v -> {
            new XPopup.Builder(this)
                    .autoFocusEditText(false)
                    .asCustom(new FindPopu(this))
                    .show();
        });
        listAdapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                List<VillagersEntity> data = listAdapter.getData();
                VillagersEntity villagersEntity = data.get(position);
                new XPopup.Builder(VListActivity.this)
                        .autoFocusEditText(false)
                        .asCustom(new LongPopu(VListActivity.this,villagersEntity))
                        .show();
                return false;
            }
        });
    }

    private void initView() {
        btn_back = findViewById(R.id.btn_back);
        btn_find = findViewById(R.id.btn_find);
        btn_add = findViewById(R.id.btn_add);

        rv_list = findViewById(R.id.rv_vlist);
        villagersEntities = new ArrayList<>();
        listAdapter = new VListAdapter(villagersEntities);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.setAdapter(listAdapter);

    }
}