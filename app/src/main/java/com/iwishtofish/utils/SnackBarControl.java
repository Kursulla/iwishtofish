package com.iwishtofish.utils;

import android.app.Activity;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.iwishtofish.R;

/**
 * Light SnackBar wrapper
 * Created by Kursulla on 18/08/15.
 */
public class SnackBarControl {
    public static void showSimpleSnackBar(String message, Activity activity) {
        createSimpleSnackBar(message, activity).show();
    }

    public static void showSimpleSnackBar(int message, Activity activity) {
        createSimpleSnackBar(activity.getString(message), activity).show();
    }

    private static Snackbar createSimpleSnackBar(String message, Activity activity) {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) activity.findViewById(R.id.coordinator_layout);
        final Snackbar snackbar = Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        snackbar.setAction("Dismiss", new OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        });
        snackbar.setActionTextColor(Color.WHITE);
        snackBarView.setBackgroundColor(activity.getResources().getColor(R.color.primary));

        textView.setTextColor(Color.WHITE);

        return snackbar;
    }
}
