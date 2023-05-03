package com.example.ejercicio10_ordenamiento;

import androidx.appcompat.app.*;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.view.View.OnClickListener;

import java.util.Collections;
import java.util.List;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    EditText jet1,jet2,jet3,jet4;
    Button jbtn;
    TextView jtv;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jet1 = (EditText) findViewById(R.id.xet1);
        jet2 = (EditText) findViewById(R.id.xet2);
        jet3 = (EditText) findViewById(R.id.xet3);
        jet4 = (EditText) findViewById(R.id.xet4);

        jbtn = (Button) findViewById(R.id.xbtn);
        jbtn.setOnClickListener(this);

        jtv = (TextView) findViewById(R.id.xtv1);

    }

    @Override
    public void onClick(View v) {
        jtv.setText("");
        List<Integer> numeros = new ArrayList<>();
        List<Integer> resta = new ArrayList<>();

        numeros.add(Integer.parseInt(jet1.getText().toString()));
        numeros.add(Integer.parseInt(jet2.getText().toString()));
        numeros.add(Integer.parseInt(jet3.getText().toString()));
        numeros.add(Integer.parseInt(jet4.getText().toString()));

        Collections.sort(numeros,Collections.reverseOrder());
        List<Integer> aux2 = new ArrayList<>(numeros);
        jtv.append("\nOrden descendente: \n" + numeros.toString() + "\n");

        Collections.sort(numeros);
        List<Integer> aux1 = new ArrayList<>(numeros);
        jtv.append("Orden ascendente: \n" + numeros.toString() + "\n");

        for(int i = 0; i<aux1.size(); i++){
            resta.add(aux2.get(i) - aux1.get(i));
        }

        jtv.append("\n\nResta: " + resta);
    }
}