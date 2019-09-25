package com.android.hideonbush;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.android.learningpool.LearningPoolActivity;
import com.android.listview.organiclistview.OrganicListViewAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //UI Object
//    private TextView txt_topbar;
    private TextView txt_phone;
    private TextView txt_message;
    private TextView txt_game;
    private TextView txt_settings;
    private MainActivity mainActivity;
//    private FrameLayout ly_content;

    private Button mBtnGoToCustomPage, mBtnGoToLearningPool;

    //Fragment Object
    private MyFragment fg1, fg2, fg3, fg4;
    private FragmentManager fManager;

    public static final String EXTRA_MESSAGE = "com.android.hideonbush.MESSAGE";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE);
        fManager = getSupportFragmentManager();
        bindViews();
        txt_phone.performClick();   //模拟一次点击，既进去后选择第一项
        init();
    }


    private void init() {
        initView();
        initListener();
    }

    private void initView() {
        mBtnGoToCustomPage = findViewById(R.id.navigation_to_uzi);
        mBtnGoToLearningPool = findViewById(R.id.navigation_to_alibaba);
    }

    private void initListener() {
        mBtnGoToCustomPage.setOnClickListener(this);
        mBtnGoToLearningPool.setOnClickListener(this);
    }

    //UI组件初始化与事件绑定
    private void bindViews() {
//        txt_topbar = findViewById(R.id.txt_topbar);
        txt_phone = findViewById(R.id.txt_channel);
        txt_message = findViewById(R.id.txt_message);
        txt_game = findViewById(R.id.txt_better);
        txt_settings = findViewById(R.id.txt_setting);
//        ly_content = findViewById(R.id.ly_content);

        txt_phone.setOnClickListener(this);
        txt_message.setOnClickListener(this);
        txt_game.setOnClickListener(this);
        txt_settings.setOnClickListener(this);
    }

    //重置所有文本的选中状态
    private void setSelected() {
        txt_phone.setSelected(false);
        txt_message.setSelected(false);
        txt_game.setSelected(false);
        txt_settings.setSelected(false);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            View decorView = getWindow().getDecorView();
            int status = View.SYSTEM_UI_FLAG_IMMERSIVE;
            decorView.setSystemUiVisibility(status);
        }
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (fg1 != null) fragmentTransaction.hide(fg1);
        if (fg2 != null) fragmentTransaction.hide(fg2);
        if (fg3 != null) fragmentTransaction.hide(fg3);
        if (fg4 != null) fragmentTransaction.hide(fg4);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()) {
            case R.id.txt_channel:
                setSelected();
                txt_phone.setSelected(true);
                if (fg1 == null) {
                    fg1 = new MyFragment("第一个Fragment");
                    fTransaction.add(R.id.ly_content, fg1);
                } else {
                    fTransaction.show(fg1);
                }
                break;
            case R.id.txt_message:
                setSelected();
                txt_message.setSelected(true);
                if (fg2 == null) {
                    fg2 = new MyFragment("第二个Fragment");
                    fTransaction.add(R.id.ly_content, fg2);
                } else {
                    fTransaction.show(fg2);
                }
                break;
            case R.id.txt_better:
                setSelected();
                txt_game.setSelected(true);
                if (fg3 == null) {
                    fg3 = new MyFragment("第三个Fragment");
                    fTransaction.add(R.id.ly_content, fg3);
                } else {
                    fTransaction.show(fg3);
                }
                break;
            case R.id.txt_setting:
                setSelected();
                txt_settings.setSelected(true);
                if (fg4 == null) {
                    fg4 = new MyFragment("第四个Fragment");
                    fTransaction.add(R.id.ly_content, fg4);
                } else {
                    fTransaction.show(fg4);
                }
                break;
            case R.id.navigation_to_uzi:
                Intent intent = new Intent(this, OrganicListViewAdapter.class);
                String message = "startListViewAdapter";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                break;
            case R.id.navigation_to_alibaba:
                Intent intent2 = new Intent(this, LearningPoolActivity.class);
                startActivity(intent2);
                break;
        }
        fTransaction.commit();
    }
}
