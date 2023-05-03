package com.example.cuadro_magico;

import androidx.appcompat.app.*;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.os.*;
import android.view.ViewGroup;
import android.widget.*;
import android.view.View.OnClickListener;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    EditText jet1;
    Button jbt1;

    TextView jtv1;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jet1 = (EditText) findViewById(R.id.xet1);
        jbt1 = (Button) findViewById(R.id.xbt1);
        jtv1 = (TextView) findViewById(R.id.prueba);
        jbt1.setOnClickListener(this);

    }

    public void generarTabla(Integer n){

        LinearLayout layout= (LinearLayout) findViewById(R.id.xly2) ;
        //LinearLayout layout = (LinearLayout) findViewById(R.id.xly1);

        if(verificar(n)){
            layout.removeAllViews();
            jtv1.setText("");

            int[][]cuadro = new int[n][n];

            rellenar(n,cuadro);

            TableLayout tabla = new TableLayout(this);

            for (int i=(n-1); i>=0; i--){

                /*Crea una fila y la instancia**/
                TableRow row = new TableRow(this);

                /*Generas un textView y la instancia**/
                for (int j=0; j<n;j++){
                    TextView celda = new TextView(this);
                    celda.setText(String.valueOf(cuadro[i][j]));
                    celda.setPadding(6,4,6,4);
                    row.addView(celda);
                }
                tabla.addView(row);
            }
            layout.addView(tabla);

        }else{
            layout.removeAllViews();
            jtv1.setText("Ingresa un numero impar");
        }
    }

    @Override
    public void onClick(View v) {
        generarTabla(Integer.parseInt(jet1.getText().toString()));}

    public Boolean verificar(Integer n){
        Boolean resultado = true;

        if(n%2 != 0){
            return resultado;
        }else{
            resultado = false;
            return resultado;
        }
    }

    public void rellenar(Integer n, int cuadro2[][]){
        int fila = n-1;
        int columna = n/2;
        cuadro2[fila][columna] = 1;

        for (int i = 2; i<= n*n; i++){
            if(cuadro2[(fila + 1) % n][(columna + 1)%n] == 0){
                fila = (fila + 1) % n;
                columna = (columna + 1) % n;
            }else{
                fila=(fila - 1 + n) % n;
            }
            cuadro2[fila][columna] = i;
        }
    }
}