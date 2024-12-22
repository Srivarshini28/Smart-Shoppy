package com.example.smartshoppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    RecyclerView recview;
    TextView rateview;

    Button chkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().hide();

        rateview=findViewById(R.id.rateview);
        getroomdata();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.cart);

        chkout=(Button)findViewById(R.id.checkout);

        chkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),WalletActivity.class);
                startActivity(intent);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cart:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.Wallet:
                        startActivity(new Intent(getApplicationContext(), WalletActivity.class));
                        overridePendingTransition(0, 0);
                        return true;


                }
                return false;

            }

        });
    }
    public void getroomdata()
    {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "cart_db").allowMainThreadQueries().build();
        ProductDao productDao = db.ProductDao();

        recview=findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        List<Product> products=productDao.getallproduct();

        myadapter adapter=new myadapter(products, rateview);
        recview.setAdapter(adapter);

        int sum=0,i;
        for(i=0;i< products.size();i++)
            sum=sum+(products.get(i).getPrice()*products.get(i).getQnt());

        rateview.setText("Total Amount : INR "+sum);


    }
}
