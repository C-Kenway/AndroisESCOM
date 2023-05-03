package com.example.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private SensorListAdapter sensorListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView sensorListView = findViewById(R.id.sensor_list_view);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        sensorListAdapter = new SensorListAdapter(this, sensors);
        sensorListView.setAdapter(sensorListAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (int i = 0; i < sensorListAdapter.getCount(); i++) {
            Sensor sensor = sensorListAdapter.getItem(i);
            sensorManager.registerListener(sensorListAdapter, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorListAdapter);
    }

    private String formatFloatValue(float value) {
        return String.format("%.3f", value);
    }
}