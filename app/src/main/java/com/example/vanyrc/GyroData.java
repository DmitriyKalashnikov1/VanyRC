package com.example.vanyrc;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class GyroData implements SensorEventListener{

    private final SensorManager mSensorManager;
    private final Sensor mGyro;
    private final MainActivity ma;

    public GyroData(SensorManager sm, MainActivity ma){
        mSensorManager = sm;
        mGyro = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        this.ma = ma;
    }


    protected void onResume() {
        mSensorManager.registerListener(this, mGyro, SensorManager.SENSOR_DELAY_NORMAL);
    }
    protected void onPause() {
        mSensorManager.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        ma.updateGyroData(event.values);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

