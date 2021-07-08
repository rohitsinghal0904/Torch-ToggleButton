package com.example.torchtogglebutton;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ToggleButton t1;
    CameraManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(ToggleButton)findViewById(R.id.toggleButton);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        t1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try{
                    if(isChecked) {
                        String s1 = cm.getCameraIdList()[0];
                        cm.setTorchMode(s1, true);
                    }
                    else{
                        String s1=cm.getCameraIdList()[0];
                        cm.setTorchMode(s1,false);
                    }
                }catch (CameraAccessException e){

                }
            }
        });
    }
}