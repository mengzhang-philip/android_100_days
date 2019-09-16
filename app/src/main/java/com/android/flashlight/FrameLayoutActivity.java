package com.android.flashlight;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.hideonbush.R;

import java.util.Timer;
import java.util.TimerTask;

public class FrameLayoutActivity extends AppCompatActivity {

    private int currentColor = 0;
    final int[] colors = new int[]{
            R.color.color_1,
            R.color.color_2,
            R.color.color_3,
            R.color.color_4,
            R.color.color_5,
            R.color.color_6,
            R.color.color_7,
            R.color.color_8,
            R.color.color_9,
            R.color.color_10
    };

    final int[] views = new int[]{
            R.id.view_1,
            R.id.view_2,
            R.id.view_3,
            R.id.view_4,
            R.id.view_5,
            R.id.view_6,
            R.id.view_7,
            R.id.view_8,
            R.id.view_9,
            R.id.view_10
    };

    TextView[] viewsChange = new TextView[views.length];

    final Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123){
                for (int i = 0; i < views.length; i++) {
                    viewsChange[i].setBackgroundResource(colors[(i + currentColor) % views.length]);
                }
                currentColor++;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        for (int i = 0; i<views.length;i++){
            viewsChange[i] = findViewById(views[i]);
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myHandler.sendEmptyMessage(0x123);
            }
        },0,200);
    }
}
