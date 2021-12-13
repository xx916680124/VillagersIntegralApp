package com.example.villagersintegralapp.ui.popu;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.villagersintegralapp.R;
import com.example.villagersintegralapp.sql.DbControl;
import com.example.villagersintegralapp.sql.VillagersEntity;
import com.lxj.xpopup.core.CenterPopupView;

public class LongPopu extends CenterPopupView {
    VillagersEntity villagersEntity;
    public LongPopu(@NonNull Context context, VillagersEntity villagersEntity) {
        super(context);
        this.villagersEntity =villagersEntity;
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popu_long;
    }

    @Override
    protected void onCreate() {
        super.onCreate();

        Button btn_long_update=findViewById(R.id.btn_long_update);
        Button btn_long_delete=findViewById(R.id.btn_long_delete);

        btn_long_update.setOnClickListener(v -> {

        });
        btn_long_delete.setOnClickListener(v -> {
            DbControl.getInstance(getContext()).delete(villagersEntity.getName());
            dismiss();
        });

    }
}
