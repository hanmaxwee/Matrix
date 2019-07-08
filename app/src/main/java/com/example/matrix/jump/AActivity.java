package com.example.matrix.jump;

import android.content.ComponentName;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.matrix.R;

public class AActivity extends AppCompatActivity {
    private Button mbtn_jump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_a );
        mbtn_jump = findViewById( R.id.btn_jump );
        mbtn_jump.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式一；
                Intent intent = new Intent(AActivity.this,BActivity.class );
                Bundle bundle = new Bundle(  );
                bundle.putString( "name","Matrix" );
                bundle.putInt( "No",9527 );
                intent.putExtras( bundle );
//                startActivity( intent );
                startActivityForResult( intent,0 );
                //显式二；
//                Intent intent = new Intent(  );
//                intent.setClass( AActivity.this,BActivity.class );
//                startActivity( intent );

                //显式三；
//                Intent intent = new Intent(  );
//                intent.setClassName( AActivity.this,"com.example.matrix.jump.BActivity" );
//                startActivity( intent );

                //显式四；
//                Intent intent = new Intent(  );
//                intent.setComponent( new ComponentName( AActivity.this,"com.example.matrix.jump.BActivity" ) );
//                startActivity( intent );

                //隐式一；
//                Intent intent = new Intent(  );
//                intent.setAction( "android.example.action.BActivity" );
//                startActivity( intent );

            }
        } );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        Toast.makeText( AActivity.this,data.getExtras().getString( "return" ),Toast.LENGTH_SHORT ).show();
    }
}
