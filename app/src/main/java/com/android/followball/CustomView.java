package com.android.followball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.android.hideonbush.R;

public class CustomView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        LinearLayout root = findViewById(R.id.draw_ball_root_view);
        final DrawView draw = new DrawView(this);
        draw.setMinimumHeight(500);
        draw.setMinimumWidth(500);
        root.addView(draw);
    }
}
