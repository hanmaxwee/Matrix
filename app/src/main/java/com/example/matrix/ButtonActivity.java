package com.example.matrix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {
    private Button mBtn_3;
    private TextView mBtv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        mBtn_3=findViewById(R.id.btn_3);
        mBtn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "按钮3被点击了", Toast.LENGTH_SHORT).show();
            }
        });

        mBtv1 = findViewById(R.id.tv1);
        mBtv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "标题被点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ShowToast(View view){
        Toast.makeText(this,"按钮4被点击了",Toast.LENGTH_SHORT).show();
    }
}
