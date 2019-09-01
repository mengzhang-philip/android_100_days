package com.android.listview.organiclistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.android.hideonbush.R;

import java.util.LinkedList;
import java.util.List;

public class OrganicListViewAdapter extends AppCompatActivity {

    private List<Animal> mData = null;
    private Context mContext;
    private AnimalAdapter mAdapter = null;
    private ListView listAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orangic_list_view);
        mContext = OrganicListViewAdapter.this;
        listAnimal = findViewById(R.id.activity_orangic_list_view);

        final LayoutInflater inflater = LayoutInflater.from(this);
        View headView = inflater.inflate(R.layout.view_header, null, false);
        View footView = inflater.inflate(R.layout.view_footer, null, false);

        mData = new LinkedList<Animal>();
        mData.add(new Animal("狗说", "你是狗么?", R.mipmap.nike));
        mData.add(new Animal("牛说", "你是牛么?", R.mipmap.coca));
        mData.add(new Animal("鸭说", "你是鸭么?", R.mipmap.qq));
        mAdapter = new AnimalAdapter((LinkedList<Animal>) mData, mContext);

        listAnimal.addHeaderView(headView);
        listAnimal.addFooterView(footView);
        listAnimal.setAdapter(mAdapter);
        listAnimal.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "你点击了第" + position + "项", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
