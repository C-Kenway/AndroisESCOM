package com.example.ordenarnumeros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    TextView jtv, jtv1,jtvR;
    EditText jet, jet1;
    Button jbn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        jtv = (TextView) findViewById(R.id.xtv);
        jet = (EditText) findViewById(R.id.xet);
        jtv1 = (TextView) findViewById(R.id.xtv1);
        jet1 = (EditText) findViewById(R.id.xet1);
        jtvR = (TextView)findViewById(R.id.xtvR);
        jbn = (Button) findViewById(R.id.xbn);
        jbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numeros[];
                int n = Integer.parseInt(String.valueOf(jet.getText()));
                numeros = new int[n];
                for (int i = 1; i <= n; i++) {
                    jtv1.setText("☺ Ingresa el numero en la posicion: " + i + "\n");
                    numeros[i] = Integer.parseInt(String.valueOf(jet.getText()));
                }
                ordenar(numeros);
            }
        });
    }


    public void ordenar(int numeros[]){

        for (int i = 1; i <= numeros.length; i++) {
            jtvR.setText(numeros[i]);
        }
    }
}