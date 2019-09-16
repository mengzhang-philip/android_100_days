package com.android.loadinternetimg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.hideonbush.R;
import com.bumptech.glide.Glide;

public class GlideLoadImgActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Button mBtnDownloadImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_load_img);
        imageView = findViewById(R.id.image_view);
        mBtnDownloadImg = findViewById(R.id.btn_start_download_img);
        mBtnDownloadImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_start_download_img:
                loadImage(imageView);
                break;
        }
    }

    public void loadImage(View view){
        String url = "http://moplusdevelop.s3.amazonaws.com/androidlocker/v1.1.0wallpaperdaily/daily_hd_9.jpg";
        Glide.with(this).load(url).into(imageView);
    }
}
