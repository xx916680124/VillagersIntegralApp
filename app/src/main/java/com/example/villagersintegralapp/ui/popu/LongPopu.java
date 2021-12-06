package com.example.villagersintegralapp.ui.popu;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.villagersintegralapp.R;
import com.lxj.xpopup.core.CenterPopupView;

public class LongPopu extends CenterPopupView {
    public LongPopu(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popu_find;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        EditText et_find_name=findViewById(R.id.et_find_name);

        Button btn_add_sure=findViewById(R.id.btn_find_find);
        Button btn_find_cancle=findViewById(R.id.btn_find_cancle);

        btn_add_sure.setOnClickListener(v -> {
            boolean b = noEmpty(et_find_name);
            if(b){
                Toast.makeText(getContext(), "n:"+etString(et_find_name), Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getContext(), "isEmpty", Toast.LENGTH_SHORT).show();
            }
        });
        btn_find_cancle.setOnClickListener(v -> dismiss());

    }
    public boolean noEmpty(EditText... views){
        for (EditText view : views) {
            if (etString(view).isEmpty()){
                return false;
            }
        }
        return true;
    }
    public String etString(EditText view){
        return view.getText().toString().trim();
    }
}
