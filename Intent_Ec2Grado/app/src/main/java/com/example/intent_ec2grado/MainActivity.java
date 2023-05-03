package com.example.intent_ec2grado;

import android.app.*;
import android.os.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;

import java.text.DecimalFormat;


public class MainActivity extends Activity implements OnClickListener{

    EditText jetA,jetB, jetC;

    Button jbnC, jbnL;
    TextView jtvR,jtvN;
    Bundle bdl;
    Intent itn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jetA= (EditText)findViewById(R.id.xetA);
        jetB= (EditText)findViewById(R.id.xetB);
        jetC= (EditText)findViewById(R.id.xetC);
        jbnC=(Button)findViewById(R.id.xbnC);
        jbnC.setOnClickListener(this);

        //String cadena=jetA.getText().toString();

        jetA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().equals("")){
                    jbnC.setEnabled(false);
                }else {
                    jbnC.setEnabled(true);
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().equals("")){
                    jbnC.setEnabled(false);
                }else {
                    jbnC.setEnabled(true);
                }
            }
        });
        jetB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().equals("")){
                    jbnC.setEnabled(false);
                }else {
                    jbnC.setEnabled(true);
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().equals("")){
                    jbnC.setEnabled(false);
                }else {
                    jbnC.setEnabled(true);
                }
            }
        });
        jetC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().equals("")){
                    jbnC.setEnabled(false);
                }else {
                    jbnC.setEnabled(true);
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().equals("")){
                    jbnC.setEnabled(false);
                }else {
                    jbnC.setEnabled(true);
                }
            }
        });


    }
    public void onClick(View v){
        if(v.getId()==jbnC.getId()){
            itn = new Intent(MainActivity.this, SegundaActivity.class);
            bdl = new Bundle();
            double a=0,b=0,c = 0;
            a=Double.parseDouble(jetA.getText().toString());
            b=Double.parseDouble(jetB.getText().toString());
            c=Double.parseDouble(jetC.getText().toString());
            bdl.putDouble("a",a);
            bdl.putDouble("b",b);
            bdl.putDouble("c",c);

            itn.putExtras(bdl);
            startActivity(itn);


        }


    }



}

/*   public void ecuacion(double a, double b, double c){
        double x1=0, x2=0, x3=0;
        DecimalFormat i1 = new DecimalFormat("0.00");
        DecimalFormat i2 = new DecimalFormat("0.00");
        DecimalFormat i3 = new DecimalFormat("0.00");




        if (b*b==4*a*c){
        x1=((-b)+Math.sqrt((b*b-4*a*c)))/(2*a);
        x2=((-b)-Math.sqrt((b*b-4*a*c)))/(2*a);
        jtvR.setText("Resultados x1: " +String.valueOf(x1)+"Resultados x2: "+String.valueOf(x2));
        }else{
        x1=(Math.sqrt(b*b-4*a*c)*-1)/(2*a);
        x1=-(Math.sqrt(b*b-4*a*c)*-1)/(2*a);
        x3= (-b)/(2*a);
        jtvR.append("Restultados x1: "+ i3.format(x3)+"+"+i1.format(x1)+"j\n");
        jtvR.append("Restultados x2: "+ i3.format(x3)+"+"+i2.format(x2)+"j");
        }




        }*/