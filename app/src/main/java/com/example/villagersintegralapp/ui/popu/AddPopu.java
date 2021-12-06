package com.example.villagersintegralapp.ui.popu;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.villagersintegralapp.R;
import com.lxj.xpopup.core.CenterPopupView;

public class AddPopu extends CenterPopupView {
    public AddPopu(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popu_add;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        EditText et_add_name=findViewById(R.id.et_add_name);
        EditText et_add_password=findViewById(R.id.et_add_password);
        RadioGroup rb_group=findViewById(R.id.rb_group);

        EditText et_add_adress=findViewById(R.id.et_add_adress);
        EditText et_add_integral=findViewById(R.id.et_add_integral);
        Button btn_add_cancle=findViewById(R.id.btn_add_cancle);
        Button btn_add_sure=findViewById(R.id.btn_add_sure);

        btn_add_sure.setOnClickListener(v -> {
            boolean b = noEmpty(et_add_name, et_add_password, et_add_adress, et_add_integral);
            String  sex= ((RadioButton) findViewById(rb_group.getCheckedRadioButtonId())).getText().toString();
            if(b){
                Toast.makeText(getContext(), "n:"+etString(et_add_name)+" p:"+etString(et_add_password)+" s:"+sex+" a:"+etString(et_add_adress)+" i:"+etString(et_add_integral), Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getContext(), "isEmpty", Toast.LENGTH_SHORT).show();
            }
        });
        btn_add_cancle.setOnClickListener(v -> dismiss());

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
