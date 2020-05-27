package com.example.dangky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Main2Activity extends AppCompatActivity {

    Button btTieptuc2;
    Button btTieptuc23;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btTieptuc2 = (Button) findViewById(R.id.btTieptuc2);
        btTieptuc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mh3 = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(mh3);
            }
        });
        btTieptuc23 = (Button) findViewById(R.id.btTieptuc23);
        btTieptuc23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backmh1 = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(backmh1);
            }
        });
    }
}
