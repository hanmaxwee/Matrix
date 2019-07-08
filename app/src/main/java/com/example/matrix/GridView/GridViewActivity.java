package com.example.matrix.GridView;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.matrix.R;

public class GridViewActivity extends AppCompatActivity {
    private GridView gv1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_grid_view);


        gv1 = findViewById( R.id.gv_1);
        gv1.setAdapter( new MyGridViewAdapter( GridViewActivity.this ) );
        gv1.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText( GridViewActivity.this,"点击 pos:"+position,Toast.LENGTH_SHORT ).show();
            }
        } );
        gv1.setOnItemLongClickListener( new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText( GridViewActivity.this,"长按 pos:"+position,Toast.LENGTH_SHORT).show();
                return false;
            }
        } );
    }
}
