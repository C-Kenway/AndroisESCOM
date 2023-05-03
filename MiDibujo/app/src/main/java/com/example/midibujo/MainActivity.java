package com.example.midibujo;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public void onCreate(Bundle b){
        super.onCreate(b);
        SpecialView myView = new SpecialView(this);
        setContentView(myView);
    }
    class SpecialView extends View{
        float x = 50;
        float y = 50;
        String accion = "accion";
        Path path =new Path();
        public SpecialView(Context context){
            super(context);
        }
        protected void onDraw(Canvas canvas){
            canvas.drawColor(Color.rgb(255, 255, 150));
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(6);
            paint.setColor(Color.BLUE);
            if(accion=="down"){
                path.moveTo(x, y);
            }
            if(accion=="move"){
                path.lineTo(x, y);
            }
            canvas.drawPath(path, paint);
        }
        public boolean onTouchEvent(MotionEvent evento){
            x = evento.getX();
            y = evento.getY();
            if(evento.getAction() == MotionEvent.ACTION_DOWN){
                accion = "down";
            }
            if(evento.getAction() == MotionEvent.ACTION_MOVE){
                accion = "move";
            }
            invalidate();
            return true;
        }
    }
}