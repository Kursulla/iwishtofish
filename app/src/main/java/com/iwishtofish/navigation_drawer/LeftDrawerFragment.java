package com.iwishtofish.navigation_drawer;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.iwishtofish.EventsActivity;
import com.iwishtofish.R;

/**
 * Created by Kursulla on 23/08/15.
 */
public class LeftDrawerFragment extends Fragment {
    private static String TAG = LeftDrawerFragment.class.getSimpleName();
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout          drawerLayout;
    private View container;
    private UserDrawerItem userWidget;
    private DrawerItem fishingEvents;
    private DrawerItem report;
    private DrawerItem pictureTrophy;
    private DrawerItem settings;
    private DrawerItem about;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        container = inflater.inflate(R.layout.fragment_left_drawer, parent, false);
        container.findViewById(R.id.left_drawer_container).setOnClickListener(null);

        userWidget = (UserDrawerItem) container.findViewById(R.id.user_widget);
        fishingEvents = (DrawerItem) container.findViewById(R.id.fishing_events);
        report = (DrawerItem) container.findViewById(R.id.report);
        pictureTrophy = (DrawerItem) container.findViewById(R.id.picture_trophy);
        settings = (DrawerItem) container.findViewById(R.id.settings);
        about = (DrawerItem) container.findViewById(R.id.about);

        userWidget.setUser("Nebojsa Bozic", null);//TODO still static

        fishingEvents.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EventsActivity.class);
                getActivity().startActivity(intent);
            }
        });
        report.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EventsActivity.class);
                getActivity().startActivity(intent);
            }
        });
        pictureTrophy.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EventsActivity.class);
                getActivity().startActivity(intent);
            }
        });
        settings.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EventsActivity.class);
                getActivity().startActivity(intent);
            }
        });
        about.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EventsActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return container;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (drawerToggle != null) {
            drawerToggle.onConfigurationChanged(newConfig);
        }
    }

    public void setUp(DrawerLayout drawerLayout) {
        this.drawerLayout = drawerLayout;
        this.drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (!isAdded()) {
                    return;
                }
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!isAdded()) {
                    return;
                }
            }
        };

        this.drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                drawerToggle.syncState();
            }
        });
        this.drawerLayout.setDrawerListener(drawerToggle);
    }

    public ActionBarDrawerToggle getDrawerToggle() {
        return drawerToggle;
    }

    public boolean isOpen() {
        return drawerLayout.isDrawerOpen(Gravity.LEFT);
    }
    public void closeDrawer(){
        drawerLayout.closeDrawer(Gravity.LEFT);
    }
}
