package com.example.matrix.Utill;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.matrix.R;

public class ToastUtill {

    public static Toast mToast;
    public static void showMsg(Context context, String Msg){
        if (mToast == null){
            mToast = Toast.makeText( context,Msg,Toast.LENGTH_SHORT );
        }else {
            mToast.setText( Msg );
        }
        mToast.show();
    }

}