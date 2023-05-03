package com.example.examenp1;


import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
public class SegundaActivity extends Activity{
    EditText jet;
    Bundle bdl;
    public void onCreate(Bundle b){
        super.onCreate(b);
        ImageView imagen_entrada = (ImageView)findViewById(R.id.imageView_imagen);
        setContentView(R.layout.activity_segunda);
        jet = (EditText) findViewById(R.id.xet1);
        bdl = getIntent().getExtras();
        String color;
        color = bdl.getString("Color");
        jet.append("\nColor: \n" + color);
        jet.append("\nIteraciones: \n" + bdl.getString("Itera"));
        //Para poner las imagenes
       // imagen_entrada.setImageResource((R.drawable.azul));
        //imagen_entrada.setImageResource((R.drawable.verde));
        //imagen_entrada.setImageResource((R.drawable.rojo));
    }
}
