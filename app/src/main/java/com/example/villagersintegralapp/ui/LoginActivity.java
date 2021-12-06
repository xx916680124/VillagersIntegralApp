package com.example.villagersintegralapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.villagersintegralapp.R;
import com.example.villagersintegralapp.ui.villag.VillageCommitteeActivity;
import com.example.villagersintegralapp.ui.villagers.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    private TextView tv_register;
    private Button btn_login;
    private EditText et_name;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }

    private void initListener() {
        tv_register.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));

        btn_login.setOnClickListener(v -> {
            String name = et_name.getText().toString().trim();
            String password = et_password.getText().toString().trim();
            if ("".equals(name) && "".equals(password)){
                Toast.makeText(LoginActivity.this,"用户名或密码为空",Toast.LENGTH_SHORT).show();
            }else{
                if ("admin".equals(name) && "123456".equals(password)){
                    startActivity(new Intent(LoginActivity.this, VillageCommitteeActivity.class));
                }else{
                    //查询数据库找到账户的type确定进入村民还是村委页面

                }
            }
        });

    }

    private void initView() {
        tv_register = findViewById(R.id.tv_register);
        btn_login = findViewById(R.id.btn_login);
        et_name = findViewById(R.id.et_name);
        et_password = findViewById(R.id.et_password);
    }
}