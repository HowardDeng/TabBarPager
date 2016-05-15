package com.example.goko3210.tabbarpager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by goko3210 on 16/5/10.
 */
public class MyView extends View{

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(0xFFFF6600);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(24);
        paint.setAntiAlias(true);

        canvas.drawText("不，我不想去！",520,75,paint);
    }
}
