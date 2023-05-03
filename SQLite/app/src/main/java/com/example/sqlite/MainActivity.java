package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity { EditText	jetI, jetN;
    Button	jbnA, jbnL,jbnDel,jbnUpd;
    TextView jtvL; SQLiteDatabase sqld; @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jetI = (EditText) findViewById(R.id.xetI);
        jetN = (EditText) findViewById(R.id.xetN);
        jbnA = (Button) findViewById(R.id.xbnA);
        jbnDel = (Button)findViewById(R.id.xbnDel);
        jbnUpd = (Button)findViewById(R.id.xbnUpd);
        jbnL = (Button) findViewById(R.id.xbnL);
        jtvL = (TextView) findViewById(R.id.xtvL);


        DbmsSQLiteHelper dsqlh = new DbmsSQLiteHelper(this, "DBContactos", null, 1);

        sqld = dsqlh.getWritableDatabase();

        jbnA.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String	id = jetI.getText().toString();
                String	nombre = jetN.getText().toString();
                ContentValues	cv = new ContentValues();
                cv.put("id", id);
                cv.put("nombre", nombre);
                sqld.insert("Contactos", null, cv);
                jetI.setText("");
                jetN.setText("");
            }
        });

        jbnDel.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String id = jetI.getText().toString();
                sqld.delete("Contactos","id=?",new String[]{id});
                jtvL.setText("");
                }
            });

        jbnUpd.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String	id = jetI.getText().toString();
                String	nombre = jetN.getText().toString();
                ContentValues	cv = new ContentValues();
                cv.put("id", id);
                cv.put("nombre", nombre);
                sqld.update("Contactos", cv,"id=?",new String[]{id});
                jetI.setText("");
                jetN.setText("");
            }
        });

        jbnL.setOnClickListener(new OnClickListener() {
            public void onClick(View v) { String id, nombre;
                Cursor c = sqld.rawQuery("SELECT id,nombre FROM Contactos", null);
                jtvL.setText("");
                if (c.moveToFirst()) {
                    do {
                        id = c.getString(0); nombre = c.getString(1);
                        jtvL.append(" " + id + "\t" + nombre + "\n");
                    } while(c.moveToNext());
                }
            }
        });


    }
}
