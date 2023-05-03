package com.example.intentos;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.*;
import android.content.Intent;
import android.widget.*;


public class MainActivity extends Activity implements OnClickListener{
    EditText jetNom,jetAp;
    Button jbn;
    Bundle bdl;
    Intent itn;
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jetNom = (EditText) findViewById(R.id.xetNom);
        jetAp = (EditText)findViewById(R.id.xetAp);
        jbn = (Button) findViewById(R.id.xbn);
        jbn.setOnClickListener(this);
    }
    public void onClick(View arg0) {
        itn = new Intent(MainActivity.this, SecondActivity.class);
        bdl = new Bundle();
        StringBuilder sb1 = new StringBuilder();
        sb1.append((jetNom.getText().toString())+" "+(jetAp.getText().toString()));
        bdl.putString("NOMBRE",sb1.toString());

        itn.putExtras(bdl);
        startActivity(itn);
    }
}