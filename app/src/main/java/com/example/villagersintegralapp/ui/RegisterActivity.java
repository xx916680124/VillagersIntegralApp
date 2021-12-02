package com.example.villagersintegralapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.villagersintegralapp.R;

public class RegisterActivity extends AppCompatActivity {
    private TextView tv_login;
    private Button btn_register;
    private EditText et_name;
    private EditText et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initListener();

    }

    private void initListener() {
        tv_login.setOnClickListener(v -> finish());

        btn_register.setOnClickListener(v -> {
            String name = et_name.getText().toString().trim();
            String password = et_password.getText().toString().trim();
            if ("".equals(name) && "".equals(password)){
                Toast.makeText(RegisterActivity.this, "用户名或密码为空", Toast.LENGTH_SHORT).show();
            }else{
                finish();
            }
        });
    }

    private void initView() {
        tv_login = findViewById(R.id.tv_login);
        btn_register = findViewById(R.id.btn_register);
        et_name = findViewById(R.id.et_name_register);
        et_password = findViewById(R.id.et_password_register);
    }
}