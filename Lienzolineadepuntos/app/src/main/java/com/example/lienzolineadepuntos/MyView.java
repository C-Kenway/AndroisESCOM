package com.example.lienzolineadepuntos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    private Paint mPaint;
    private float mX, mY;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(5f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Dibujar una línea horizontal en la parte inferior del lienzo
        canvas.drawLine(0, canvas.getHeight() - 1, canvas.getWidth(), canvas.getHeight() - 1, mPaint);

        // Dibujar puntos en línea
        float startY = canvas.getHeight() / 2f;
        float endY = startY;
        float startX = 0f;
        float endX = canvas.getWidth();
        float stepSize = 10f;

        for (float x = startX; x <= endX; x += stepSize) {
            canvas.drawPoint(x, startY, mPaint);

            if (x > startX) {
                canvas.drawLine(x - stepSize, endY, x, startY, mPaint);
            }
        }

        // Invalidar el lienzo para dibujar de nuevo
        invalidate();
    }
}