package com.android.fragmentactivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.hideonbush.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView1,mTextView2,mTextView3,mTextView4;
    private ViewPager viewPager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        mTextView1 = findViewById(R.id.content_fragment_chat);
        mTextView2 = findViewById(R.id.content_fragment_contacts);
        mTextView3 = findViewById(R.id.content_fragment_find);
        mTextView4 = findViewById(R.id.content_fragment_me);
        swipeRefreshLayout = findViewById(R.id.swiperefresh);

        mTextView1.setOnClickListener(this);
        mTextView2.setOnClickListener(this);
        mTextView3.setOnClickListener(this);
        mTextView4.setOnClickListener(this);
        swipeRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        viewPager = findViewById(R.id.fragment_container);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new WeChatFragment(), "ONE");
        adapter.addFragment(new ContactsFragment(), "TWO");
        adapter.addFragment(new MomentFragment(),"Three");
        adapter.addFragment(new MeFragment(),"Four");
        viewPager.setAdapter(adapter);

        LayoutInflater inflater = getLayoutInflater();
        layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));
        TextView text = layout.findViewById(R.id.toast_text);
        text.setText("Custom Toast");
//        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.content_fragment_chat:
                Toast toast;
                toast = Toast.makeText(this, "1", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.LEFT,200,300);
                toast.show();
//                addFragment(new WeChatFragment(),false,"ONE");
                viewPager.setCurrentItem(0);
                break;
            case R.id.content_fragment_contacts:
                Toast toasts = new Toast(getApplicationContext());
                toasts.setDuration(Toast.LENGTH_LONG);
                toasts.setView(layout);
                toasts.show();
//                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
//                addFragment(new ContactsFragment(),false, "TWO");
                viewPager.setCurrentItem(1);
                break;
            case R.id.content_fragment_find:
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
//                addFragment(new ContactsFragment(),false, "TWO");
                viewPager.setCurrentItem(2);
                break;
            case R.id.content_fragment_me:
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
//                addFragment(new ContactsFragment(),false, "TWO");
                viewPager.setCurrentItem(3);
                break;
        }
    }

    public void addFragment(Fragment fragment, boolean addToBackStack, String tag){
        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = manager.beginTransaction();

        if (addToBackStack){
            fragmentTransaction.addToBackStack(tag);
        }

        fragmentTransaction.replace(R.id.fragment_container,fragment,tag);
        fragmentTransaction.commitAllowingStateLoss();
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mList = new ArrayList<>();
        private final List<String> mTitleList = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }
        @Override
        public Fragment getItem(int i) {
            return mList.get(i);
        }
        @Override
        public int getCount() {
            return mList.size();
        }
        public void addFragment(Fragment fragment, String title) {
            mList.add(fragment);
            mTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);
        }
    }
}
