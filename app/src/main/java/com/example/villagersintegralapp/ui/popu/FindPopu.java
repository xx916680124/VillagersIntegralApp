package com.example.villagersintegralapp.ui.popu;


import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.villagersintegralapp.R;
import com.example.villagersintegralapp.sql.DbControl;
import com.example.villagersintegralapp.sql.VillagersEntity;
import com.google.gson.Gson;
import com.lxj.xpopup.core.CenterPopupView;

import java.util.List;

public class FindPopu extends CenterPopupView {
    public FindPopu(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popu_find;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        EditText et_find_name = findViewById(R.id.et_find_name);

        Button btn_add_sure = findViewById(R.id.btn_find_find);
        Button btn_find_cancle = findViewById(R.id.btn_find_cancle);

        btn_add_sure.setOnClickListener(v -> {
            boolean b = noEmpty(et_find_name);
            if (b) {
                List<VillagersEntity> villagersEntities = DbControl.getInstance(getContext()).searchByWhere(etString(et_find_name));
                if (villagersEntities.isEmpty()) {
                    Toast.makeText(getContext(), "查无此人", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "n:" + new Gson().toJson(villagersEntities.get(0)), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getContext(), "请输入要查找的名字", Toast.LENGTH_SHORT).show();
            }
        });
        btn_find_cancle.setOnClickListener(v -> dismiss());

    }

    public boolean noEmpty(EditText... views) {
        for (EditText view : views) {
            if (etString(view).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public String etString(EditText view) {
        return view.getText().toString().trim();
    }
}
