package com.t3h.buoi3.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.t3h.buoi3.R;

import java.text.SimpleDateFormat;

public class CustomTextClock extends View implements Runnable{

    private Paint paint;
    private String time;

    public CustomTextClock(Context context) {
        super(context);
        init(null);
    }

    public CustomTextClock(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomTextClock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomTextClock(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setTextSize(50);
        paint.setStrokeWidth(20);
        Thread t = new Thread(this);
        t.start();

        if (attrs == null) return;
        TypedArray arr = getResources()
                .obtainAttributes(attrs, R.styleable.CustomTextClock);
        int color = arr.getColor(R.styleable.CustomTextClock_color,
                Color.BLACK);
        float size = arr.getDimension(R.styleable.CustomTextClock_size,
                10F);
        paint.setTextSize(size);
        paint.setColor(color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (time == null) return;
        canvas.drawText(time, 100, 100, paint);
    }

    @Override
    public void run() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        while (true) {
            Log.e(getClass().getName(), getWidth()+"-"+ getHeight());
            long current = System.currentTimeMillis();
            time = format.format(current);
            postInvalidate();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(w, w);
    }
}
