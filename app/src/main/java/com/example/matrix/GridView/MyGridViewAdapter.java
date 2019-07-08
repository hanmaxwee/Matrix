package com.example.matrix.GridView;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.matrix.R;

class MyGridViewAdapter extends BaseAdapter {

    private Context mcontext;
    private LayoutInflater mlayoutInflater;


    MyGridViewAdapter(Context context){
        this.mcontext = context;
        mlayoutInflater = LayoutInflater.from( context );
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imagview;
        public TextView textview;
    };

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView == null){

            convertView = mlayoutInflater.inflate( R.layout.layout_grid_item,null);
            holder = new ViewHolder();
            holder.imagview = convertView.findViewById( R.id.iv_grid);
            holder.textview = convertView.findViewById( R.id.iv_title );
            convertView.setTag( holder );

        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textview.setText( "I just kinda wish you were gay" );
        Glide.with( mcontext ).load( "https://pic.baike.soso.com/ugc/baikepic2/14901/cut-20180802191530-254053648_jpg_237_296_12180.jpg/300" ).into( holder.imagview );

        return convertView;
    }
}
