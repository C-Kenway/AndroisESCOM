package com.example.myapplication;

import android.content.*; import android.graphics.*; import android.view.View;
public class Lienzo extends View {

    public Lienzo(Context c) {
        super(c);
    }

    protected void onDraw(Canvas c) {
        super.onDraw(c); // Canvas pinta atributos


        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);


        for(int i=1; i<500;i+=5){
            c.drawCircle(100+i, 100, 1, paint);
            c.drawCircle(100, 120+i, 1, paint);
            c.drawCircle(150+i, 150+i, 1, paint);
        }
    }
}
