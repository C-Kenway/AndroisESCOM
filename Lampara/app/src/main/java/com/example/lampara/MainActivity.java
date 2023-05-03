package com.example.lampara;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.*;

public class MainActivity extends Activity {
    boolean edo = false;
    CameraManager camManager;
    String cameraId;
    Button btn;

    @Override
    protected void onStop() {
        super.onStop();
        if (camManager != null && cameraId != null) {
            try {
                camManager.setTorchMode(cameraId, false);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.buttonLam);

        // Comprobar si el dispositivo tiene cámara y si la tiene, obtener el id de la cámara trasera
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Log.e("err", "Móvil sin cámara.");
            Toast.makeText(this, "El dispositivo no tiene cámara.", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            String[] cameraIds = camManager.getCameraIdList();
            for (String id : cameraIds) {
                CameraCharacteristics characteristics = camManager.getCameraCharacteristics(id);
                int facing = characteristics.get(CameraCharacteristics.LENS_FACING);
                if (facing == CameraCharacteristics.LENS_FACING_BACK) {
                    cameraId = id;
                    break;
                }
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
            return;
        }

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (edo) {
                    // Apagar la linterna
                    try {
                        camManager.setTorchMode(cameraId, false);
                        Log.i("info", "Linterna OFF.");
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                    edo = false;
                } else {
                    // Encender la linterna
                    try {
                        camManager.setTorchMode(cameraId, true);
                        Log.i("info", "Linterna ON.");
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                    edo = true;
                }
            }
        });
    }

}