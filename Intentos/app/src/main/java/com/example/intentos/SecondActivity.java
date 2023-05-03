package com.example.intentos;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
public class SecondActivity extends Activity{
    EditText jet;
    Bundle bdl;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_sagunda);
        jet = (EditText) findViewById(R.id.xet1);
        bdl = getIntent().getExtras();
        jet.append("Hola " + bdl.getString("NOMBRE"));
    }
}
