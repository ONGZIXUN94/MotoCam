package com.example.dqw648.motocam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //String
    String name,id,phone;

    //Button
    ImageButton btn_camera;

    //TextView
    TextView txt_id, txt_name, txt_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button
        btn_camera = (ImageButton) findViewById(R.id.btn_camera);

        //TextView
        txt_id = (TextView) findViewById(R.id.txt_id);
        txt_name = (TextView) findViewById(R.id.txt_name);
        txt_phone = (TextView) findViewById(R.id.txt_phone);

        //Getting data from CameraView
        if(savedInstanceState == null){
            Bundle data = this.getIntent().getExtras();
            if(data == null){
                name = null;
                id = null;
                phone = null;
            }else{
                name = data.getString("name");
                id = data.getString("id");
                phone = data.getString("phone");

                txt_id.setText(id);
                txt_name.setText(name);
                txt_phone.setText(phone);
            }
        }

        //Buttons
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera_view = new Intent(MainActivity.this, CameraView.class);
                startActivity(camera_view);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
