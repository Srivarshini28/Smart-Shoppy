package com.example.smartshoppy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JKVStoresActivity extends AppCompatActivity {

    Button jkvBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jkvstores);

        jkvBtn=(Button) findViewById(R.id.btn_jkvStores);

        jkvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CheckInActivity.class);
                startActivity(intent);

            }
        });
    }
}