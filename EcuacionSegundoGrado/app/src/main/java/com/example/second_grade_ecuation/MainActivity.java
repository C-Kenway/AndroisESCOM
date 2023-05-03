package com.example.second_grade_ecuation;

import androidx.appcompat.app.*;
import android.os.*;
import android.view.View;
import android.widget.*;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    EditText jet1, jet2, jet3;
    Button jbtnC;
    TextView jtvR;

    Boolean imaginario = false;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jet1 = (EditText) findViewById(R.id.xet1);
        jet2 = (EditText) findViewById(R.id.xet2);
        jet3 = (EditText) findViewById(R.id.xet3);
        jbtnC = (Button) findViewById(R.id.xbt1);
        jtvR = (TextView) findViewById(R.id.xtv1);

        jbtnC.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        jtvR.setText("");

        Double a,b,c;
        //int i = 0;

        /*Validacion de numero vacio y letras**/
        if(jet1.getText().toString().matches("")){
            a = 1.0;
        }else{
            if(Entero(jet1.getText().toString()) == false){
                jtvR.setText("No puedes ingresar letras");
                return;
            }else {
                a = Double.parseDouble(jet1.getText().toString());
            }
        }
        if (jet2.getText().toString().matches("")){
            b = 0.0;
        }else{
            if(Entero(jet2.getText().toString()) == false){
                jtvR.setText("No puedes ingresar letras");
                return;
            }else{
                b = Double.parseDouble(jet2.getText().toString());
            }
        }

        if (jet3.getText().toString().matches("")){
            c = 0.0;
        }else{
            if (Entero(jet3.getText().toString()) == false){
                jtvR.setText("No puedes ingresar letras");
                return;
            }else{
                c = Double.parseDouble(jet3.getText().toString());
            }
        }

        calcular(a,b,c);

    }

    public void calcular(Double a, Double b, Double c){
        if (a!=0){
            double d=b*b-4*a*c;
            double parte1=-b/(2*a);
            double d2=(d>=0)?d:-d;
            double parte2=Math.sqrt(d2)/(2*a);

            String x1="", x2="";
            if(d<0){
                parte1=(double)Math.round(parte1*100d)/100;
                parte2=(double)Math.round(parte2*100d)/100;


                x1+=(parte1==0)?"":parte1;
                x1+="+";
                x1+=(parte2==1)?"":parte2;
                x1+="i";

                x2+=(parte1==0)?"":parte1;
                x2+="-";
                x2+=(parte2==1)?"":parte2;
                x2+="i";


            }else if (d==0){
                x1+=(double)Math.round(parte1*100d)/100;
                x2+=(double)Math.round(parte2*100d)/100;

            }else {
                x1+=((-b)+Math.sqrt((b*b-4*a*c)))/(2*a);
                x2+=((-b)-Math.sqrt((b*b-4*a*c)))/(2*a);

            }
            jtvR.append("X1= "+x1+"\n");
            jtvR.append("X2= "+x2);
        }
    }

    public Boolean Entero(String cadena){
        Boolean resultado = true;

        for(int i=0; i<cadena.length(); i++){
            if(Character.isDigit(cadena.charAt(i))==false && cadena.charAt(0)!='-' || (cadena.charAt(0)=='-' && Character.isDigit(cadena.charAt(1))==false )){
                resultado = false;
                break;
            }
        }

        return resultado;
    }
}