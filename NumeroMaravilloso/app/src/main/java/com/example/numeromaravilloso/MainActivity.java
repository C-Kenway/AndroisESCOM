package com.example.numeromaravilloso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.*;
import android.app.*;
import android.view.View;
import android.widget.*;
import android.view.View.OnClickListener;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    EditText jetN;
    Button jbnC;
    TextView jtvR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jetN=(EditText) findViewById(R.id.xetN);
        jbnC=(Button) findViewById(R.id.xbnC);
        jtvR=(TextView)findViewById(R.id.xtvR);
        jbnC.setOnClickListener(this);
    }
    public void onClick(View v){
        jtvR.setText("");
        int validacion = Integer.parseInt(jetN.getText().toString());
        if(validacion<=1){
            jtvR.setText("Ingrese numero positivo");
        }else{
            Maravilloso();
        }

    }
    public void Maravilloso(){

        int n = Integer.parseInt(jetN.getText().toString());
        Integer numeros = 0;

        while(n!=1){
            if((n%2)==0){
                n=n/2;
                numeros=n;
                jtvR.append(numeros.toString());
            }
            else{
                n=n*3+1;
                jtvR.append(numeros.toString());
            }
        }
        if(n==1){
            jtvR.append("\n ES NUMERO MARAVILLOSO");
        }
    }
}