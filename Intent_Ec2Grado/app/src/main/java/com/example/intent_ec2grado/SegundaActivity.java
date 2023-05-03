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

public class SegundaActivity extends Activity{

    TextView jtvR;
    Bundle bdl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        bdl = getIntent().getExtras();

        jtvR=(TextView)findViewById(R.id.xtvR);


        double a=0,b=0,c = 0;
        a=bdl.getDouble("a");
        b=bdl.getDouble("b");
        c=bdl.getDouble("c");

        jtvR.setText("");
        ecuacion(a, b, c);

    }



    public void ecuacion(double a, double b, double c){
        if (a!=0){
            double d=b*b-4*a*c;
            double parte1=-b/(2*a);
            double d2=(d>=0)?d:-d;
            double parte2=Math.sqrt(d2)/(2*a);

            String x1="", x2="";
            if(d<0){
                parte1=(double)Math.round(parte1*100d)/100;
                parte2=(double)Math.round(parte2*100d)/100;


                jtvR.append("Imaginarias y diferentes\n");
                x1+=(parte1==0)?"":parte1;
                x1+="+";
                x1+=(parte2==1)?"":parte2;
                x1+="i";

                x2+=(parte1==0)?"":parte1;
                x2+="-";
                x2+=(parte2==1)?"":parte2;
                x2+="i";


            }else if (d==0){
                jtvR.append("Unica o iguales \n");
                x1+=(double)Math.round(parte1*100d)/100;
                x2+=(double)Math.round(parte2*100d)/100;

            }else {
                jtvR.append("Reales y diferentes\n");
                x1+=((-b)+Math.sqrt((b*b-4*a*c)))/(2*a);
                x2+=((-b)-Math.sqrt((b*b-4*a*c)))/(2*a);

            }
            jtvR.append("X1= "+x1+"\n");
            jtvR.append("X2= "+x2);
        }
    }
}


