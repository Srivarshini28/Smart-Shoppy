package com.example.smartshoppy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SriStoresActivity extends AppCompatActivity {

    Button sriCheckin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sri_stores);

        sriCheckin=(Button) findViewById(R.id.btn_sriStores);

        sriCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CheckInActivity.class);
                startActivity(intent);

            }
        });
    }
}