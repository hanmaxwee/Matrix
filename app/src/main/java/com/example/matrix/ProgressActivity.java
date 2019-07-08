package com.example.matrix;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.os.RecoverySystem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.matrix.Utill.ToastUtill;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar mpb_3;
    private Button mBtn_start,mBtn_progressdialog_1,mBtn_progressdialog_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_progress );
        mpb_3 = findViewById( R.id.pb_3 );
        mBtn_start = findViewById( R.id.btn_start );
        mBtn_start.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage( 0 );
            }
        } );

        mBtn_progressdialog_1 = findViewById( R.id.btn_progress_1 );
        mBtn_progressdialog_2 = findViewById( R.id.btn_progress_2 );

        mBtn_progressdialog_1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setTitle( "提示：" );
                progressDialog.setMessage( "正在加载..." );
                progressDialog.setOnCancelListener( new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtill.showMsg( ProgressActivity.this,"cancel..." );
                    }
                } );
                progressDialog.show();
            }
        } );
        mBtn_progressdialog_2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog( ProgressActivity.this );
                progressDialog.setProgressStyle( ProgressDialog.STYLE_HORIZONTAL );
                progressDialog.setTitle( "提示：" );
                progressDialog.setMessage( "正在下载..." );
                progressDialog.setButton( DialogInterface.BUTTON_NEGATIVE, "暂停", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                } );
                progressDialog.setButton( DialogInterface.BUTTON_POSITIVE, "停止", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                } );
            }
        } );


    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage( msg );
            if(mpb_3.getProgress()<100){
                handler.postDelayed( runnable,500 );
            }else{
                ToastUtill.showMsg( ProgressActivity.this,"加载完成！" );
            }
        }
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mpb_3.setProgress( mpb_3.getProgress()+10 );
            handler.sendEmptyMessage( 0 );
        }
    };
}
