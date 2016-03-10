package com.zhaoss.newqqslidemenu;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Zhaoss on 2016/3/4.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private Activity activity;

    public ViewPagerAdapter(Activity activity){
        this.activity = activity;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView = new ImageView(activity);
        switch (position){
            case 0:
                imageView.setBackgroundResource(R.mipmap.data1);
                break;
            case 1:
                imageView.setBackgroundResource(R.mipmap.data2);
                break;
            case 2:
                imageView.setBackgroundResource(R.mipmap.data3);
                break;

        }
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
