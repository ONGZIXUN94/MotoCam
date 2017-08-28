package com.example.dqw648.motocam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CameraView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_view);

        identity_recorgnized("ONG ZI XUN", "DQW648", "+60173702581");
    }

    //Camera Recorgnizer has been recorgnized the identity of first responer
    public void identity_recorgnized(String name, String id, String phone){

        Intent identity_result = new Intent(CameraView.this, MainActivity.class);
        identity_result.putExtra("name", name);
        identity_result.putExtra("id", id);
        identity_result.putExtra("phone", phone);
        startActivity(identity_result);
    }
}
