package com.example.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SensorListAdapter extends ArrayAdapter<Sensor> implements SensorEventListener {

    private final Context context;
    private final List<Sensor> sensors;
    private final List<float[]> sensorList;

    public SensorListAdapter(Context context, List<Sensor> sensors) {
        super(context, 0, sensors);
        this.context = context;
        this.sensors = sensors;
        sensorList = new ArrayList<>();
        for (Sensor sensor : sensors) {
            sensorList.add(null);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.sensor_list_item, parent, false);
        ImageView sensorImage = rowView.findViewById(R.id.sensor_image);
        TextView sensorName = rowView.findViewById(R.id.sensor_name);
        TextView sensorValue = rowView.findViewById(R.id.sensor_value);

        Sensor sensor = sensors.get(position);
        sensorName.setText(sensor.getName());
        sensorImage.setImageResource(getSensorImageResource(sensor.getType()));

        float[] currentValues = sensorList.get(position);
        if (currentValues == null) {
            currentValues = new float[sensor.getMaxDelay()];
            sensorList.set(position, currentValues);
        }

        if (sensor.getType() == Sensor.TYPE_LIGHT) {
            sensorValue.setText(String.format("%.3f", currentValues[0]));
        } else {
            sensorValue.setText(String.format("%.3f, %.3f, %.3f", currentValues[0], currentValues[1], currentValues[2]));
        }

        return rowView;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorIndex = sensors.indexOf(event.sensor);
        if (sensorIndex != -1) {
            float[] sensorValues = event.values.clone();
            sensorList.set(sensorIndex, sensorValues);
            notifyDataSetChanged();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do nothing
    }

    private int getSensorImageResource(int sensorType) {
        switch (sensorType) {
            case Sensor.TYPE_ACCELEROMETER:
                return R.drawable.accelerometer;
            case Sensor.TYPE_GRAVITY:
                return R.drawable.gravity;
            case Sensor.TYPE_GYROSCOPE:
                return R.drawable.gyroscope;
            case Sensor.TYPE_LIGHT:
                return R.drawable.light;
            case Sensor.TYPE_MAGNETIC_FIELD:
                return R.drawable.magnetometer;
            case Sensor.TYPE_ORIENTATION:
                return R.drawable.orientation;
            case Sensor.TYPE_PRESSURE:
                return R.drawable.pressure;
            case Sensor.TYPE_PROXIMITY:
                return R.drawable.proximity;
            case Sensor.TYPE_ROTATION_VECTOR:
                return R.drawable.rotation;
            default:
                return R.drawable.sensor;
        }
    }
}