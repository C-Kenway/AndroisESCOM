package com.example.ejercicio11_sensoresfinal;

import android.app.Activity;
import android.hardware.Sensor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.hardware.*;
import android.content.Context;

import java.util.*;

public class MainActivity extends Activity {
    TextView jtv;
    ListView lv;
    Sensor s;
    SensorManager sm;
    List <Sensor> ls;
    String c,v;
    Integer n,t;
    Float p,r,d;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.listado);

        ArrayList<ListaEntrada> al = new ArrayList<ListaEntrada>();
        jtv = (TextView) findViewById(R.id.xtv);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        ls = sm.getSensorList(Sensor.TYPE_ALL);
        jtv.setText("\nSensores detectados: " + ls.size() + "\n");
        for (int i =0; i<ls.size();i++){
            s = ls.get(i);
            al.add(new ListaEntrada(R.drawable.ace,s.getName(),s.getVendor()));
        }

        lv = (ListView) findViewById(R.id.xlv_listado);
        lv.setAdapter(new ListaAdapter(this, R.layout.activity_main, al) {
            @Override
            public void onEntrada(Object o, View v) {
                if( o != null){
                    TextView texto_superior = (TextView) v.findViewById(R.id.textView_superior);
                    if(texto_superior != null ){
                        texto_superior.setText(((ListaEntrada) o).get_textArriba());
                    }
                    TextView text_inferior = (TextView) v.findViewById(R.id.textView_inferior);
                    if (text_inferior != null){
                        text_inferior.setText(((ListaEntrada) o).get_textDebajo());
                    }
                    ImageView imagen = (ImageView) v.findViewById(R.id.imageView_imagen);
                    if (imagen != null){
                        imagen.setImageResource((((ListaEntrada) o).get_idImagen()));
                    }
                }
            }
        });

        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> av, View view, int i, long l) {
                ListaEntrada le = (ListaEntrada) av.getItemAtPosition(i);
                CharSequence cs = "Seleccionado: " + le.get_textDebajo();
                Toast t = Toast.makeText(MainActivity.this, cs, Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }
}