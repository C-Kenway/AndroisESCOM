package com.example.circulo_barra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CircleView extends View {

    private Paint paint;
    private float size;

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);

        size = 1;
    }

    public void setSize(float newSize) {
        size = newSize;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int radius = (int) (Math.min(width, height) / 2 * size);

        canvas.drawCircle(width / 2, height / 2, radius, paint);
    }
}