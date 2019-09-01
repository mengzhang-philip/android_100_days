package com.android.widget;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import com.android.hideonbush.R;

import java.util.InputMismatchException;

public class WidgetMainActivity extends AppCompatActivity {
    ConstraintLayout view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_main);

//        InputMethodManager inm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        inm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
//        inm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
