package com.android.doublerecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.doublerecycleview.ClassAdapter.OnItemClickListener;
import com.android.hideonbush.R;

public class DoubleRecycleViewActivity extends AppCompatActivity {
    private RecyclerView mRvClass;
    private RecyclerView mRVStudent;
    private ClassAdapter classAdapter;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_recycle_view);

        initView();
        initAdapter();
    }

    private void initView(){
        mRvClass = findViewById(R.id.rv_left_view);
        mRVStudent = findViewById(R.id.rv_right_view);
    }

    private void initAdapter(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DoubleRecycleViewActivity.this);
        mRvClass.setLayoutManager(linearLayoutManager);
        classAdapter = new ClassAdapter(DoubleRecycleViewActivity.this);
        mRvClass.setAdapter(classAdapter);
        mRvClass.setScrollingTouchSlop(0);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(DoubleRecycleViewActivity.this);
        mRVStudent.setLayoutManager(linearLayoutManager1);
        studentAdapter = new StudentAdapter(DoubleRecycleViewActivity.this);
        mRVStudent.setAdapter(studentAdapter);
        mRVStudent.setScrollingTouchSlop(0);

        classAdapter.setmOnItemClickListener(new ClassAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mRvClass.setScrollingTouchSlop(position);
                studentAdapter.setData(position);
                studentAdapter.notifyDataSetChanged();
            }
        });
    }

}
