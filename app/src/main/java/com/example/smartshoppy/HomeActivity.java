package com.example.smartshoppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CardView sriSores,Meena,Rk,Taekook,BTS,JKV,V,JK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sriSores=(CardView)findViewById(R.id.sriStores);
        Meena=(CardView)findViewById(R.id.meena);
        Rk=(CardView)findViewById(R.id.rk);
        Taekook=(CardView)findViewById(R.id.tk);
        BTS=(CardView)findViewById(R.id.bts);
        JKV=(CardView)findViewById(R.id.jkv);
        V=(CardView)findViewById(R.id.bwi);
        JK=(CardView)findViewById(R.id.ggukkie);



        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext(), CartActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        return true;

                    case R.id.Wallet:
                        startActivity(new Intent(getApplicationContext(), WalletActivity.class));
                        overridePendingTransition(0, 0);
                        return true;


                }
                return false;

            }

        });

        sriSores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SriStoresActivity.class);
                startActivity(intent);
            }
        });

        Meena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MeenaSuperMarketActivity.class);
                startActivity(intent);
            }
        });


        Rk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RkStoresActivity.class);
                startActivity(intent);
            }
        });

        Taekook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),TaekookActivity.class);
                startActivity(intent);
            }
        });


        BTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),BtsActivity.class);
                startActivity(intent);
            }
        });

        JKV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),JKVStoresActivity.class);
                startActivity(intent);
            }
        });

        V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),BwiActivity.class);
                startActivity(intent);
            }
        });

        JK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),GgukkieActivity.class);
                startActivity(intent);
            }
        });


    }
}


