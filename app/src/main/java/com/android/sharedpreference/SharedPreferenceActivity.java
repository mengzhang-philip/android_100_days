package com.android.sharedpreference;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.hideonbush.R;

public class SharedPreferenceActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editName;
    private EditText editPassWord;
    private Button mBtnSubmit;
    private String mStrName,mStrPassWord;
    private SharedHelper sp;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        mContext = getApplicationContext();
        sp = new SharedHelper(mContext);
        bindViews();
    }

    private void bindViews(){
        editName = findViewById(R.id.user_name);
        editPassWord = findViewById(R.id.user_password);
        mBtnSubmit = findViewById(R.id.submit_info);

        mBtnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mStrName = editName.getText().toString();
        mStrPassWord = editPassWord.getText().toString();
        sp.save(mStrName,mStrPassWord);
    }
}
