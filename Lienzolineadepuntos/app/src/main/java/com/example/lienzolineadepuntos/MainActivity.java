package com.example.lienzolineadepuntos;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private MyView mMyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMyView = new MyView(this);
        setContentView(mMyView);
    }

    public static class MyView extends View {

        private Paint mPaint;
        private float mX, mY;
        private int mNumPoints = 0;
        private Handler mHandler = new Handler();
        private Runnable mRunnable = new Runnable() {
            @Override
            public void run() {
                mNumPoints++;
                invalidate();
                mHandler.postDelayed(this, 1500); // retardo de 1.5 segundos
            }
        };

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
            mPaint.setColor(Color.WHITE);
            mPaint.setStrokeWidth(20f);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            // Dibujar una línea horizontal en la parte inferior del lienzo
            canvas.drawLine(0, canvas.getHeight() - 1, canvas.getWidth(), canvas.getHeight() - 1, mPaint);

            // Dibujar puntos en línea
            float startX = canvas.getWidth() / 2f;
            float startY = canvas.getHeight() / 4f;
            float endY = canvas.getHeight() * 3f / 4f;
            float pointSize = 10f;
            float spacing = 20f;

            for (int i = 0; i < mNumPoints; i++) {
                float x = startX;
                float y = startY + i * spacing;
                canvas.drawCircle(x, y, pointSize, mPaint);
            }

            // Si se ha llegado al final del lienzo, cancelar la ejecución del Handler
            if (startY + (mNumPoints + 1) * spacing >= endY) {
                mHandler.removeCallbacks(mRunnable);
            } else {
                mHandler.postDelayed(mRunnable, 1500);
            }
        }
    }
}