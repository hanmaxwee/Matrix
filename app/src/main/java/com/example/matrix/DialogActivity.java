package com.example.matrix;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.matrix.Utill.ToastUtill;

public class DialogActivity extends AppCompatActivity {
    private Button mBtn_ad_1;
    private Button mBtn_ad_2;
    private Button mBtn_ad_3;
    private Button mBtn_ad_4;
    private Button mBtn_ad_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dialog );

        mBtn_ad_1 = findViewById( R.id.btn_dialog_1 );
        mBtn_ad_2 = findViewById( R.id.btn_dialog_2 );
        mBtn_ad_3 = findViewById( R.id.btn_dialog_3 );
        mBtn_ad_4 = findViewById( R.id.btn_dialog_4 );
        mBtn_ad_5 = findViewById( R.id.btn_dialog_5 );
        OnClick onClick = new OnClick();

        mBtn_ad_1.setOnClickListener( onClick );
        mBtn_ad_2.setOnClickListener( onClick );
        mBtn_ad_3.setOnClickListener( onClick );
        mBtn_ad_4.setOnClickListener( onClick );
        mBtn_ad_5.setOnClickListener( onClick );
    }


    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btn_dialog_1:
                    AlertDialog.Builder builder = new AlertDialog.Builder( DialogActivity.this );
                    builder.setTitle( "Answer THE QUESTION !" )
                            .setIcon(R.drawable.username)
                            .setMessage( "DO YOU KNOW Billie Eillish WHO is a 18-year-old singer ?" )
                            .setPositiveButton( "YEP!", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtill.showMsg( DialogActivity.this,"like +1" );
                                }
                            } )
                            .setNeutralButton( "BAD GUY ?", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtill.showMsg( DialogActivity.this,"OK... +0" );
                                }
                            } )
                            .setNegativeButton( "NOPE...", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtill.showMsg( DialogActivity.this,"dislike -1" );
                                }
                            } ).show();
                    break;
                case R.id.btn_dialog_2:
                    final String [] array = new String[]{"BOY","GIRL"};
                    AlertDialog.Builder builder1 = new AlertDialog.Builder( DialogActivity.this );
                    builder1.setTitle( "选择性别：" ).setItems( array, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtill.showMsg( DialogActivity.this,array[which]);
                        }
                    } ).show();
                    break;
                case R.id.btn_dialog_3:
                    final String[] array2 = new String[]{"男","女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder( DialogActivity.this );
                    builder2.setSingleChoiceItems( array2, 1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtill.showMsg( DialogActivity.this,array2[which]);
                        }
                    } ).show();
                    break;
                case  R.id.btn_dialog_4:
                    final String[]array3 = new String[]{"唱歌","看电影","写代码"};
                    boolean[] Isselected = new boolean[]{false,false,true};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder( DialogActivity.this );
                    builder3.setTitle( "你的兴趣爱好是：" ).setMultiChoiceItems( array3, Isselected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtill.showMsg( DialogActivity.this,array3[which]+":"+isChecked );
                        }
                    } ).show();
                    break;
                case R.id.btn_dialog_5:
                    AlertDialog.Builder builder4 = new AlertDialog.Builder( DialogActivity.this );
                    View view = LayoutInflater.from( DialogActivity.this ).inflate( R.layout.layout_dialog,null);
                    EditText et_username = view.findViewById( R.id.et_username );
                    EditText et_password = view.findViewById( R.id.et_password );
                    Button btn_login = view.findViewById( R.id.btn_login );
                    btn_login.setOnClickListener( new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    } );


                    builder4.setTitle( "请先登录：" ).setView( view ).show();
            }


        }
    }
}