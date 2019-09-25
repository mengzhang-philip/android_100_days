package com.android.customrvwithanimator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.android.hideonbush.R;
import com.jzp.rotate3d.Rotate3D;

public class CustomRvWithAnimator extends AppCompatActivity {

    public ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_rv_with_animator);
        mImageView = findViewById(R.id.image_rotate);
        Animation operatingAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);
        if (operatingAnim != null) {
            mImageView.startAnimation(operatingAnim);
        }  else {
            mImageView.setAnimation(operatingAnim);
            mImageView.startAnimation(operatingAnim);
        }
    }
}
