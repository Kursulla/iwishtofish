package com.iwishtofish;

/**
 * Created by Kursulla on 23/08/15.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DrawerItem extends RelativeLayout {
    protected TextView  drawerItemText;
    protected ImageView drawerItemIcon;

    private String text;
    private int iconResource;

    public DrawerItem(Context context) {
        super(context);
        init();
    }

    public DrawerItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        getCustomStylesValues(context, attrs);
        init();
    }

    public DrawerItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getCustomStylesValues(context, attrs);
        init();
    }

    private void getCustomStylesValues(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.DrawerItem, 0, 0);

        try {
            text = a.getString(R.styleable.DrawerItem_menuItemText);
            iconResource = a.getResourceId(R.styleable.DrawerItem_menuItemIcon, R.drawable.ic_launcher);
        } finally {
            a.recycle();
        }
    }

    protected void init() {
        inflate(getContext(),R.layout.drawer_item,this);
        drawerItemText = (TextView)findViewById(R.id.drawable_text);
        drawerItemIcon = (ImageView)findViewById(R.id.drawable_icon);

        drawerItemText.setText(text);
        drawerItemIcon.setImageResource(iconResource);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}