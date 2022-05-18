package com.om.batterylevel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtBatteryLevel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBatteryLevel = findViewById(R.id.BatteryLevel);

        this.registerReceiver(this.myBatteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
         BroadcastReceiver myBatteryReceiver = new BroadcastReceiver() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onReceive(Context context, Intent intent) {
                int batteryLevel = intent.getIntExtra("level", 0);
                System.out.println("Battery Level : " + batteryLevel);
                //we can also write like this
                txtBatteryLevel.setText("Battery Level is at : " + batteryLevel + "%");

            }
        };
    }
