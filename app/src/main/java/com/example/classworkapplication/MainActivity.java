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

public class MainActivity extends AppCompatActivity implements SensorEventListener {

TextView xValue;
TextView yValue;
TextView zValue;
Sensor gravitySensor;
SensorManager sensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Main Activity", "onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        xValue = findViewById(R.id.xValue);
        yValue = findViewById(R.id.yValue);
        zValue = findViewById(R.id.zValue);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);


        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.activity_listview, sensorList);
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
        sensorManager.registerListener(this, gravitySensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Main Activity", "onPause");
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        sensorManager.unregisterListener(this);
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

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        xValue.setText(Float.toString(x));
        yValue.setText(Float.toString(y));
        zValue.setText(Float.toString(z));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
