package com.example.examenp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.*;
import android.content.Intent;
import android.widget.*;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements OnClickListener {
    EditText jeColor,jeItera;
    TextView jtxValid;
    Button jbn;
    Bundle bdl;
    Intent itn;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jtxValid = (TextView) findViewById(R.id.xtValid);
        jeColor = (EditText) findViewById(R.id.xEcolor);
        jeItera = (EditText) findViewById(R.id.xItera);
        jbn = (Button) findViewById(R.id.xButton);
        jbn.setOnClickListener(this);
    }
    public void onClick(View arg0) {
        int n=0;
        n = Integer.parseInt(jeItera.getText().toString());
        if(jeColor.getText().toString() == "rojo" ||jeColor.getText().toString() == "Rojo" || jeColor.getText().toString() == "Azul" || jeColor.getText().toString() == "azul"
        || jeColor.getText().toString() == "Verde" || jeColor.getText().toString() == "Verde" || (n>=10000 && n<=1000000)) {
            itn = new Intent(MainActivity.this, SegundaActivity.class);
            bdl = new Bundle();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb1.append(jeColor.getText().toString());
            bdl.putString("Color",sb1.toString());
            sb2.append(jeItera.getText().toString());
            bdl.putString("Itera",sb2.toString());

            itn.putExtras(bdl);
            startActivity(itn);
        }
        else {
            jtxValid.setText(" ");
            jtxValid.setText("\nIngrese un valor valido en color: (Rojo,verde o azul) o bien un numero entre 10,000 y 1,000,000\n");
        }
    }


}