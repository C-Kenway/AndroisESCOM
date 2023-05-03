package com.example.ejercicio14_lienzopixel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.View;

public class MyView extends View {
    Paint myPaint;
    int nPoints;
    Handler myHandler = new Handler();
    Runnable myRunnable = new Runnable() {
        @Override
        //Este es un metodo obligatorio del metodo Runnable
        public void run() {
            nPoints++;
            invalidate();
            //postDelayed es para crear los retardos, en este caso de 3 segundos
            myHandler.postDelayed(this,3000);
        }
    };

    public MyView(Context c){
        super(c);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        myPaint = new Paint();
        myPaint.setColor(Color.YELLOW);
        myPaint.setStrokeWidth(15);

        //Dibujar los puntos en linea
        /*float startX = canvas.getWidth() / 2f;
        float startY = canvas.getHeight() /4f ;
        float endY = (canvas.getHeight() * 3f) / 4f;*/
        float spacing = 20f;
        float startX = 100;
        float startY = 100;
        float endX = (canvas.getWidth() * 3f) / 4f;
        float endY = (canvas.getHeight() * 3f) / 4f;

        for (int i = 0; i<nPoints; i++){
            /*float x = startX;
            float y = startY + i * spacing;
            canvas.drawPoint(x,y,myPaint);*/
            canvas.drawPoint(100 + i * spacing, 100, myPaint);
            canvas.drawPoint(100, 120 + i * spacing, myPaint);
            canvas.drawPoint(100 + i * spacing, 100 + i * spacing, myPaint);
        }

        //Si llego al final del lienzo, cancelar la ejecucion del Handler
        if((startY + (nPoints + 1) * spacing >= endY) || (startX + (nPoints + 1) * spacing >= endX)){
            myHandler.removeCallbacks(myRunnable);
        }else{
            myHandler.postDelayed(myRunnable,3000);
        }
    }
}
