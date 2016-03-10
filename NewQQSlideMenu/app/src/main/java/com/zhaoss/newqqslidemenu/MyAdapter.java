package com.zhaoss.newqqslidemenu;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Zhaoss on 2016/3/4.
 */
public class MyAdapter extends RecyclerView.Adapter {

    private String[] datas;
    private Activity activity;

    public MyAdapter(Activity activity, String[] datas){
        this.datas = datas;
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(activity, R.layout.item_left_menu, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder vh = (MyViewHolder) holder;
        vh.tv_title.setText(datas[position]);
    }

    @Override
    public int getItemCount() {
        return datas.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_src;
        TextView tv_title;

        public MyViewHolder(View view) {
            super(view);

            iv_src = (ImageView) view.findViewById(R.id.iv_src);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
        }
    }
}
