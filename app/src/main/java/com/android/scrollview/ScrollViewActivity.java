package com.android.scrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.hideonbush.R;

public class ScrollViewActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnDown, mBtnUp,mBtnStart;
    private ScrollView scrollView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        bindViews();
    }

    private void bindViews() {
        mBtnDown = findViewById(R.id.btn_down);
        mBtnUp = findViewById(R.id.btn_up);
//        mBtnStart = findViewById(R.id.btn_start);
        scrollView = findViewById(R.id.scroll_view);
        textView = findViewById(R.id.txt_show);
        mBtnUp.setOnClickListener(this);
        mBtnDown.setOnClickListener(this);
//        mBtnStart.setOnClickListener(this);

        StringBuilder scrollViewText = new StringBuilder();
        int j  = 0;
        for (int i = 0; i < 300; i++) {
            scrollViewText.append("QQ" + i + "\n");
            j++;
        }
        System.out.println("i is" + j);
        textView.setText(scrollViewText.toString());
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_up:
                scrollView.fullScroll(ScrollView.FOCUS_UP);
                break;
            case R.id.btn_down:
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                break;
//            case R.id.btn_start:
//                bindViews();
//                break;
        }
    }
}
