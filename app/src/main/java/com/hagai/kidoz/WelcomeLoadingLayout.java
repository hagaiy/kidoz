package com.hagai.kidoz;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hagay on 8/28/2017.
 */

public class WelcomeLoadingLayout extends FrameLayout
{

    private Button leftButton;
    private Button rightButton;
    //
    private ImageView topImageView;
    private ImageView backgroundImageView;
    //
    private ViewPager viewPager;

    private int smallSize = 300;
    private int bigSize = 600;

    private String red  = "#ff0000";
    private String green  = "#00ff00";
    private String blue  = "#0000ff";

    public WelcomeLoadingLayout(Context context)
    {
        super(context);
        setSelfParams();
        init(context);
    }
    private void init(Context context)
    {
        initButtons(context);
        initViewPager(context);
        initViews(context);
        addViews();
    }

    private void initViews(Context context)
    {
        topImageView = new ImageView(context);
        topImageView.setLayoutParams(new FrameLayout.LayoutParams(smallSize,smallSize, Gravity.CENTER_HORIZONTAL|Gravity.TOP));
        topImageView.setBackgroundColor(Color.parseColor(blue));
//        topImageView.setImageLevel(2);
        //
        backgroundImageView = new ImageView(context);
        backgroundImageView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,bigSize, Gravity.CENTER));
        backgroundImageView.setBackgroundColor(Color.parseColor(blue));
        backgroundImageView.setImageLevel(2);

    }

    private void initViewPager(Context context)
    {
        int textSize = 22;
        //
        TextView tv = new TextView(context);
        tv.setText("1");
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        //
        TextView tv2 = new TextView(context);
        tv2.setText("2");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        //
        List<TextView> list = new ArrayList<TextView>();
        list.add(tv);
        list.add(tv2);
        ViewPagerAdapter vpg = new ViewPagerAdapter(list);
        //
        viewPager =  new ViewPager(context);
        viewPager.setBackgroundColor(Color.parseColor(green));
        viewPager.setAdapter(vpg);
        viewPager.setLayoutParams(new FrameLayout.LayoutParams(bigSize,smallSize, Gravity.CENTER));
    }

    private void initButtons(Context context)
    {
        leftButton = new Button(context);
        leftButton.setLayoutParams(new FrameLayout.LayoutParams(smallSize,smallSize, Gravity.CENTER_VERTICAL|Gravity.LEFT));
        leftButton.setText("BACK");
        leftButton.setBackgroundColor(Color.parseColor(red));
        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSwipe(-1);
            }
        });
        rightButton = new Button(context);
        rightButton.setLayoutParams(new FrameLayout.LayoutParams(smallSize,smallSize, Gravity.CENTER_VERTICAL|Gravity.RIGHT));
        rightButton.setText("FWD");
        rightButton.setBackgroundColor(Color.parseColor(red));
        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSwipe(1);
            }
        });
    }

    private void addViews()
    {
        addView(leftButton);
        addView(rightButton);
        addView(topImageView);
        addView(backgroundImageView);
        addView(viewPager);
    }

    private void buttonSwipe(int howMuch)
    {
        int state = viewPager.getCurrentItem();
        int max = viewPager.getAdapter().getCount();
        int newState = howMuch + state;
        if(max >= newState && newState >= 0)
        {
            viewPager.setCurrentItem(newState);
        }
        else
        {
            return;
        }

    }


    private void setSelfParams()
    {
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, bigSize*2);
        lp.setMargins(20,20,20,20);
        setLayoutParams(lp);
    }


}
