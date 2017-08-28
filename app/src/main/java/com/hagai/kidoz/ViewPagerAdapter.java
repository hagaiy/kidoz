package com.hagai.kidoz;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hagay on 8/28/2017.
 */


public class ViewPagerAdapter  extends PagerAdapter{
    private List<TextView> views;

    public ViewPagerAdapter(List<TextView> views) {
        this.views = views;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public int getCount() {
        return views.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object o) {
        // TODO Auto-generated method stub
        return view == o;
    }
}
