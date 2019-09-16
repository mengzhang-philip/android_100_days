package com.android.followball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.jar.Attributes;

/**
 * <pre>
 *     author : philip-knight
 *     e-mail : meng.zhang@ihandysoft.com
 *     time   : 2019/09/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class DrawView extends View {
    public Paint paint;
    public Context context;
    public float currentX = 40;
    public float currentY = 50;
    public float radius = 15;

    Paint pencil = new Paint();

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet set) {
        super(context, set);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        pencil.setColor(Color.RED);
        pencil.setAntiAlias(true);
        canvas.drawCircle(currentX, currentY, radius, pencil);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentX = (float) event.getX();
                currentY = (float) event.getY();
            case MotionEvent.ACTION_MOVE:
                currentX = (float) event.getX();
                currentY = (float) event.getY();
            case MotionEvent.ACTION_UP:
                currentX = (float) event.getX();
                currentY = (float) event.getY();
                break;
        }

//        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        int width = windowManager.getDefaultDisplay().getWidth();
//        int heigtht = windowManager.getDefaultDisplay().getHeight();
//
//        if (currentX >= 40 && currentY >= 50 && currentX <= width - 18 && currentY <= heigtht - 18){
//
//        }
        invalidate();
        return true;
    }
}
