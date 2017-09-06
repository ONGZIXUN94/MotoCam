package com.example.dqw648.motocam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //String
    private String name,id,phone;

    //Button
    private ImageButton btn_camera,btn_userinfo;
    private ImageView img_receive_snapshot;

    //TextView
    private TextView txt_id, txt_name, txt_phone;

    //ListView
    private ListView lv_identity;
    private ArrayList<String> strArr;
    private ArrayAdapter<String> Adapter;

    //variables
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button
        btn_camera = (ImageButton) findViewById(R.id.btn_camera);
        btn_userinfo = (ImageButton) findViewById(R.id.btn_userinfo);

        //TextView
        txt_id = (TextView) findViewById(R.id.txt_id);
        txt_name = (TextView) findViewById(R.id.txt_name);
        txt_phone = (TextView) findViewById(R.id.txt_phone);

        //ImageView
        img_receive_snapshot = (ImageView) findViewById(R.id.img_receive_snapshot); //Will used to set the snapshot image

        //ListView
        lv_identity = (ListView) findViewById(R.id.lv_identity);
        strArr = new ArrayList<String>();
        Adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, strArr);
        lv_identity.setAdapter(Adapter);

        //Buttons
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera_view = new Intent(MainActivity.this, CameraView.class);
                startActivity(camera_view);
            }
        });

        btn_userinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                Adapter.clear(); //clear the previous items
                strArr.add(count + "");
                Adapter.notifyDataSetChanged();
            }
        });

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
