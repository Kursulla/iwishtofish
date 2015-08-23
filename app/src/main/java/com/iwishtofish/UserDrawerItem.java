package com.iwishtofish;

/**
 * Created by Kursulla on 23/08/15.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class UserDrawerItem extends RelativeLayout {
    protected TextView  drawerUserName;
    protected ImageView drawerUserIcon;

    public UserDrawerItem(Context context) {
        super(context);
        init();
    }

    public UserDrawerItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UserDrawerItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void init() {
        inflate(getContext(),R.layout.drawer_user_item,this);
        drawerUserName = (TextView)findViewById(R.id.user_name);
        drawerUserIcon = (ImageView)findViewById(R.id.user_icon);
    }

    //TODO for now, keep default. Later introduce Fresco lib
    public void setUser(String userName, String userIconUrl){
        drawerUserName.setText(userName);
        if(userIconUrl != null) {
            //Fresco
        }
    }
    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}