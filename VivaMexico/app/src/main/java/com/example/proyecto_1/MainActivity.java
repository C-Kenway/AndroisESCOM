package com.example.proyecto_1;

import androidx.appcompat.app.*;

import android.os.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    TextView jtv1;
    EditText jet1;
    Button jbt1;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        jbt1 = (Button) findViewById(R.id.xbt1);
        jet1 = (EditText) findViewById(R.id.xet1);
        jtv1 = (TextView) findViewById(R.id.xtv1);

        jbt1.setOnClickListener(this);

        jtv1.setText("Hola ESCOM!!");

    }

    @Override
    public void onClick(View v) {

        jtv1.setText("Viva Mexico");
    }
}