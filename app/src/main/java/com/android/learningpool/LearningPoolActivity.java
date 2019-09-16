package com.android.learningpool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.android.doublerecycleview.DoubleRecycleViewActivity;
import com.android.flashlight.FrameLayoutActivity;
import com.android.followball.CustomView;
import com.android.hideonbush.R;
import com.android.listview.ContactsListActivity;
import com.android.listview.ListViewActivity;
import com.android.listview.organiclistview.ListViewDataCRUDActivity;
import com.android.listview.organiclistview.OrganicListViewAdapter;
import com.android.loadinternetimg.GlideLoadImgActivity;
import com.android.recycleview.RecycleViewActivity;
import com.android.scrollview.ScrollViewActivity;
import com.android.sharedpreference.SharedPreferenceActivity;
import com.android.widget.WidgetMainActivity;

public class LearningPoolActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnGoToListView, mBtnGoToScrollView, mBtnGoToFragment, mBtnGoToRecycleView, mBtnGoToOrganicListView,
            mBtnGoToCRUD, mBtnGoToSRealcrollView , mBtnGoToWidget, mBtnGotoSharedPreferenece, mBtnDownLoadImg, mBtnGoToRecyclerView,
            mBtnGoToDoubleRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learning_pool);
        init();
    }

    private void init() {
        initView();
        initListener();
    }

    private void initView() {
        mBtnGoToListView = findViewById(R.id.go_to_list_view);
        mBtnGoToFragment = findViewById(R.id.go_to_fragment);
        mBtnGoToRecycleView = findViewById(R.id.go_to_recycle_view);
        mBtnGoToScrollView = findViewById(R.id.go_to_scroll_view);
        mBtnGoToOrganicListView = findViewById(R.id.go_to_organic_list_view);
        mBtnGoToCRUD = findViewById(R.id.go_to_organic_crud_list_view);
        mBtnGoToSRealcrollView = findViewById(R.id.go_to_organic_scroll_view);
        mBtnGoToWidget = findViewById(R.id.go_to_widget_view);
        mBtnGotoSharedPreferenece = findViewById(R.id.go_to_shared_preference);
        mBtnDownLoadImg = findViewById(R.id.go_to_download_img);
        mBtnGoToRecyclerView = findViewById(R.id.go_to_recycler_view);
        mBtnGoToDoubleRecyclerView = findViewById(R.id.go_to_double_recycler_view);
    }

    private void initListener() {
        mBtnGoToListView.setOnClickListener(this);
        mBtnGoToFragment.setOnClickListener(this);
        mBtnGoToRecycleView.setOnClickListener(this);
        mBtnGoToScrollView.setOnClickListener(this);
        mBtnGoToOrganicListView.setOnClickListener(this);
        mBtnGoToCRUD.setOnClickListener(this);
        mBtnGoToSRealcrollView.setOnClickListener(this);
        mBtnGoToWidget.setOnClickListener(this);
        mBtnGotoSharedPreferenece.setOnClickListener(this);
        mBtnDownLoadImg.setOnClickListener(this);
        mBtnGoToRecyclerView.setOnClickListener(this);
        mBtnGoToDoubleRecyclerView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.go_to_list_view:
                Intent intent = new Intent(this, ListViewActivity.class);
                startActivity(intent);
                break;

            case R.id.go_to_scroll_view:
                Intent intent23 = new Intent(this, ContactsListActivity.class);
                startActivity(intent23);
                break;

            case R.id.go_to_organic_list_view:
                Intent intent24 = new Intent(this, OrganicListViewAdapter.class);
                startActivity(intent24);
                break;

            case R.id.go_to_organic_crud_list_view:
                Intent intent25 = new Intent(this, ListViewDataCRUDActivity.class);
                startActivity(intent25);
                break;

            case R.id.go_to_organic_scroll_view:
                startActivity(new Intent(this, ScrollViewActivity.class));
                break;

            case R.id.go_to_widget_view:
                startActivity(new Intent(this, WidgetMainActivity.class));
                break;

            case R.id.go_to_shared_preference:
                startActivity(new Intent(this, SharedPreferenceActivity.class));
                break;

            case R.id.go_to_download_img:
                startActivity(new Intent(this, GlideLoadImgActivity.class));
                break;

            case R.id.go_to_recycler_view:
                startActivity(new Intent(this,RecycleViewActivity.class));
                break;

            case R.id.go_to_double_recycler_view:
                startActivity(new Intent(this, FrameLayoutActivity.class));
                break;
        }
    }


}
