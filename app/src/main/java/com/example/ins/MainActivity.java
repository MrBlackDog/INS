package com.example.ins;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensorACC;
    TextView  tvx;
    TextView  tvy;
    TextView  tvz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorACC = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (sensorACC != null) {
            sensorManager.registerListener(this, sensorACC,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            tvx = findViewById(R.id.textView1);
            tvy = findViewById(R.id.textView3);
            tvz = findViewById(R.id.textView2);

            tvx.setText(String.valueOf(event.values[0]));
            tvy.setText(String.valueOf(event.values[1]));
            tvz.setText(String.valueOf(event.values[2]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
