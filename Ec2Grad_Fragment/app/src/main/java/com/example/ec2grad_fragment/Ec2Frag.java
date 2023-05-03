package com.example.ec2grad_fragment;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
public class Ec2Frag extends Fragment {
    public final static int OK = 0;
    public final static int CANCEL = 1;
    private FragmentoListener fl;

    @Override
    public void onAttach(Activity a) {
        super.onAttach(a);
        if (a instanceof FragmentoListener) {
            fl = (FragmentoListener) a;
        }
    }

    public interface FragmentoListener {
        public void digitado(int resultado, String texto);
    }

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b) {
        View v = li.inflate(R.layout.activity_ec2grad, vg, false);
        ((Button) v.findViewById(R.id.xbnA)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                botonDigitado(v);
                Toast.makeText(getActivity(), "Desde MiFragmento",
                        Toast.LENGTH_LONG).show();
            }
        });
        ((Button) v.findViewById(R.id.xbnC)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                botonDigitado(v);
            }
        });
        return v;
    }

    public void botonDigitado(View v) {
        if (null == fl)
            return;
        if (((Button) v).getText().equals("Aceptar")) {
            String res = "";
            res = calcula();
            fl.digitado(OK, res);
        }
        else
            fl.digitado(CANCEL, "");
    }
    public String calcula (){
        String res;
        Double a,b,c;
        //int i = 0;

        /*Validacion de numero vacio y letras**/
        if(((EditText)
                getActivity().findViewById(R.id.xet1)).getText().toString().matches("")){
            a = 1.0;
        }else{
            if(Entero(((EditText)
                    getActivity().findViewById(R.id.xet1)).getText().toString()) == false){
                res= "No puedes ingresar letras";
                return res;
            }else {
                a = Double.parseDouble(((EditText)
                        getActivity().findViewById(R.id.xet1)).getText().toString());
            }
        }
        if (((EditText)
                getActivity().findViewById(R.id.xet2)).getText().toString().matches("")){
            b = 0.0;
        }else{
            if(Entero(((EditText)
                    getActivity().findViewById(R.id.xet2)).getText().toString()) == false){
                res= "No puedes ingresar letras";
                return res;
            }else{
                b = Double.parseDouble(((EditText)
                        getActivity().findViewById(R.id.xet2)).getText().toString());
            }
        }

        if (((EditText)
                getActivity().findViewById(R.id.xet3)).getText().toString().matches("")){
            c = 0.0;
        }else{
            if (Entero(((EditText)
                    getActivity().findViewById(R.id.xet3)).getText().toString()) == false){
                res="No puedes ingresar letras";

                return res;
            }else{
                c = Double.parseDouble(((EditText)
                        getActivity().findViewById(R.id.xet3)).getText().toString());
            }
        }

        res=calcular(a,b,c);
        return res;
    }
    public String calcular(Double a, Double b, Double c){
        StringBuffer res = new StringBuffer();
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

            res.append("X1= "+x1+"\nX2= "+x2);

        }
        return res.toString();
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

