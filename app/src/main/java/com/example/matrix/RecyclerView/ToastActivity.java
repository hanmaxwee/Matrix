package com.example.matrix.RecyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matrix.R;
import com.example.matrix.Utill.ToastUtill;

public class ToastActivity extends AppCompatActivity {

    private Button mBtn_toast1,mBtn_toast2,mBtn_toast3,mBtn_toast4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_toast );

        mBtn_toast1 = findViewById( R.id.btn_toast1 );
        mBtn_toast2 = findViewById( R.id.btn_toast2 );
        mBtn_toast3 = findViewById( R.id.btn_toast3 );
        mBtn_toast4 = findViewById( R.id.btn_toast4 );

        OnClick onClick = new OnClick();

        mBtn_toast1.setOnClickListener( onClick );
        mBtn_toast2.setOnClickListener( onClick );
        mBtn_toast3.setOnClickListener( onClick );
        mBtn_toast4.setOnClickListener( onClick );


    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_toast1:
                    Toast.makeText(getApplicationContext(),"默认",Toast.LENGTH_SHORT ).show();
                    break;
                case R.id.btn_toast2:
                    Toast toastcenter = Toast.makeText( getApplicationContext(),"居中",Toast.LENGTH_SHORT );
                    toastcenter.setGravity( Gravity.CENTER,0 ,0);
                    toastcenter.show();
                    break;
                case R.id.btn_toast3:
                    Toast toastcustom = new Toast( getApplicationContext() );
                    LayoutInflater inflater = LayoutInflater.from( ToastActivity.this );
                    View view = inflater.inflate( R.layout.layout_toast,null );
                    ImageView imageView = view.findViewById( R.id.iv_toast );
                    TextView textView = view.findViewById( R.id.tv_toast );
                    toastcustom.setView( view );
                    imageView.setImageResource( R.drawable.image1 );
                    textView.setText( "自定义图片" );
                    toastcustom.show();
                    break;
                case R.id.btn_toast4:
                    ToastUtill.showMsg( getApplicationContext(),"长按的Toast/" );
                    break;

            }
        }
    }
}