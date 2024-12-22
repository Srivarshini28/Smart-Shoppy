package com.example.smartshoppy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BwiActivity extends AppCompatActivity {

    Button bwiCheckin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bwi);

        bwiCheckin = (Button) findViewById(R.id.btn_bwiStores);

        bwiCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CheckInActivity.class);
                startActivity(intent);

            }
        });

    }
}