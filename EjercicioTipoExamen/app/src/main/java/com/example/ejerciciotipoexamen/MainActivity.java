package com.example.ejerciciotipoexamen;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.view.View.OnClickListener;

import java.util.Collections;
import java.util.List;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnClickListener{

    EditText e1,e2,e3;
    Button jbt;
    TextView jtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.xet1);
        e2 = (EditText) findViewById(R.id.xet2);
        e3 = (EditText) findViewById(R.id.xet3);

        jbt = (Button) findViewById(R.id.xbtn);
        jbt.setOnClickListener(this);

        jtv = (TextView) findViewById(R.id.xtv1);
    }

    @Override
    public void onClick(View v) {
        jtv.setText("");
        List<Integer> numeros = new ArrayList<>();
        String p1,p2;
        Integer contador = 0;
        Double numero1,numero2, resultado;

        numeros.add(Integer.parseInt(e1.getText().toString()));
        numeros.add(Integer.parseInt(e2.getText().toString()));
        numeros.add(Integer.parseInt(e3.getText().toString()));

        while (contador < 7){
            contador++;

            Collections.sort(numeros,Collections.reverseOrder());
            List<Integer> auxdes = new ArrayList<>(numeros);
            jtv.append("\nOrden descendente:\n "+ numeros.toString());

            Collections.sort(numeros);
            List<Integer> auxasc = new ArrayList<>(numeros);
            jtv.append("\nOrden ascendente: \n " + numeros.toString());

            p1 = auxdes.get(0).toString() + auxdes.get(1).toString() + auxdes.get(2).toString();
            p2 = auxasc.get(0).toString() + auxasc.get(1).toString() + auxasc.get(2).toString();

            numero1 = Double.parseDouble(p1);
            numero2 = Double.parseDouble(p2);

            resultado = numero1 - numero2;

            jtv.append("\nOperacion: \n"+numero1.toString()+" - "+numero2.toString() +" = "+ resultado.toString());

            if(resultado == 954 || resultado == 594 || resultado == 495 || resultado == 549 || resultado == 945){

                for(int i = 0; i<3; i++) {
                    numeros.set(i, Character.getNumericValue(resultado.toString().charAt(i)));
                }
                ordenar(numeros);
                contador = 7;
            }else{
                /**Este ciclo es solo para reasignar numeros a la lista*/
                for(int i = 0; i<3; i++) {
                    numeros.set(i, Character.getNumericValue(resultado.toString().charAt(i)));
                }
            }
        }
    }

    public void ordenar(List<Integer> numeros){
        Collections.sort(numeros,Collections.reverseOrder());
        jtv.append("\nOrden descendente:\n "+ numeros.toString());

        Collections.sort(numeros);
        jtv.append("\nOrden ascendente: \n " + numeros.toString());
    }
}