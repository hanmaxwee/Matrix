package com.example.matrix;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {
    private Button btn_login;
    private Button btn_signin;
    private RadioGroup rb_email;
    private CheckBox cb_gg,cb_g;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        btn_login = findViewById(R.id.login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditTextActivity.this,"登录中...", Toast.LENGTH_SHORT).show();
            }
        });


        btn_signin = findViewById(R.id.sign_in);
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditTextActivity.this,"注册中...",Toast.LENGTH_SHORT).show();
            }
        });


        rb_email =  findViewById(R.id.rg_1);
        rb_email.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                Toast.makeText(EditTextActivity.this,radioButton.getText(),Toast.LENGTH_SHORT).show();
            }
        });


        cb_gg = findViewById(R.id.cb_gg);
        cb_g  = findViewById(R.id.cb_g);
        cb_gg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(EditTextActivity.this,isChecked?"已选中":"未选中",Toast.LENGTH_SHORT).show();
            }
        });
        cb_g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(EditTextActivity.this,isChecked?"已选中":"未选中",Toast.LENGTH_SHORT).show();
            }
        });
    }
}