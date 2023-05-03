package com.example.ejercicio14_lienzopixel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    private MyView myView;

    //Esto es como con el Canvas
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        myView = new MyView(this);
        setContentView(myView);
    }
}