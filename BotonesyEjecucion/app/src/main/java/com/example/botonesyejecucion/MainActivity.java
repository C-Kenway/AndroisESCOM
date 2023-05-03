package com.example.botonesyejecucion;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    Button jbn1,jbn2,jbn3,jbn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jbn1 = (Button) findViewById(R.id.xbn1);

        jbn2 = (Button)findViewById(R.id.xbn2);	// MÉTODO 2
        jbn2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                showToastMessage("Botón digitado: xbn2\nUtiliza: new OnClickListener{}");
            }
        });

        jbn3 = (Button) findViewById(R.id.xbn3); // MÉTODO 3
        jbn3.setOnClickListener(this);
    }
    private OnClickListener bn1Listener = new OnClickListener() {
        public void onClick(View v) {
            showToastMessage("Botón digitado: xbn1\nUtiliza: clase btn1Listener");
        }
    };
    private void showToastMessage(String msg){
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClick(View v) {
        showToastMessage("Botón digitado: xbn3\nUtiliza: implements OnClickListener.");
    }

    public void xbn4DesdeXML(View v) { // MÉTODO 4
        showToastMessage("Boton digitado: xbn4\nInvoca al método desde el XML.");
    }


}