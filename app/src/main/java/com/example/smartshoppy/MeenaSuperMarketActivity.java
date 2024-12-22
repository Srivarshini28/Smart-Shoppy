package com.example.smartshoppy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MeenaSuperMarketActivity extends AppCompatActivity {

    Button meenaCheckin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meena_super_market);

        meenaCheckin=findViewById(R.id.btn_meenaStores);

        meenaCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CheckInActivity.class);
                startActivity(intent);
            }
        });
    }
}