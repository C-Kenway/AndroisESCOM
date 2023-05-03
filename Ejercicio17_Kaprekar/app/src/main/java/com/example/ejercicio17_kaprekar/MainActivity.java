package com.example.ejercicio17_kaprekar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.*;
import android.view.View.*;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    public EditText e1;
    public Button jbtn;
    public TextView jtv;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.ent);

        jbtn = (Button) findViewById(R.id.cal);
        jbtn.setOnClickListener(this);

        jtv = (TextView) findViewById(R.id.res);
    }

    @Override
    public void onClick(View v) {
        jtv.setText("");
        Integer numero;
        String comparar = e1.getText().toString();

        //Comparo si la cadena esta vacia
        if(comparar.equals("")){
            numero = 0;
        //Comparo si lo que se ingreso es un numero, en caso de que no, muestro el Toast
        }else if (Character.isDigit(comparar.charAt(0)) == false){
            Toast.makeText(this,"No pueden ingresarse letras ni caracteres especiales",Toast.LENGTH_LONG).show();
            return;//Hago un return para que la variable no quede desinicializada
        }else if(Integer.parseInt(comparar) < 3){
            Toast.makeText(this, "Porfavor ingresa un numero mayor a 3",Toast.LENGTH_LONG).show();
            return;
        }else{
            numero = Integer.parseInt(comparar);
        }
        elevar(numero);
    }

    public void elevar(Integer numero){
        //Hago un casteo, porque pow regresa un tipo de dato Double
        Integer resultado = (int)Math.pow(numero,2);
        //Aqui se realiza polimorfismo, creamos una lista generica, pero la instanciamos con su clase ArrayList
        List<Integer> numeros = new ArrayList<>();

        for(int i =0; i < resultado.toString().length(); i++){
            //Agrego los dijitos por separado a la lista
            numeros.add(Character.getNumericValue(resultado.toString().charAt(i)));
        }

        separar(numeros, numero);
    }

    public void separar(List<Integer> lista, Integer numero){

        Integer suma;
        List<Integer> aux1 = new ArrayList<>();
        List<Integer> aux2 = new ArrayList<>();

        for(int i=0; i<lista.size(); i++){
            if(i<lista.size()-numero.toString().length()){
                aux1.add(lista.get(i));
            }else{
                aux2.add(lista.get(i));
            }
        }

        jtv.append(aux1 + "\n");
        jtv.append(aux2 + "\n");
        jtv.append(lista+ "\n");

        suma = sumar(aux1,aux2);

        jtv.append(numero.toString() +" = " + suma.toString() + "\n");

        //Lo hice con Strings porque si no, se desborda la memoria por el tipo de dato
        if(suma.toString().equals(numero.toString())){
            jtv.append("\nKaprekar\n");
        }else{
            jtv.append("\nNO Kaprekar\n");
        }

    }

    public Integer sumar(List<Integer>l1, List<Integer>l2){
        String aux1 = "";
        String aux2 = "";
        Integer resultado;

        //Bucle para unir todos los numeros en uno solo
        for(Integer n: l1){
            aux1 = aux1 + n.toString();
        }

        jtv.append("\n" + aux1);

        //Bucle para unir todos los numeros en uno solo
        for (Integer n: l2){
            aux2 = aux2 + n.toString();
        }

        jtv.append("\n" + aux2 + "\n");

        resultado = Integer.parseInt(aux1) + Integer.parseInt(aux2);

        return resultado;
    }
}