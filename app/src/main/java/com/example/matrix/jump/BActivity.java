package com.example.matrix.jump;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.matrix.R;

public class BActivity extends AppCompatActivity {
private TextView met_name;
private Button mbtn_return;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_b );
        met_name = findViewById( R.id.et_name);
        mbtn_return = findViewById( R.id.btn_return );


        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString( "name" );
        Integer no = bundle.getInt( "No" );
        met_name.setText( name+","+no);

        mbtn_return.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(  );
                Bundle bundle1 = new Bundle(  );
                bundle1.putString( "return","LOVE U 3000 TIMES" );
                intent.putExtras( bundle1 );
                setResult( Activity.RESULT_OK,intent );
                finish();

            }
        } );
    }
}
