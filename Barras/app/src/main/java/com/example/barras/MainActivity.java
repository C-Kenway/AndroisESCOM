package com.example.barras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout verticalLayout;
    private View verticalBarView;
    private TextView verticalValueTextView;

    private LinearLayout horizontalLayout;
    private View horizontalBarView;
    private TextView horizontalValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verticalLayout = findViewById(R.id.vertical_layout);
        verticalBarView = findViewById(R.id.vertical_bar_view);
        verticalValueTextView = findViewById(R.id.vertical_value_textview);

        horizontalLayout = findViewById(R.id.horizontal_layout);
        horizontalBarView = findViewById(R.id.horizontal_bar_view);
        horizontalValueTextView = findViewById(R.id.horizontal_value_textview);

        verticalBarView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        // Obtener la posición del evento táctil en relación a la vista padre
                        int y = (int) motionEvent.getRawY() - verticalLayout.getTop();

                        // Asegurarse de que la posición esté dentro de los límites de la vista de la barra
                        if (y < 0) {
                            y = 0;
                        } else if (y > verticalLayout.getHeight()) {
                            y = verticalLayout.getHeight();
                        }

                        // Actualizar la posición de la vista de la barra
                        verticalBarView.setY(y);
                        verticalValueTextView.setText(String.valueOf(y));

                        return true;

                    case MotionEvent.ACTION_UP:
                        // Devolver la vista de la barra a su posición central
                        verticalBarView.setY(verticalLayout.getHeight() / 2);
                        verticalValueTextView.setText(String.valueOf(verticalLayout.getHeight() / 2));

                        return true;
                }
                return false;
            }
        });

        horizontalBarView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        // Obtener la posición del evento táctil en relación a la vista padre
                        int x = (int) motionEvent.getRawX() - horizontalLayout.getLeft();

                        // Asegurarse de que la posición esté dentro de los límites de la vista de la barra
                        if (x < 0) {
                            x = 0;
                        } else if (x > horizontalLayout.getWidth()) {
                            x = horizontalLayout.getWidth();
                        }

                        // Actualizar la posición de la vista de la barra
                        horizontalBarView.setX(x);
                        horizontalValueTextView.setText(String.valueOf(x));

                        return true;

                    case MotionEvent.ACTION_UP:
                        // Devolver la vista de la barra a su posición central
                        horizontalBarView.setX(horizontalLayout.getWidth() / 2);
                        horizontalValueTextView.setText(String.valueOf(horizontalLayout.getWidth() / 2));

                        return true;
                }
                return false;
            }
        });
    }
}


