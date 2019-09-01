package com.android.listview.organiclistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.android.hideonbush.R;

import java.util.LinkedList;
import java.util.List;

public class ListViewDataCRUDActivity extends AppCompatActivity implements OnClickListener {

    private ListView listOne;
    private CURDMyAdapter crudMyAdapter;
    private List<CRUDData> mData;
    private Context mContext;

    private Button mBtnAddItem, mBtnRemoveItem, mBtnClearItem;
    public int flag;
    public CRUDData mDataAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_data_crud);
        mBtnAddItem = findViewById(R.id.add_item);
        mBtnRemoveItem = findViewById(R.id.remove_position_item);
        mBtnClearItem = findViewById(R.id.clear_item);

        mBtnAddItem.setOnClickListener(this);
        mBtnRemoveItem.setOnClickListener(this);
        mBtnClearItem.setOnClickListener(this);


        mContext = ListViewDataCRUDActivity.this;
        bindViews();
        mData = new LinkedList<CRUDData>();
        crudMyAdapter = new CURDMyAdapter((LinkedList<CRUDData>) mData, mContext);
        listOne.setAdapter(crudMyAdapter);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_item:
                mDataAdd = new CRUDData(R.mipmap.qq, "增加一条记录" + flag);
                crudMyAdapter.add(mDataAdd);
                flag++;
                break;
            case R.id.remove_position_item:
                if (crudMyAdapter != null) {
                    crudMyAdapter.removeSpecficPositionItem(0);
                }
                break;
            case R.id.clear_item:
                crudMyAdapter.clear(mDataAdd);
                break;
        }
    }

    private void bindViews() {
        listOne = findViewById(R.id.list_one);
    }
}
