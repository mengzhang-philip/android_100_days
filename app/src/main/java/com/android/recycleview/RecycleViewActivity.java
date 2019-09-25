package com.android.recycleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.hideonbush.R;
import com.android.learningpool.LearningPoolActivity;
import com.android.loadinternetimg.GlideLoadImgActivity;
import com.android.recycleview.RecycleViewAdapter.OnItemClickListener;

import java.util.ArrayList;

public class RecycleViewActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecycleViewAdapter mRecycleAdapter;
    private Button mBtnAddImg, mBtnDeleteImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
//        setContentView(R.layout.view_rv_tall);
//        setContentView(R.layout.view_rv_short);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE);
        initData();
        initView();
    }

    private void initData() {
//        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mLayoutManager = new GridLayoutManager(this,2, OrientationHelper.VERTICAL,false);
//        mLayoutManager = new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);
        mRecycleAdapter = new RecycleViewAdapter(getData());

    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv_list);
        mBtnAddImg = findViewById(R.id.btn_add_img);
        mBtnDeleteImg = findViewById(R.id.btn_delete_img);
        mBtnAddImg.setOnClickListener(this);
        mBtnDeleteImg.setOnClickListener(this);
        mRecycleAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecycleViewActivity.this, "Click " + position + " img", Toast.LENGTH_LONG).show();
                startActivity(new Intent(RecycleViewActivity.this, LearningPoolActivity.class));
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RecycleViewActivity.this, "LongClick " + position + " img", Toast.LENGTH_LONG).show();
            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mRecycleAdapter);
        mRecyclerView.addItemDecoration(new MDGridRvDividerDecoration(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_img:
                mRecycleAdapter.addNewItem();
                mLayoutManager.scrollToPosition(0);
                break;
            case R.id.btn_delete_img:
                mRecycleAdapter.deleteItem();
                mLayoutManager.scrollToPosition(0);
                break;
        }
    }

    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String item = "ITEM";
        for (int i = 0; i < 20; i++) {
            data.add(Integer.toString(R.mipmap.daily_hd_9));
        }
        return data;
    }
}
