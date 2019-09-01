package com.android.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.android.hideonbush.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {

    private String[] names = new String[]{"nike", "coca", "qq"};
    private String[] says = new String[]{"keep moving", "nice~", "qq~"};
    private int[] imgIds = new int[]{R.mipmap.nike, R.mipmap.coca, R.mipmap.qq};

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
//        setContentView(R.layout.list_view_test);
        listView = findViewById(R.id.list_view_test);

        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();


        for (int i = 0; i < names.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("touxiang", imgIds[i]);
            showitem.put("name", names[i]);
            showitem.put("says", says[i]);
            listitem.add(showitem);
        }

        SimpleAdapter myAdapter = new SimpleAdapter(getApplicationContext(), listitem,
                R.layout.list_view_test, new String[]{"touxiang", "name", "says"}, new int[]{
                R.id.image_header, R.id.title, R.id.description});
        listView.setAdapter(myAdapter);
    }
}
