package com.example.smartshoppy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GgukkieActivity extends AppCompatActivity {

    Button ggukCheckin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ggukkie);

        ggukCheckin=(Button) findViewById(R.id.btn_ggukStores);

        ggukCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CheckInActivity.class);
                startActivity(intent);

            }
        });
    }
}