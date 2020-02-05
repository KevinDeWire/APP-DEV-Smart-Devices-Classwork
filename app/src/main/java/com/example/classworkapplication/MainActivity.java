package com.example.classworkapplication;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

TextView sensorValue;
SensorEvent sensorEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Main Activity", "onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorValue = findViewById(R.id.sensorReadingTextView);

        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener((SensorEventListener) sensorEvent, lightSensor,SensorManager.SENSOR_DELAY_NORMAL);

        List<Sensor> mSensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.activity_listview, mSensorList);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Main Activity", "onStart");
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Main Activity", "onResume");
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Main Activity", "onPause");
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Main Activity", "onRestart");
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Main Activity", "onStop");
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Main Activity", "onDestroy");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    public static final String EXTRA_MESSAGE = "com.example.classworkapplication.MESSAGE";


    private class SensorActivity implements SensorEventListener {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float lux = event.values[0];
            sensorValue.setText(String.valueOf(lux));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }
}
